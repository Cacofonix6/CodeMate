package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import core.Controller;
import core.Interpreter;
import data.FileData;
import data.MetricData;
import data.TypeData;

public class MCCouplingUnitTest {
	
	
	@Test
	public void testCouplingTestCustom() {
		// Setup
		String fileName = "CouplingTestCustom.java";
		String out = "";
		Interpreter interpreter = new Interpreter();
		Controller.beginAnalysis("resources/JavaTestCode/UnitTestCode/MetricCalculator_Coupling/" + fileName, interpreter);
		List<FileData> fileDataList = interpreter.getFileData();
		
		// Iterate through calculated files
		for(FileData fileData: fileDataList)
		{
			out += " Metrics per Method" + "\n";
			
			// Loop over all methods per file
			for (TypeData typeData : fileData.getTypes())
			{
				out += "  Method name: \"" + typeData.getName() + "\" at line number: " + typeData.getLineNumer() + "\n";
				
				// Loop over all metrics per method per file
				for (MetricData metricData : typeData.getMetrics().values())
				{
					out += "   " + metricData.getName() + ": " + metricData.getValue() + "\n";
					
					if(metricData.getName().equalsIgnoreCase("Coupling"))
					{	
						if(typeData.getName().equalsIgnoreCase("CouplingTest")) 
							assertEquals(4.0, metricData.getValue());
						else if (typeData.getName().equalsIgnoreCase("CouplingTest2"))
							assertEquals(1.0, metricData.getValue());
						
					}
				}
			}
			System.out.println(out);
		}
	}	
}
