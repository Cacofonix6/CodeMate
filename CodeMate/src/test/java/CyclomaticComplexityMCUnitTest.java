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
 * @date 23.05.2019
 * Number test cases: 18
 * 	Partitions:
 *		IfStatment
 *		ConditionalExpression
 *		SwitchCase
 *		CatchClause
 *		WhileStatement
 *		ForStatement
 *		DoStatement
 *		EnhancedForStatement
 *		None
 *		AllStatements
 *	Boundaries:
 *		Value of 7
 *		Value of 8
 *		Value of 10
 *		Value of 11
 *		Value of 15
 *		Value of 20
 *		Value of 21
 *  Wild:
 *  	PMD Value of 12
 */
class CyclomaticComplexityMCUnitTest {

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
		Controller.beginAnalysis(
				"resources/JavaTestCode/UnitTestCode/MetricCalculator_CyclomaticComplexity/" + fileName, interpreter);
		fileDataList = interpreter.getFileData();
	}

	/**
	 * This test case checks for Partition: IfStatement
	 */
	@Test
	public void testIfStatment() {
		// Setup driver
		setUp("Partitions/IfStatment");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.CYCLOMATICCOMPLEXITY.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("cyclomaticFunc"))
					assertEquals(2.0, metricData.getValue(), "This is true when IfStatment is counted");

				else if (methodData.getName().equalsIgnoreCase("controlFunc"))
					assertEquals(1.0, metricData.getValue(), "This is true when empty control function is not counted");
			}
		}
	}

	/**
	 * This test case checks for Partition: ConditionalExpression
	 */
	@Test
	public void testConditionalExpression() {
		// Setup driver
		setUp("Partitions/ConditionalExpression");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.CYCLOMATICCOMPLEXITY.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("cyclomaticFunc"))
					assertEquals(2.0, metricData.getValue(), "This is true when ConditionalExpression is counted");

				else if (methodData.getName().equalsIgnoreCase("controlFunc"))
					assertEquals(1.0, metricData.getValue(), "This is true when empty control function is not counted");
			}
		}
	}

	/**
	 * This test case checks for Partition: SwitchCase
	 */
	@Test
	public void testSwitchCase() {
		// Setup driver
		setUp("Partitions/SwitchCase");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.CYCLOMATICCOMPLEXITY.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("cyclomaticFunc"))
					assertEquals(2.0, metricData.getValue(), "This is true when SwitchCase is counted");

				else if (methodData.getName().equalsIgnoreCase("controlFunc"))
					assertEquals(1.0, metricData.getValue(), "This is true when empty control function is not counted");
			}
		}
	}

	/**
	 * This test case checks for Partition: CatchClause
	 */
	@Test
	public void testCatchClause() {
		// Setup driver
		setUp("Partitions/CatchClause");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.CYCLOMATICCOMPLEXITY.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("cyclomaticFunc"))
					assertEquals(2.0, metricData.getValue(), "This is true when CatchClause is counted");

				else if (methodData.getName().equalsIgnoreCase("controlFunc"))
					assertEquals(1.0, metricData.getValue(), "This is true when empty control function is not counted");
			}
		}
	}

	/**
	 * This test case checks for Partition: WhileStatement
	 */
	@Test
	public void testWhileStatement() {
		// Setup driver
		setUp("Partitions/WhileStatement");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.CYCLOMATICCOMPLEXITY.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("cyclomaticFunc"))
					assertEquals(2.0, metricData.getValue(), "This is true when WhileStatement is counted");

				else if (methodData.getName().equalsIgnoreCase("controlFunc"))
					assertEquals(1.0, metricData.getValue(), "This is true when empty control function is not counted");
			}
		}
	}

	/**
	 * This test case checks for Partition: ForStatement
	 */
	@Test
	public void testForStatement() {
		// Setup driver
		setUp("Partitions/ForStatement");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.CYCLOMATICCOMPLEXITY.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("cyclomaticFunc"))
					assertEquals(2.0, metricData.getValue(), "This is true when ForStatement is counted");

				else if (methodData.getName().equalsIgnoreCase("controlFunc"))
					assertEquals(1.0, metricData.getValue(), "This is true when empty control function is not counted");
			}
		}
	}

	/**
	 * This test case checks for Partition: ForStatement
	 */
	@Test
	public void testDoStatement() {
		// Setup driver
		setUp("Partitions/DoStatement");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.CYCLOMATICCOMPLEXITY.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("cyclomaticFunc"))
					assertEquals(2.0, metricData.getValue(), "This is true when DoStatement is counted");

				else if (methodData.getName().equalsIgnoreCase("controlFunc"))
					assertEquals(1.0, metricData.getValue(), "This is true when empty control function is not counted");
			}
		}
	}

	/**
	 * This test case checks for Partition: ForStatement
	 */
	@Test
	public void testEnhancedForStatement() {
		// Setup driver
		setUp("Partitions/EnhancedForStatement");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.CYCLOMATICCOMPLEXITY.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("cyclomaticFunc"))
					assertEquals(2.0, metricData.getValue(), "This is true when EnhancedForStatement is counted");

				else if (methodData.getName().equalsIgnoreCase("controlFunc"))
					assertEquals(1.0, metricData.getValue(), "This is true when empty control function is not counted");
			}
		}
	}

	/**
	 * This test case checks for Partition: None to assure the correct default value
	 * of 1
	 */
	@Test
	public void testNone() {
		// Setup driver
		setUp("Partitions/None");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.CYCLOMATICCOMPLEXITY.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("cyclomaticFunc"))
					assertEquals(1.0, metricData.getValue(), "This is true when the default value is 1");
			}
		}
	}

	/**
	 * This test case checks for Partition: AllStatements to assure that all
	 * prediction and loop nodes are counted in nested cases
	 */
	@Test
	public void testAllStatements() {
		// Setup driver
		setUp("Partitions/AllStatements");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.CYCLOMATICCOMPLEXITY.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("cyclomaticFunc"))
					assertEquals(9.0, metricData.getValue(),
							"This is true when AllStatements are counted in nested cases");

				else if (methodData.getName().equalsIgnoreCase("controlFunc"))
					assertEquals(1.0, metricData.getValue(), "This is true when empty control function is not counted");
			}
		}
	}

	/**
	 * This test case checks for Boundary: Value of 7 without recommendation
	 */
	@Test
	public void testValue7() {
		// Setup driver
		setUp("Boundaries/Value7");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.CYCLOMATICCOMPLEXITY.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("cyclomaticFunc")) {
					assertEquals(7.0, metricData.getValue(), "This is true when cyclomatic complexity is 7");
					// test that recommendation is empty
					assertNull(metricData.getRecommendation(), "This is true when recommendation is empty");
				}
			}
		}
	}

	/**
	 * This test case checks for Boundary: Value of 8 in which recommendation does
	 * contain specific warning
	 */
	@Test
	public void testValue8() {
		// Setup driver
		setUp("Boundaries/Value8");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.CYCLOMATICCOMPLEXITY.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("cyclomaticFunc")) {
					assertEquals(8.0, metricData.getValue(), "This is true when cyclomatic complexity is 8");
					// test that recommendation is set correctly
					assertNotEquals(-1, metricData.getRecommendation().indexOf("exceeding 7"),
							"This is true when recommendation is chosen correctly");
				}
			}
		}
	}

	/**
	 * This test case checks for Boundary: Value of 10 in which recommendation does
	 * contain specific warning
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
				MetricData metricData = methodData.getMetricData(Keys.CYCLOMATICCOMPLEXITY.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("cyclomaticFunc")) {
					assertEquals(10.0, metricData.getValue(), "This is true when cyclomatic complexity is 10");
					// test that recommendation is set correctly
					assertNotEquals(-1, metricData.getRecommendation().indexOf("exceeding 7"),
							"This is true when recommendation is chosen correctly");
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
				MetricData metricData = methodData.getMetricData(Keys.CYCLOMATICCOMPLEXITY.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("cyclomaticFunc")) {
					assertEquals(11.0, metricData.getValue(), "This is true when cyclomatic complexity is 11");
					// test that recommendation is set correctly
					assertNotEquals(-1, metricData.getRecommendation().indexOf("exceeding 10"),
							"This is true when recommendation is chosen correctly");
				}
			}
		}
	}

	/**
	 * This test case checks for Boundary: Value of 15 in which recommendation does
	 * contain specific warning
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
				MetricData metricData = methodData.getMetricData(Keys.CYCLOMATICCOMPLEXITY.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("cyclomaticFunc")) {
					assertEquals(15.0, metricData.getValue(), "This is true when cyclomatic complexity is 15");
					// test that recommendation is set correctly
					assertNotEquals(-1, metricData.getRecommendation().indexOf("15 reached or exceeded"),
							"This is true when recommendation is chosen correctly");
				}
			}
		}
	}

	/**
	 * This test case checks for Boundary: Value of 20 in which recommendation does
	 * contain specific warning
	 */
	@Test
	public void testValue20() {
		// Setup driver
		setUp("Boundaries/Value20");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.CYCLOMATICCOMPLEXITY.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("cyclomaticFunc")) {
					assertEquals(20.0, metricData.getValue(), "This is true when cyclomatic complexity is 20");
					// test that recommendation is set correctly
					assertNotEquals(-1, metricData.getRecommendation().indexOf("15 reached or exceeded"),
							"This is true when recommendation is chosen correctly");
				}
			}
		}
	}

	/**
	 * This test case checks for Boundary: Value of 21 in which recommendation does
	 * contain specific warning
	 */
	@Test
	public void testValue21() {
		// Setup driver
		setUp("Boundaries/Value21");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.CYCLOMATICCOMPLEXITY.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("cyclomaticFunc")) {
					assertEquals(21.0, metricData.getValue(), "This is true when cyclomatic complexity is 21");
					// test that recommendation is set correctly
					assertNotEquals(-1, metricData.getRecommendation().indexOf("15 exceeded by far"),
							"This is true when recommendation is chosen correctly");
				}
			}
		}
	}
	
	
	/**
	 * This test case checks for Wild Code: Value of 12
	 * PMD - https://pmd.sourceforge.io/pmd-4.3.0/rules/codesize.html
	 */
	@Test
	public void testPMDCalculatedValue() {
		// Setup driver
		setUp("Wild/PMD");

		// loop over all files
		for (FileData fileData : fileDataList) {

			// loop over all methods per file
			for (MethodData methodData : fileData.getMethods()) {

				// access correct metric
				MetricData metricData = methodData.getMetricData(Keys.CYCLOMATICCOMPLEXITY.toString());

				// test cases
				if (methodData.getName().equalsIgnoreCase("example")) {
					assertEquals(12.0, metricData.getValue(), "This is true when cyclomatic complexity is 12");

				}
			}
		}
	}
}