package metriccalculator;

import java.util.List;
import data.FileData;
import data.MethodData;
import data.MetricData;
import helper.Keys;

/**
 * This class represents a metric calculator calculating the length of parameter
 * list value
 * 
 * @author Robert Toy
 * @date 15.05.2019
 * 
 */
public class MetricCalculator_LengthOfParameterList extends MetricCalculator {
	/** keys for possible retrieval of stored metrics from method data */
	private String metricKey = Keys.LENGTHOFPARAMETERLIST.toString();
	/** name for interpreter to use in report */
	private String metricName = "Length of Parameter List";

	/**
	 * This method calculates the metric values for all provided files and stores
	 * the results in the provided files
	 */
	public void calculate(List<FileData> fileDataList) {
		// calculate for each file
		for (FileData fd : fileDataList) {

			// calculate for each method data
			for (MethodData md : fd.getMethods()) {

				int numberOfParameters = md.getASTNode().parameters().size();

				// create a metric
				MetricData metric = new MetricData(metricName, numberOfParameters);

				// meta Analysis
				String recommendation = "";
				if (numberOfParameters > 10) {
					recommendation = "Detected: Parameter list is too long with parameters exceeding 10";
					recommendation += "\n      * Recommendation: Try to create new objects to wrap and group parameters together";
					metric.setRecommendation(recommendation);
				}

				metric.addTag("Maintainability");

				// add metric to corresponding method in file
				md.addMetricData(metricKey, metric);
			}
		}
	}
}
