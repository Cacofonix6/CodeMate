package helper;

import java.io.File;
import java.util.Map;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * ParserWrapper creates a compilation unit for given file. 
 * (Note the parser is not fully wrapped due to the complexity of fully wrapping it)
 * @author Angus Walsh
 *
 */
public class ParserWrapper {
	
	/**
	 * generateAST sets up a parser and binding information then creates a compilation unit.
	 * @param _file
	 * @param _directory
	 * @return
	 */
	public static CompilationUnit generateAST(File _file, String _directory) {
		String file = Utility.fileToString(_file);
		String fileName = _file.getName();
		// Create an instance of the parser to extract the AST tree
		ASTParser parser = ASTParser.newParser(AST.JLS11);	
		// The parser requires an environment to be set up to get the binding information.
		String[] sources = {_directory}; 
		String[] classpath = java.lang.System.getProperty( "java.class.path" ).split(";");		
		parser.setEnvironment(classpath, sources, new String[] { "UTF-8"}, true);
		
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setResolveBindings(true);	
		parser.setBindingsRecovery(true);
		
		Map<String,String> options = JavaCore.getOptions();
		parser.setCompilerOptions(options);	
		
		parser.setUnitName(fileName);
		parser.setSource(file.toCharArray());
		
		CompilationUnit cu = (CompilationUnit) parser.createAST(null);
		
		return cu;
	}
	
}
