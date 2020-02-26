package metriccalculator;

import java.util.List;
import data.FileData;
import data.MethodData;
import data.MetricData;
import helper.Keys;

/**
 * This class represents a metric calculator calculating the length of methods
 * value
 * 
 * @author Fabian Krauthausen
 * @date 15.05.2019
 * 
 */
public class MetricCalculator_LengthOfMethods extends MetricCalculator {
	/** keys for possible retrieval of stored metrics from method data */
	private String metricKey = Keys.LENGTHOFMETHODS.toString();
	/** name for interpreter to use in report */
	private String metricName = "Length of Method";

	/**
	 * This method calculates the metric values for all provided files and stores
	 * the results in the provided files
	 */
	public void calculate(List<FileData> fileDataList) {
		// calculate for each file
		for (FileData fd : fileDataList) {

			// calculate for each method data
			for (MethodData md : fd.getMethods()) {

				// split the file string by the new lines to get a line count
				String[] linesPerMethod = md.getASTNode().toString().split("\n");

				// subtract 2 since the string of the method also contains its declaration with
				// opening and closing bracket
				int numberLinesPerMethod = linesPerMethod.length - 2;

				// create a metric
				MetricData metric = new MetricData(metricName, numberLinesPerMethod);

				// meta Analysis
				String recommendation = "";
				if (numberLinesPerMethod > 100) {
					recommendation = "Detected: Method is doing too much with lines exceeding 100";
					recommendation += "\n      * Recommendation: Try to reduce method size by creating helper methods and removing copy pasted code";
					metric.setRecommendation(recommendation);
				}

				metric.addTag("Maintainability");

				// add metric to corresponding method in file
				md.addMetricData(metricKey, metric);
			}
		}
	}
}