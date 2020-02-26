package metriccalculator;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.ConditionalExpression;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.SwitchCase;
import org.eclipse.jdt.core.dom.WhileStatement;
import data.FileData;
import data.MethodData;
import data.MetricData;
import helper.Keys;

/**
 * This class represents a metric calculator calculating the cyclomatic
 * complexity using the simplified cyclomatic complexity formula proposed by
 * McCabe (1976) For a program with the program flowgraph G, the cyclomatic
 * complexity v(G) is measured as: v(G) = 1 + d d : number of predicate nodes
 * (i.e., nodes with out degree other than 1) d represents number of loops in
 * the graph or number of decision points in the program
 * 
 * @author Fabian Krauthausen
 * @date 26.05.2019
 * 
 */
public class MetricCalculator_CyclomaticComplexity extends MetricCalculator {
	/** keys for possible retrieval of stored metrics from method data */
	private String metricKey = Keys.CYCLOMATICCOMPLEXITY.toString();
	/** name for interpreter to use in report */
	private String metricName = "Cyclomatic Complexity";

	/**
	 * This method calculates the metric values for all provided files and stores
	 * the results in the provided files
	 */
	public void calculate(List<FileData> fileData) {
		int cyclomaticComplexitiy = 0;

		// calculate for each file
		for (FileData fd : fileData) {
			
			// calculate for each method data
			for (MethodData md : fd.getMethods()) {

				// Lists of predicate nodes (decision points)
				List<IfStatement> ifStatmentNodeList = new ArrayList<>();
				List<ConditionalExpression> conditionalExpressionNodeList = new ArrayList<>();
				List<SwitchCase> switchCaseNodeList = new ArrayList<>();
				List<CatchClause> catchClauseNodeList = new ArrayList<>();

				// Lists of predicate nodes (loops)
				List<WhileStatement> whileStatementNodeList = new ArrayList<>();
				List<DoStatement> doStatementNodeList = new ArrayList<>();
				List<ForStatement> forStatementNodeList = new ArrayList<>();
				List<EnhancedForStatement> enhancedForStatementNodeList = new ArrayList<>();

				// Create a visitor class to extract a node list
				ASTVisitor cyclomaticComplexityVisitor = new ASTVisitor() {

					// decision nodes
					public boolean visit(IfStatement node) {
						ifStatmentNodeList.add(node);
						return super.visit(node);
					}

					public boolean visit(ConditionalExpression node) {
						conditionalExpressionNodeList.add(node);
						return super.visit(node);
					}

					public boolean visit(SwitchCase node) {
						switchCaseNodeList.add(node);
						return super.visit(node);
					}

					public boolean visit(CatchClause node) {
						catchClauseNodeList.add(node);
						return super.visit(node);
					}

					// loop nodes
					public boolean visit(WhileStatement node) {
						whileStatementNodeList.add(node);
						return super.visit(node);
					}

					public boolean visit(DoStatement node) {
						doStatementNodeList.add(node);
						return super.visit(node);
					}

					public boolean visit(ForStatement node) {
						forStatementNodeList.add(node);
						return super.visit(node);
					}

					public boolean visit(EnhancedForStatement node) {
						enhancedForStatementNodeList.add(node);
						return super.visit(node);
					}
				};

				// send the visitor through the tree of the method
				md.getASTNode().accept(cyclomaticComplexityVisitor);

				// calculate the number of logical ands and ors
				int numberLogicalAndOrs = calculateNumberLogicalAndOrs(ifStatmentNodeList);

				// calculate cyclomatic complexity
				cyclomaticComplexitiy += ifStatmentNodeList.size();
				cyclomaticComplexitiy += conditionalExpressionNodeList.size();
				cyclomaticComplexitiy += switchCaseNodeList.size();
				cyclomaticComplexitiy += catchClauseNodeList.size();
				cyclomaticComplexitiy += numberLogicalAndOrs;
				cyclomaticComplexitiy += whileStatementNodeList.size();
				cyclomaticComplexitiy += doStatementNodeList.size();
				cyclomaticComplexitiy += forStatementNodeList.size();
				cyclomaticComplexitiy += enhancedForStatementNodeList.size();
				cyclomaticComplexitiy += 1;

				// create a metric for the FileData to save
				MetricData metric = new MetricData(metricName, cyclomaticComplexitiy);

				// do meta analysis
				metric = metaAnalysis(metric, cyclomaticComplexitiy);

				// add related quality attributes
				metric.addTag("Maintainability");
				metric.addTag("Reliability");
				metric.addTag("Understandability");
				metric.addTag("Testability");

				// add metric to corresponding method in file
				md.addMetricData(metricKey, metric);

				// reset value for next method
				cyclomaticComplexitiy = 0;
			}
		}
	}

	/**
	 * This method calcuates the number of logical ands and ors
	 * 
	 * @param ifStatmentNodeList The list of if statements containing the logical
	 *                           ands and ors expressions
	 * @return The number of logical ands and ors
	 */
	private int calculateNumberLogicalAndOrs(List<IfStatement> ifStatmentNodeList) {
		int numberLogicalAndOrs = 0;
		for (IfStatement ifStatement : ifStatmentNodeList) {
			String expression = ifStatement.getExpression().toString();
			String logicalAndsAndOrs = expression.replaceAll("[^&|]", "");
			numberLogicalAndOrs = logicalAndsAndOrs.length() / 2;
		}
		return numberLogicalAndOrs;
	}

	/**
	 * This method performs a meta analysis on the provided metric
	 * 
	 * @param metric                The metric on which the meta analysis is
	 *                              performed on
	 * @param cyclomaticComplexitiy The cyclomatic complexity value of the metric
	 * @return The metric containing the recommendation in accordance to its
	 *         cyclomatic complexity value
	 */
	private MetricData metaAnalysis(MetricData metric, int cyclomaticComplexitiy) {

		// add recommendation on basis of suggested values for cyclomatic complexity
		String recommendation = "";

		if (cyclomaticComplexitiy <= 7) {
			return metric;
		}

		else if (cyclomaticComplexitiy <= 10) {
			recommendation = "Detected: High program complexity exceeding 7";
			recommendation += "\n      * Recommendation: Try to reduce number of decision points in your program";
			metric.setRecommendation(recommendation);
		}

		else if (cyclomaticComplexitiy <= 14) {
			recommendation = "Detected: Very high program complexity exceeding 10";
			recommendation += "\n      * Recommendation: Reduce number of decision points in your program by removing unnecessary conditional and loop expressions";
			metric.setRecommendation(recommendation);
		}

		else if (cyclomaticComplexitiy <= 20) {
			recommendation = "Detected: Maximum value for program complexity of 15 reached or exceeded";
			recommendation += "\n      * Recommendation: Reduce number of decision points in your program by removing unnecessary conditional and loop expressions";
			metric.setRecommendation(recommendation);
		}

		else if (cyclomaticComplexitiy >= 21) {
			recommendation = "Detected: Maximum value for program complexity of 15 exceeded by far";
			recommendation += "\n      * Recommendation: Reject module or severely reduce number of decision points in your program by removing unnecessary conditional and loop expressions";
			metric.setRecommendation(recommendation);
		}

		return metric;
	}
}
