package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import core.Controller;
import core.Interpreter;
import data.FileData;
import data.MethodData;
import data.MetricData;
import helper.Keys;
/**
 * This class represents a metric calculator calculating the depth of nested if
 * statements
 * 
 * @author Robert Toy
 * @date 27.05.2019
 * 
 */
public class DepthOfConditionalNestingTest {

	/** The controller for the driver */
	Controller controller;
	/** The interpreter for the driver */
	Interpreter interpreter;
	/** The file data list for the driver */
	List<FileData> fileDataList;
	
	public void setUp() {
		interpreter = new Interpreter();
		Controller.beginAnalysis("resources/JavaTestCode/UnitTestCode/MetricCalculator_DepthOfConditionalNesting/", interpreter);
		fileDataList = interpreter.getFileData();
	}
	
	@Test
	public void testIfStatementDepth() {
		// Setup driver
		setUp();

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.DEPTHOFCONDITIONALNESTING.toString());
				// test cases
				if (methodData.getName().equalsIgnoreCase("Depth Of Conditional Nesting"))
					assertEquals(3, metricData.getValue(), "This is true when nesting counted correctly");

				else if (methodData.getName().equalsIgnoreCase("Depth Of Conditional Nesting"))
					assertEquals(4, metricData.getValue(), "This is true when nesting counted correctly");
			}
		}
	}

}
