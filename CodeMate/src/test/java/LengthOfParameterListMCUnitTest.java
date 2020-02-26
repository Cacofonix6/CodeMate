package test.java;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import core.Controller;
import core.Interpreter;
import data.FileData;
import data.MethodData;
import data.MetricData;
import helper.Keys;

/**
 * 
 * @author Robert Toy
 * @date 13.05.2019
 * Number test cases: 5
 *	Boundaries:
 *		Value of 0
 *		Value of 1
 *		Value of 10
 *		Value of 11
 *		Value of 30
 */
class LengthOfParameterListMCUnitTest {

	/** The controller for the driver */
	Controller controller;
	/** The interpreter for the driver */
	Interpreter interpreter;
	/** The file data list for the driver */
	List<FileData> fileDataList;

	/**
	 * This method sets up the driver for the tests
	 * 
	 * @param fileName The name of the file or directory to test
	 */
	public void setUp(String fileName) {
		interpreter = new Interpreter();
		Controller.beginAnalysis(
				"resources/JavaTestCode/UnitTestCode/MetricCalculator_LengthOfParameterList/" + fileName, interpreter);
		fileDataList = interpreter.getFileData();
	}

	/**
	 * This test case checks for Boundary: Value of 0 without recommendation
	 */
	@Test
	public void testValue0() {
		// Setup driver
		setUp("Boundaries/Value0");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.LENGTHOFPARAMETERLIST.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("func")) {
					assertEquals(0.0, metricData.getValue(), "This is true when length of parameter list is 0");
					// test that recommendation is empty
					assertNull(metricData.getRecommendation(), "This is true when recommendation is empty");
				}
			}
		}
	}

	/**
	 * This test case checks for Boundary: Value of 1 without recommendation
	 */
	@Test
	public void testValue1() {
		// Setup driver
		setUp("Boundaries/Value1");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.LENGTHOFPARAMETERLIST.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("func")) {
					assertEquals(1.0, metricData.getValue(), "This is true when length of parameter list is 1");
					// test that recommendation is empty
					assertNull(metricData.getRecommendation(), "This is true when recommendation is empty");
				}
			}
		}
	}

	/**
	 * This test case checks for Boundary: Value of 10 without recommendation
	 */
	@Test
	public void testValue10() {
		// Setup driver
		setUp("Boundaries/Value10");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.LENGTHOFPARAMETERLIST.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("func")) {
					assertEquals(10.0, metricData.getValue(), "This is true when length of parameter list is 10");
					// test that recommendation is empty
					assertNull(metricData.getRecommendation(), "This is true when recommendation is empty");
				}
			}
		}
	}

	/**
	 * This test case checks for Boundary: Value of 11 in which recommendation does
	 * contain specific warning
	 */
	@Test
	public void testValue11() {
		// Setup driver
		setUp("Boundaries/Value11");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.LENGTHOFPARAMETERLIST.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("func")) {
					assertEquals(11.0, metricData.getValue(), "This is true when length of parameter list is 11");
					// test that recommendation is set correctly
					assertNotEquals(-1, metricData.getRecommendation().indexOf("exceeding 10"),
							"This is true when recommendation is chosen correctly");
				}
			}
		}
	}

	/**
	 * This test case checks for Boundary: Value of 30 in which recommendation does
	 * contain specific warning
	 */
	@Test
	public void testValue30() {
		// Setup driver
		setUp("Boundaries/Value30");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.LENGTHOFPARAMETERLIST.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("func")) {
					assertEquals(30.0, metricData.getValue(), "This is true when length of parameter list is 30");
					// test that recommendation is set correctly
					assertNotEquals(-1, metricData.getRecommendation().indexOf("exceeding 10"),
							"This is true when recommendation is chosen correctly");
				}
			}
		}
	}

}