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
 * @date 24.05.2019
 * Number test cases: 12
 * 	Partitions:
 *		Single file, one directional
 *		Single file, two directional
 *		Two files, one directional
 *		Two files, two directional
 *		Multiple files, one directional
 *		Multiple files, two directional
 *	Boundaries:
 *		Value of 0
 *		Value of 1
 *		Value of 4 below recommendation
 *		Value of 5 above recommendation
 *		High value of 15
 * Limitations: Can not account for Polymorphism, since Java works as Late Binding at Runtime,
 * 				which makes it not possible for the developed tool doing static code analysis on source code
 * 				to determine which method of which subclasses will be called by calling the superclass method
 */
class FanInMCUnitTest {

	/** The controller for the driver */
	Controller controller;
	/** The interpreter for the driver */
	Interpreter interpreter;
	/** The file data list for the driver */
	List<FileData> fileDataList;

	/**
	 * This method sets up the driver for the tests
	 * @param fileName The name of the file or directory to test
	 */
	public void setUp(String fileName) {
		interpreter = new Interpreter();
		Controller.beginAnalysis("resources/JavaTestCode/UnitTestCode/MetricCalculator_FanIn/" + fileName, interpreter);
		fileDataList = interpreter.getFileData();
	}

	/**
	 * This test case checks for Partition: Single file, one directional
	 */
	@Test
	public void testSingleFileOneDirectional() {
		// Setup driver
		setUp("Partitions/SingleFileOneDirectional");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.FANIN.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("funcA"))
					assertEquals(1.0, metricData.getValue(), "This is true when receiver function is called 1 time");

				else if (methodData.getName().equalsIgnoreCase("otherFuncA"))
					assertEquals(0.0, metricData.getValue(), "This is true when caller function is called 0 times");
			}
		}
	}

	/**
	 * This test case checks for Partition: Single file, two directional
	 */
	@Test
	public void testSingleFileTwoDirectional() {
		// Setup driver
		setUp("Partitions/SingleFileTwoDirectional");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.FANIN.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("funcA"))
					assertEquals(2.0, metricData.getValue(), "This is true when function is called 2 times");

				else if (methodData.getName().equalsIgnoreCase("otherFuncA"))
					assertEquals(1.0, metricData.getValue(), "This is true when function is called 1 time");
			}
		}
	}

	/**
	 * This test case checks for Partition: Two files, one directional
	 */
	@Test
	public void testTwoFilesOneDirectional() {
		// Setup driver
		setUp("Partitions/TwoFilesOneDirectional");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.FANIN.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("funcA"))
					assertEquals(1.0, metricData.getValue(), "This is true when receiver function is called 1 time");

				else if (methodData.getName().equalsIgnoreCase("otherFuncA"))
					assertEquals(2.0, metricData.getValue(), "This is true when receiver function is called 2 times");

				else if (methodData.getName().equalsIgnoreCase("funcB"))
					assertEquals(0.0, metricData.getValue(), "This is true when caller function is called 0 times");

				else if (methodData.getName().equalsIgnoreCase("otherFuncB"))
					assertEquals(0.0, metricData.getValue(), "This is true when caller function is called 0 times");
			}
		}
	}

	/**
	 * This test case checks for Partition: Two files, two directional
	 */
	@Test
	public void testTwoFilesTwoDirectional() {
		// Setup driver
		setUp("Partitions/TwoFilesTwoDirectional");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.FANIN.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("funcA"))
					assertEquals(1.0, metricData.getValue(), "This is true when function is called 1 time");

				else if (methodData.getName().equalsIgnoreCase("otherFuncA"))
					assertEquals(2.0, metricData.getValue(), "This is true when function is called 2 times");

				else if (methodData.getName().equalsIgnoreCase("funcB"))
					assertEquals(2.0, metricData.getValue(), "This is true when function is called 2 times");

				else if (methodData.getName().equalsIgnoreCase("otherFuncB"))
					assertEquals(1.0, metricData.getValue(), "This is true when function is called 1 time");
			}
		}
	}

	/**
	 * This test case checks for Partition: Multiple files, one directional
	 */
	@Test
	public void testMultipleFilesOneDirectional() {
		// Setup driver
		setUp("Partitions/MultipleFilesOneDirectional");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.FANIN.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("funcA"))
					assertEquals(2.0, metricData.getValue(), "This is true when receiver function is called 2 times");

				else if (methodData.getName().equalsIgnoreCase("otherFuncA"))
					assertEquals(0.0, metricData.getValue(), "This is true when receiver function is called 0 times");

				else if (methodData.getName().equalsIgnoreCase("funcB"))
					assertEquals(1.0, metricData.getValue(), "This is true when receiver function is called 1 time");

				else if (methodData.getName().equalsIgnoreCase("otherFuncB"))
					assertEquals(0.0, metricData.getValue(), "This is true when receiver function is called 0 times");

				else if (methodData.getName().equalsIgnoreCase("funcC"))
					assertEquals(0.0, metricData.getValue(), "This is true when caller function is called 0 times");

				else if (methodData.getName().equalsIgnoreCase("otherFuncC"))
					assertEquals(0.0, metricData.getValue(), "This is true when caller function is called 0 times");
			}
		}
	}

	/**
	 * This test case checks for Partition: Multiple files, two directional
	 */
	@Test
	public void testMultipleFilesTwoDirectional() {
		// Setup driver
		setUp("Partitions/MultipleFilesTwoDirectional");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.FANIN.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("funcA"))
					assertEquals(2.0, metricData.getValue(), "This is true when function is called 2 times");

				else if (methodData.getName().equalsIgnoreCase("otherFuncA"))
					assertEquals(1.0, metricData.getValue(), "This is true when receiver function is called 1 time");

				else if (methodData.getName().equalsIgnoreCase("funcB"))
					assertEquals(1.0, metricData.getValue(), "This is true when function is called 1 time");

				else if (methodData.getName().equalsIgnoreCase("otherFuncB"))
					assertEquals(1.0, metricData.getValue(), "This is true when function is called 1 time");

				else if (methodData.getName().equalsIgnoreCase("funcC"))
					assertEquals(0.0, metricData.getValue(), "This is true when function is called 0 times");

				else if (methodData.getName().equalsIgnoreCase("otherFuncC"))
					assertEquals(2.0, metricData.getValue(), "This is true when function is called 2 times");
			}
		}
	}

	/**
	 * This test case checks for Partition: Same method name in different files for
	 * correct binding
	 */
	@Test
	public void testSameMethodName() {
		// Setup driver
		setUp("Partitions/SameMethodName");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.FANIN.toString());

				// test cases
				if (fileData.getName().equalsIgnoreCase("A.java")) {
					if (methodData.getName().equalsIgnoreCase("funcA"))
						assertEquals(3.0, metricData.getValue(),
								"This is true when receiver function is called 3 times");

					else if (methodData.getName().equalsIgnoreCase("otherFuncA"))
						assertEquals(0.0, metricData.getValue(), "This is true when caller function is called 0 times");
				}

				else if (fileData.getName().equalsIgnoreCase("B.java")) {
					if (methodData.getName().equalsIgnoreCase("funcA"))
						assertEquals(1.0, metricData.getValue(),
								"This is true when receiver function is called 1 time");

					else if (methodData.getName().equalsIgnoreCase("funcB"))
						assertEquals(0.0, metricData.getValue(), "This is true when caller function is called 0 times");
				}
			}
		}
	}

	/**
	 * This test case checks for Boundary: Value of 0 as non existing value
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
				MetricData metricData = methodData.getMetricData(Keys.FANIN.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("funcA"))
					assertEquals(0.0, metricData.getValue(), "This is true when receiver function is called 0 times");

				else if (methodData.getName().equalsIgnoreCase("otherFuncA"))
					assertEquals(0.0, metricData.getValue(), "This is true when caller function is called 0 times");
			}
		}
	}

	/**
	 * This test case checks for Boundary: Value of 1 as existing value
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
				MetricData metricData = methodData.getMetricData(Keys.FANIN.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("funcA"))
					assertEquals(1.0, metricData.getValue(), "This is true when receiver function is called 0 times");

				else if (methodData.getName().equalsIgnoreCase("otherFuncA"))
					assertEquals(0.0, metricData.getValue(), "This is true when caller function is called 0 times");
			}
		}
	}

	/**
	 * This test case checks for Boundary: Value of 4 in which recommendation does
	 * not contain max recommendation
	 */
	@Test
	public void testValue4() {
		// Setup driver
		setUp("Boundaries/Value4");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.FANIN.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("funcA")) {
					assertEquals(4.0, metricData.getValue(), "This is true when receiver function is called 0 times");
					// test that Change Preventer is only put as a recommendation for values above 4
					assertEquals(-1, metricData.getRecommendation().indexOf("Change Preventer"),
							"This is true when change preventer is not in recommendation");
				}

				else if (methodData.getName().equalsIgnoreCase("otherFuncA"))
					assertEquals(0.0, metricData.getValue(), "This is true when caller function is called 0 times");
			}
		}
	}

	/**
	 * This test case checks for Boundary: Value of 5 in which recommendation does
	 * contain max recommendation
	 */
	@Test
	public void testValue5() {
		// Setup driver
		setUp("Boundaries/Value5");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.FANIN.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("funcA")) {
					assertEquals(5.0, metricData.getValue(), "This is true when receiver function is called 0 times");
					// test that Change Preventer is only put as a recommendation for values above 4
					assertNotEquals(-1, metricData.getRecommendation().indexOf("Change Preventer"),
							"This is true when change preventer is in recommendation");
				}

				else if (methodData.getName().equalsIgnoreCase("otherFuncA"))
					assertEquals(0.0, metricData.getValue(), "This is true when caller function is called 0 times");
			}
		}
	}

	/**
	 * This test case checks for Boundary: Value of 15 as high value
	 */
	@Test
	public void testValue15() {
		// Setup driver
		setUp("Boundaries/Value15");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.FANIN.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("funcA"))
					assertEquals(15.0, metricData.getValue(), "This is true when receiver function is called 0 times");

				else if (methodData.getName().equalsIgnoreCase("otherFuncA"))
					assertEquals(0.0, metricData.getValue(), "This is true when caller function is called 0 times");
			}
		}
	}
}