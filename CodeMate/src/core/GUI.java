package core;
import java.io.*;
import java.util.Scanner;

/**
 * GUI is a wrapper for third party GUI software. It contains the main method which 
 * handles a console input of a directory. All that has to be done to run this software
 * is for the main to be called in a console with an inputed directory.
 * GUI also has some static utility functions for a console GUI, useful for debugging.
 * @author Angus Walsh
 *
 */
public class GUI {

	/**
	 * main method. detects console input and decides whether to run the analysis or
	 * start the console gui for debugging.
	 * @param args
	 */
	public static void main(final String[] args) {
		GUI gui = new GUI();
		String dir = "";
		dir = gui.getDir(args);
		boolean isFile = gui.checkForFile(dir);
		//if file or dir exists and the dir string is not empty
		if (isFile && !dir.equals("")) {
			gui.startParser(dir);
		} else {
			//else launch console version (remove later? since gui handles this?)
			gui.consoleStart();
		}
	}

	/**
	 * startParser calls the controller to begin analysis
	 * @param dir
	 */
	private void startParser(final String dir) {
		Interpreter interpreter = new Interpreter();
		printText("Directory found.\nParsing...");

		Controller.beginAnalysis(dir, interpreter);
		printText(interpreter.report());
	}

	/**
	 * getDir checks the console input is in the correct format.
	 * @param args
	 * @return dir
	 */
	private String getDir(final String[] args) {
		String dir = "";
		// if there is more than one input than the input directory has spaces in one 
		// of the file/directory names. this loop concatenates them back into one string.
		if (args.length > 0) {
			dir = "";
			if (args.length > 1) {
				for (int i = 0; i < args.length; i++) {
					dir += args[i];
					if (i < args.length - 1) {
						dir += " ";
					}
				}
			} else {
				dir = args[0];
			}
		}
		return dir;
	}

	/**
	 * checkForFile checks that a gives filepath leads to a file or directory.
	 * (Note it does not check the validity of the file, just that it exists.)
	 * @param fileName
	 * @return out
	 */
	public boolean checkForFile(final String fileName)	{
		boolean out = false;

		try {
			File file;
			if (fileName.equals("")) {
				file = new File("resources/JavaTestCode/" + fileName);
			} else {
				file = new File(fileName);
			}
			out = file.exists();
		} catch (Exception ex) {
			out = false;
		}

		return out;
	}

	/**
	 * consoleStart is called if a directory was not entered in the console. 
	 * It serves as a console GUI for debugging purposes.
	 */
	private void consoleStart()	{
		Interpreter interpreter = new Interpreter();

		printText("Welcome to CodeMate!");

		String dir;
		boolean exit = false;

		// loop to check the input file exists
		do {
			printText("Please Enter a file name or type X to exit:");

			// get user input
			Scanner sc = new Scanner(System.in);
			dir = sc.nextLine();

			// check user input
			if (dir.equals("x")||dir.equals("X")) {
				// if they type "x" then exit the program
				exit = true;
				sc.close();
			} else if (checkForFile(dir)) {
				// otherwise check if the file exists
				printText("Directory found.\nParsing...");
				exit = true;
				sc.close();
			} else {
				// the file doesn't exist so try again
				printText("File not found.");
			}

			} while (!exit);

			Controller.beginAnalysis(dir, interpreter);
			printText(interpreter.report());
	}

	/**
	 * printText currently just calls System.out.println
	 * @param output
	 */
	public static void printText(final String output) {
		System.out.println(output);
	}

}
