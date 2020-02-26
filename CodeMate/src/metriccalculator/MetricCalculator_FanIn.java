package metriccalculator;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import data.FileData;
import data.MethodData;
import data.MetricData;
import helper.Keys;

/**
 * This class represents a metric calculator calculating the fan in value
 * 
 * @author Fabian Krauthausen
 * @date 28.05.2019
 * 
 */
public class MetricCalculator_FanIn extends MetricCalculator {
	/** keys for possible retrieval of stored metrics from method data */
	private String metricKey = Keys.FANIN.toString();
	/** name for interpreter to use in report */
	private String metricName = "Method Fan In";

	/**
	 * This method calculates the metric values for all provided files and stores
	 * the results in the provided files
	 */
	public void calculate(List<FileData> fileData) {
		// calculate for each file
		for (FileData fd : fileData) {

			// calculate for each method data
			for (MethodData methodData : fd.getMethods()) {

				List<MethodDeclaration> methodDeclarationNodeList = new ArrayList<>();
				List<MethodInvocation> methodInvocationList = new ArrayList<>();

				MethodDeclaration currentMethodDeclaration = methodData.getASTNode();
				methodDeclarationNodeList.add(currentMethodDeclaration);
				String nameCurrentMethod = currentMethodDeclaration.getName().toString();
				String nameCurrentMethodClass = currentMethodDeclaration.resolveBinding().getDeclaringClass().getName()
						.toString();

				// find matching pairs and put them into a map
				int countInvocations = 0;
				String callerString = "";

				// Loop over all files to compare the current method declaration against
				for (FileData fdInner : fileData) {

					// clear method invocation list for each inner file
					methodInvocationList.clear();

					// get all method invocations of the inner file
					ASTVisitor methodInvocationVisitor = new ASTVisitor() {
						@Override
						public boolean visit(MethodInvocation node) {
							methodInvocationList.add(node);
							return super.visit(node);
						}
					};

					// send the visitor through the tree
					fdInner.getASTNode().accept(methodInvocationVisitor);

					// loop over all method invocations per inner file
					for (MethodInvocation currentMethodInvocation : methodInvocationList) {

						// skip for method invocations without corresponding binding
						if (currentMethodInvocation.resolveMethodBinding() == null)
							continue;

						String nameCurrentInvocationCallingMethod = currentMethodInvocation.resolveMethodBinding()
								.getName().toString();
						String nameCurrentInvocationCallingClass = currentMethodInvocation.resolveMethodBinding()
								.getDeclaringClass().getName().toString();
						String nameCurrentInvocationClass = fdInner.getName().toString();
						int lineOfInvocation = fdInner.getASTNode()
								.getLineNumber(currentMethodInvocation.getName().getStartPosition());

						if (compare(nameCurrentMethodClass, nameCurrentMethod, nameCurrentInvocationCallingClass,
								nameCurrentInvocationCallingMethod)) {
							countInvocations++;
							// add recommendation
							callerString += "(" + "Class " + nameCurrentInvocationClass + " - line " + lineOfInvocation
									+ ") ";
						}
					}
				}

				// create a metric for the MethodData to save
				MetricData metric = new MetricData(metricName, countInvocations);

				// add related quality attributes
				metric.addTag("Maintainability");
				metric.addTag("Extendability");

				// do meta analysis per current method declaration
				metric = metaAnalysis(metric, countInvocations, nameCurrentMethod, callerString);

				// add metric to corresponding method in file
				methodData.addMetricData(metricKey, metric);

				// reset value for next method
				countInvocations = 0;

			}
		}

		// meta Analysis to find max fan in
		findMaxFanIn(fileData);
	}

	/**
	 * This method finds method invocation for current method declaration by
	 * comparing the method name and class of the current method declaration with
	 * the method name and class of the method the method invocation invokes as the
	 * method name is unique per class
	 * 
	 * @param className       The class name of the current method declaration
	 * @param methodName      The method name of the current method declaration
	 * @param otherClassName  The class name of the method the method invocation
	 *                        invokes
	 * @param otherMethodName The method name of the method the method invocation
	 *                        invokes
	 * @return The boolean result if the both methods are the same or not
	 */
	private boolean compare(String className, String methodName, String otherClassName, String otherMethodName) {
		if (className.equalsIgnoreCase(otherClassName) && methodName.equalsIgnoreCase(otherMethodName)) {
			return true;
		}
		return false;
	}

	/**
	 * @param metric           The metric on which the meta analysis is performed on
	 * @param countInvocations The count of invocations for the current method
	 *                         declaration
	 * @param callerString     The names of the method invocations invoking the
	 *                         current method declaration
	 * @return The metric containing the recommendation in accordance to its count
	 *         invocation value
	 */
	private MetricData metaAnalysis(MetricData metric, int countInvocations, String nameCurrentMethod,
			String callerString) {

		// add recommendation
		String recommendation = "";

		// low value for non main functions
		if (countInvocations == 0 && !nameCurrentMethod.equalsIgnoreCase("main")) {
			recommendation = "Detected Code Smell: Dispensable Dead Code - Method is never called and loosely coupled to rest of design";
			recommendation += "\n      * Recommendation: Remove method";
			metric.setRecommendation(recommendation);
		}

		// add callers of method for developer to see what he can improve
		if (countInvocations > 0) {
			recommendation += "\n      * Is called by: " + callerString;
			metric.setRecommendation(recommendation);
		}

		return metric;
	}

	/**
	 * This method finds the maximum fan in value in the list of file data to
	 * provide a specific recommendation for this metric
	 * 
	 * @param fileData The list of file data to find the max value in
	 */
	private void findMaxFanIn(List<FileData> fileData) {
		float max = 0;
		MethodData methodMaxFanIn = null;

		// find method with highest fan in
		for (FileData fd : fileData) {
			for (MethodData md : fd.getMethods()) {
				if (max < md.getMetricData(metricKey).getValue()) {
					max = md.getMetricData(metricKey).getValue();
					methodMaxFanIn = md;
				}
			}
		}

		if (max >= 5) {
			String recommendation = "Detected Code Smell: Change Preventer - Method is called most and tightly coupled to rest of design. Changes will break most other locations in program";
			recommendation += "\n      * Recommendation: Consider merging class of this method with classes calling it most if not same class already, as they might implement a single responsibility";
			recommendation += methodMaxFanIn.getMetricData(metricKey).getRecommendation();

			methodMaxFanIn.getMetricData(metricKey).setRecommendation(recommendation);
		}
	}
}
