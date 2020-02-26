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
 * @author Fabian Krauthausen
 * @date 12.05.2019
 * Number test cases: 5
 *	Boundaries:
 *		Value of 0
 *		Value of 1
 *		Value of 100
 *		Value of 101
 *		Value of 1000
 */
class LengthOfMethodsMCUnitTest {

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
		Controller.beginAnalysis("resources/JavaTestCode/UnitTestCode/MetricCalculator_LengthOfMethods/" + fileName,
				interpreter);
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
				MetricData metricData = methodData.getMetricData(Keys.LENGTHOFMETHODS.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("func")) {
					assertEquals(0.0, metricData.getValue(), "This is true when length of method is 0");
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
				MetricData metricData = methodData.getMetricData(Keys.LENGTHOFMETHODS.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("func")) {
					assertEquals(1.0, metricData.getValue(), "This is true when length of method is 1");
					// test that recommendation is empty
					assertNull(metricData.getRecommendation(), "This is true when recommendation is empty");
				}
			}
		}
	}

	/**
	 * This test case checks for Boundary: Value of 100 without recommendation
	 */
	@Test
	public void testValue100() {
		// Setup driver
		setUp("Boundaries/Value100");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.LENGTHOFMETHODS.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("func")) {
					assertEquals(100.0, metricData.getValue(), "This is true when length of method is 100");
					// test that recommendation is empty
					assertNull(metricData.getRecommendation(), "This is true when recommendation is empty");
				}
			}
		}
	}

	/**
	 * This test case checks for Boundary: Value of 101 in which recommendation does
	 * contain specific warning
	 */
	@Test
	public void testValue101() {
		// Setup driver
		setUp("Boundaries/Value101");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.LENGTHOFMETHODS.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("func")) {
					assertEquals(101.0, metricData.getValue(), "This is true when length of method is 101");
					// test that recommendation is set correctly
					assertNotEquals(-1, metricData.getRecommendation().indexOf("exceeding 100"),
							"This is true when recommendation is chosen correctly");
				}
			}
		}
	}

	/**
	 * This test case checks for Boundary: Value of 1000 in which recommendation
	 * does contain specific warning
	 */
	@Test
	public void testValue1000() {
		// Setup driver
		setUp("Boundaries/Value1000");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.LENGTHOFMETHODS.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("func")) {
					assertEquals(1000.0, metricData.getValue(), "This is true when length of method is 1000");
					// test that recommendation is set correctly
					assertNotEquals(-1, metricData.getRecommendation().indexOf("exceeding 100"),
							"This is true when recommendation is chosen correctly");
				}
			}
		}
	}

}