package metriccalculator;
import java.util.List;

import data.FileData;

/**
 * MetricCalculator is the super class for all the calculators. It provides a template
 * so that calculators can be created and used dynamically.
 * @author Angus Walsh
 *
 */
public abstract class MetricCalculator implements Comparable<MetricCalculator>
{		
	/**
	 * Variables
	 */
	private int priority;
	
	/**
	 * Constructors
	 */
	protected MetricCalculator() {priority = 0;}
	protected MetricCalculator(int _priority) {priority = _priority;}
	
	/**
	 * calculate is the template method for the extending calculators to 
	 * implement their algorithms.
	 * @param fileData
	 */
	public abstract void calculate(List<FileData> fileData);	
	
	/**
	 * Accessors
	 */
	public int getPriority() {return priority;}
	
	/**
	 * compareTo is required for the Comparable interface. it allows the calculators 
	 * be executed in a particular order if required.
	 */
	public int compareTo(MetricCalculator _mc)
    {
		Integer current = this.getPriority();
		Integer other = _mc.getPriority();		
		int result = current.compareTo( other );
        return result;
    }
}
