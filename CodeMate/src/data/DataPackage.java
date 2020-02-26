package data;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.core.dom.ASTNode;

/**
 * DataPakage is a base class for most of the custom data types. It stroes basic information
 * as well as resources and results of the calculators.
 * @author Angus Walsh
 *
 */
public class DataPackage {	
	/**
	 * Variables
	 */
	protected String name; 
	protected String dataAsString; 
	protected Map<String, MetricData> metrics = new HashMap<>();
	
	/* 
	 * ASTNode is the base class for basically everything the parser needs.
	 * It contains links to the child and parent nodes. 
	 * These nodes can be visited by an ASTVisitor which will search through child nodes 
	 */
	protected ASTNode node; 
	
	/**
	 * Constructor
	 * @param _name
	 * @param _dataAsString
	 * @param _node
	 */
	public DataPackage(String _name, String _dataAsString, ASTNode _node){		
		name = _name;
		dataAsString = _dataAsString;
		node = _node;
	}	

	/**
	 * Accessors
	 */
	public String getName() {return name;}
	public ASTNode getASTNode() {return node;}
	public String getDataAsString() {return dataAsString;}	
	public Map<String, MetricData> getMetrics() {return metrics;}
	
	/**
	 * getMetricData gets a specific metric by its key
	 * @param _metricKey
	 * @return
	 */
	public MetricData getMetricData(String _metricKey) {return metrics.get(_metricKey);	}
	
	/**
	 * addMetricData adds a metric associated with this data
	 * @param _metricKey
	 * @param _metric
	 */
	public void addMetricData(String _metricKey, MetricData _metric) {metrics.put(_metricKey,_metric);}
}
