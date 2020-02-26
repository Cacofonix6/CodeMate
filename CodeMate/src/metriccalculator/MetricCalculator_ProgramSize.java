package metriccalculator;
import java.util.List;

import data.FileData;
import data.MetricData;

public class MetricCalculator_ProgramSize extends MetricCalculator 
{		
	// keys for possible retrieval of stored metrics from method data for meta analysis
	private String metricKey = "programSize";
	// names for interpreter
	private String metricName = "Program Size";
	
	// calculate the metric value and return it to be stored in the file data
	@Override
	public void calculate(List<FileData> fileData)
	{
		int totalLines = 0;
		
		// Calculate for each file
		for (FileData fd: fileData)
		{
			// split the file string by the new lines to get a line count
			String[] lines = fd.getDataAsString().split("\n");
			
			totalLines += lines.length;
			
			// create a metric for the FileData to save
			MetricData metric = new MetricData(metricName, lines.length);
			metric.addTag("Readability");
			fd.addMetricData(metricKey, metric);
		}		
		
		
		// Meta Analysis with retrieval of previously stored metrics from file data
		float average = 0;
		average = (float)totalLines / fileData.size();
		
		for (FileData fd: fileData)
		{
			if (fd.getMetricData(metricKey).getValue() > average )
			{
				String rec = "Prorgram size is above the average of " + average + " lines in the file.";
				
				fd.getMetricData(metricKey).setRecommendation(rec);
			}
		}
	}	
}
