package metriccalculator;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodInvocation;

import data.FileData;
import data.MethodData;
import data.MetricData;

/**
 * MetricCalculator_FanOut is the implementation of the fan out metric.
 * @author Angus Walsh
 *
 */
public class MetricCalculator_FanOut extends MetricCalculator {
	
	/**
	 * Variables
	 */
	private String metricKeyMethodFanOut = "FanOut";
	private String metricNameMethodFanOut = "Fan Out";
	
	/**
	 * calculate is the implementation of the fan out metric.
	 * @param _fileData
	 */
	@Override
	public void calculate(List<FileData> _fileData) {
		// Calculate for each method in a file.
		for (FileData fileData: _fileData){
			for (MethodData methodData: fileData.getMethods()) {				
				List<MethodInvocation> MethodInvNodeList = new ArrayList<>();
				// Ctreate a visitor to traverse the AST
				ASTVisitor methodVisitor = new ASTVisitor(){
					
					@Override
					public boolean visit(MethodInvocation _node) {
						// add any MethodInvocation found to the list
						MethodInvNodeList.add(_node);
						return true;
					}
					
				};// End of "visitor"
				methodData.getASTNode().accept(methodVisitor);
				
				// create a metric and enter the results.
				int result = MethodInvNodeList.size();				
				MetricData methodMetricFanOut = new MetricData(metricNameMethodFanOut, result);
				methodMetricFanOut.addTag("Complexity");
				
				// add the metric to the method data.
				methodData.addMetricData(metricKeyMethodFanOut, methodMetricFanOut);
				
			}// End of "for (MethodData methodData: fileData.getMethods())"		
		} // End of "for (FileData fileData: _fileData)"
	} // End of "calculate"
} // End of "MetricCalculator_FanOut"
