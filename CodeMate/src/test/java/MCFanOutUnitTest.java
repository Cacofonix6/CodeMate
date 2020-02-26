package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import core.Controller;
import core.Interpreter;
import data.FileData;
import data.MethodData;
import data.MetricData;
import metriccalculator.MetricCalculator_LengthOfMethods;

public class MCFanOutUnitTest {

	
	@Test
	public void testFanOutTestCustom() {
		// Setup
		String fileName = "FanOutTestCustom.java";
		String out = "";
		Interpreter interpreter = new Interpreter();
		Controller.beginAnalysis("resources/JavaTestCode/UnitTestCode/MetricCalculator_FanOut/" + fileName, interpreter);
		List<FileData> fileDataList = interpreter.getFileData();
		
		// Iterate through calculated files
		for(FileData fileData: fileDataList)
		{
			out += " Metrics per Method" + "\n";
			
			// Loop over all methods per file
			for (MethodData methodData : fileData.getMethods())
			{
				out += "  Method name: \"" + methodData.getName() + "\" at line number: " + methodData.getLineNumer() + "\n";
				
				// Loop over all metrics per method per file
				for (MetricData metricData : methodData.getMetrics().values())
				{
					out += "   " + metricData.getName() + ": " + metricData.getValue() + "\n";
					
					if(metricData.getName().equalsIgnoreCase("fan out"))
					{	
						if(methodData.getName().equalsIgnoreCase("main")) {
							assertEquals(4.0, metricData.getValue());
						}

						else if (methodData.getName().equalsIgnoreCase("start"))
							assertEquals(3.0, metricData.getValue());
						
						else if (methodData.getName().equalsIgnoreCase("testing"))
							assertEquals(0.0, metricData.getValue());
					}
				}
			}
			System.out.println(out);
		}
	}

}
