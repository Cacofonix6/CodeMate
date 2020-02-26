package data;
import java.util.ArrayList;
import java.util.List;

/**
 * MetricData stores the results of the calculators.
 * @author Angus Walsh
 *
 */
public class MetricData {
	/**
	 * Variables
	 */
	private String name;
	private float value;
	private List<String> tags = new ArrayList<>();
	private String recommendation = null;
	
	/**
	 * Constructor for creating a metric without an initial value
	 * @param _name
	 */
	public MetricData(String _name)	{
		name = _name;
		value = 0;
	}
	
	/**
	 * Constructor for creating a metric with an initial value
	 * @param _name
	 * @param _val
	 */
	public MetricData(String _name, float _val)	{
		name = _name;
		value = _val;
	}
	
	/**
	 * Accessors
	 */
	public String getName() {return name;}
	public float getValue() {return value;}
	public String getRecommendation() {return recommendation;}
	
	/**
	 * Mutators
	 */
	public void setValue(float _val) {value = _val;}	
	public void setRecommendation(String _rec) {recommendation = _rec;}
	
	/**
	 * addTag adds a tag to the metric for formatting purposes
	 * @param _tag
	 */
	public void addTag(String _tag) {tags.add(_tag);}
}
