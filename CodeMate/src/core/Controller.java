package core;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import data.FileData;
import data.MethodData;
import data.TypeData;
import helper.ParserWrapper;
import helper.Utility;
import metriccalculator.MetricCalculator;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import java.io.File;
import java.net.URL;
import java.util.*;

/**
* Controller controls the flow of the program
* @author Angus Walsh
*
*/
public class Controller {

	/**
	 * beginAnalysis gets the list of files from the directory ready to by calculated
	 * @param directoryPath
	 * @param interpreter
	 */
	public static int beginAnalysis(final String directoryPath, final Interpreter interpreter) {
		List<FileData> fileDataList = new ArrayList<>();
		List<File> fileList = new ArrayList<>();
		String dir;
		// Populate the list of Files
		if (directoryPath.equals("")) {
			// from the JavaTestCode directory if nothing is entered
			dir = "resources\\JavaTestCode\\UnitTestCode";
		} else {
			// otherwise from the custom directory
			dir = directoryPath;
		}

		Utility.populateFileList(dir, fileList);
		// populate the fileData list
		for (File f : fileList) {

			String fName = f.getName(); // name of the file
			String fileAsString = Utility.fileToString(f); // the file as a string

			// Get the AST tree from the Parser
			CompilationUnit ast = ParserWrapper.generateAST(f, f.getParentFile().getAbsolutePath()); //generate an AST

			// Report to the console if the bindings were activated in the parser
			String report = fName;
			report += ": parsed";
			GUI.printText(report);

			FileData fileData = new FileData(fName, fileAsString, ast);
			fileDataList.add(fileData);
		}

		populateFileData(fileDataList);
		calculateMetrics(fileDataList, interpreter);
		return fileDataList.size();
	}

	/**
	 * calulateMetrics uses a library called reflections which goes through class files
	 * to find all subclasses of Metric and create an instance of it.
	 * @param fileDataList
	 * @param interpreter
	 */
	public static int calculateMetrics(final List<FileData> fileDataList, final Interpreter interpreter) {
		List<MetricCalculator> metricCalcs = new ArrayList<>();

		try {
			Set<URL> classPathList = new HashSet<>();

			// Add all the class paths to the list. Currently it gets all the class paths
			// from the metriccalculator package. This can be changed to check any package by changing 
			// parameters of forPackage("").
			classPathList.addAll(ClasspathHelper.forPackage("/metriccalculator"));

			// Create a set of MetricCalculator sub classes and set it using the Reflections class. 
			// Reflections takes the list of class paths and scans them to find any sub classes
			// of MetricCalculator.
			Set<Class<? extends MetricCalculator>> result = new Reflections(new ConfigurationBuilder().setScanners(new SubTypesScanner()).setUrls(classPathList)).getSubTypesOf(MetricCalculator.class);

			for (Class<? extends MetricCalculator> c: result) {
				metricCalcs.add(c.newInstance());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// The calculators can be sorted by priority so that a calculator can use the results
		// of a different calculator and be sure its been calculated.
		Collections.sort(metricCalcs);

		for (MetricCalculator m: metricCalcs) {
			m.calculate(fileDataList);
		}

		interpreter.setFileData(fileDataList);
		return metricCalcs.size();
	}

	/**
	 * populateFileData populates the file data with information that will be commonly
	 * used by the calculators.
	 * @param fileDataList
	 */
	private static void populateFileData(final List<FileData> fileDataList) {

		// Calculate for each file
		for (FileData fd: fileDataList)	{
			@SuppressWarnings("unchecked")
			List<TypeDeclaration> types = fd.getASTNode().types();

			for (TypeDeclaration td: types) {

				String typeName = td.getName().toString();
           	int typeLineNumber = fd.getASTNode().getLineNumber(td.getName().getStartPosition());
           	String typeAsString = td.toString();

				TypeData typeData = new TypeData(typeName, typeLineNumber, typeAsString, td, td.isInterface());

				for (MethodDeclaration md: td.getMethods()) {
					String methName = md.getName().toString();
	            	int methLineNumber = fd.getASTNode().getLineNumber(md.getName().getStartPosition());
	            	String methAsString = md.toString();

	            	MethodData methodData = new MethodData(methName, methLineNumber, methAsString, md);
	            	typeData.addMethodData(methodData);
				}

				fd.addTypeData(typeData);
			}
		}
	}
}

