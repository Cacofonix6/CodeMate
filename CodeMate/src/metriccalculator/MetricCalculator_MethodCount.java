package metriccalculator;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import data.FileData;
import data.MetricData;

public class MetricCalculator_MethodCount extends MetricCalculator 
{		
	// keys for possible retrieval of stored metrics from method data for meta analysis
	private String metricKey = "MethodCount";
	// names for interpreter
	private String metricName = "Number Methods";
	
	// calculate the metric value and return it to be stored in the file data
	@Override
	public void calculate(List<FileData> fileData)
	{
		// Calculate for each file
		for (FileData fd: fileData)
		{
			List<ASTNode> nodes = new ArrayList<>();
			// Create a visitor class with an overridden visit function to extract a node list
			ASTVisitor visitor = new ASTVisitor() 
			{			
				// The visit function of the base class does nothing so it must be overridden 
				// for every metric to gather any information.
				public boolean visit(MethodDeclaration node) 
				{		     
					nodes.add(node);
					return true;
			    }
			};
			
			// Send the visitor through the tree
			fd.getASTNode().accept(visitor);
			
			// the size of the list is how many method declarations there are.
			int result = nodes.size();
			
			// create a metric for the FileData to save
			MetricData metric = new MetricData(metricName, result);
			metric.addTag("Maintainability");
			fd.addMetricData(metricKey, metric);
		}
	}	
}
