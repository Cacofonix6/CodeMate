package test.java;

import org.junit.jupiter.api.Test;

import core.Controller;
import core.GUI;
import core.Interpreter;
import data.FileData;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class SystemTest {

	@Test
	public void testBeginAnalysis() {
		Interpreter interpreter = new Interpreter();
		int fileDataCount = Controller.beginAnalysis("resources/JavaTestCode/CoreTests", interpreter);
		assertEquals(6, fileDataCount);
	}
	
}