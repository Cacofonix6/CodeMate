package metriccalculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.IfStatement;

import data.FileData;
import data.MethodData;
import data.MetricData;
import helper.Keys;

/**
 * This class represents a metric calculator calculating the depth of nested if
 * statements
 * 
 * @author Robert Toy
 * @date 27.05.2019
 * 
 */
public class MetricCalculator_DepthOfConditionalNesting extends MetricCalculator {

	public String metricKey = Keys.DEPTHOFCONDITIONALNESTING.toString();
	public String metricName = "Depth Of Conditional Nesting";

	public int getDepth(int depth, ASTNode node) {
		// works out max depth
		ASTNode currNode = node;
		if (currNode != null && currNode.toString().startsWith("if")) {
			// if current node is if statement
			depth++;
			while (currNode.getParent() != null) {
				// while parent node not null find parent node
				if (currNode.getParent() != null) {
					currNode = currNode.getParent();
				}
				if (currNode.getParent() != null) {
					currNode = currNode.getParent();
				}
				if (currNode != null && currNode.toString().startsWith("if")) {
					// if current node is if statement
					depth++;
				}
			}
		}
		return depth;

	}

	/**
	 * This method calculates the metric values for all provided files and stores
	 * the results in the provided files
	 */
	public void calculate(List<FileData> _fileData) {
		// for each file
		for (FileData fileData : _fileData) {
			// for each method
			for (MethodData methodData : fileData.getMethods()) {
				List<IfStatement> IfStatementList = new ArrayList<>();
				// Create a visitor to traverse the AST
				ASTVisitor IfStatementVisitor = new ASTVisitor() {

					@Override
					public boolean visit(IfStatement _node) {
						// add any IfStatements found to the list
						IfStatementList.add(_node);
						return true;
					}

				};// End of "visitor"
				methodData.getASTNode().accept(IfStatementVisitor);

				int depth = 0;
				for (IfStatement ifstate : IfStatementList) {
					// for each IfStatement in the list
					int tempDepth = 0;
					tempDepth = (getDepth(0, ifstate));
					if (tempDepth > depth) {
						depth = tempDepth;
						// find the max depth
					}
				}
				// get max depth for method
				MetricData metric = new MetricData(metricName, depth);
				String recommendation = "";
				if (depth > 3) {
					recommendation += "Detected: Nested if statements in this method exceed 3. ";
					recommendation += "Refactor code to reduce nesting if statements";
					metric.setRecommendation(recommendation);
				}

				metric.addTag("Complexity");

				methodData.addMetricData(metricKey, metric);

			}
		}
	}

}
