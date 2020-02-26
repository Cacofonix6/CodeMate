package test.java;

import org.junit.jupiter.api.Test;

import core.Controller;
import core.GUI;
import core.Interpreter;
import data.FileData;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class MainCoreTest {

	@Test
	public void testBeginAnalysis() {
		Interpreter interpreter = new Interpreter();
		int fileDataCount = Controller.beginAnalysis("resources/JavaTestCode/CoreTests", interpreter);
		assertEquals(6, fileDataCount);
	}
	
	@Test
	public void testCaculateMetrics() {
		List<FileData> fileDataList = new ArrayList<>();
		Interpreter interpreter = new Interpreter();
		int metCalcCount = Controller.calculateMetrics(fileDataList, interpreter);
		assertEquals(9, metCalcCount);
	}
	
	@Test
	public void testFile() {
		GUI gui = new GUI();
		boolean exists = gui.checkForFile("resources/JavaTestCode/CoreTests/JavaFile.java");
		assertTrue(exists, "This is true if the file exists");
	}
		
	@Test
	public void testNotJavaFile() {
		Interpreter interpreter = new Interpreter();
		int fileDataCount = Controller.beginAnalysis("resources/JavaTestCode/CoreTests/NotJava.txt", interpreter);
		assertEquals(0, fileDataCount);
	}
		
	@Test 
	public void testEmptyFile(){
		Interpreter interpreter = new Interpreter();
		int fileDataCount = Controller.beginAnalysis("resources/JavaTestCode/CoreTests/EmptyTest.java", interpreter);
		assertEquals(1, fileDataCount);
	}
		
	@Test
	public void testHugeFile() {
		Interpreter interpreter = new Interpreter();
		int fileDataCount = Controller.beginAnalysis("resources/JavaTestCode/CoreTests/HugeFile.java", interpreter);
		assertEquals(1, fileDataCount);
	}
	
	@Test
	public void testSingleFolder() {
		Interpreter interpreter = new Interpreter();
		int fileDataCount = Controller.beginAnalysis("resources/JavaTestCode/CoreTests/SingleFolder", interpreter);
		assertEquals(3, fileDataCount);
	}
	
	@Test
	public void testNestedFolders() {
		Interpreter interpreter = new Interpreter();
		int fileDataCount = Controller.beginAnalysis("resources/JavaTestCode/CoreTests", interpreter);
		assertEquals(6, fileDataCount);
	}
}
