import java.util.*;
import java.io.*; 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
 
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Comment;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.LineComment;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
 
public class parser {
	
	private static int methodCount = 0;

	public parser(){
	}
	
	//reads text file to string from path
	public static String readFileToString(String filePath) throws IOException {
		StringBuilder fileData = new StringBuilder(1000);
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
			char[] buf = new char[10];
			int numRead = 0;
			while ((numRead = reader.read(buf)) != -1) {
				//System.out.println(numRead);
				String readData = String.valueOf(buf, 0, numRead);
				fileData.append(readData);
				buf = new char[1024];
			}
			reader.close();
		}
		catch(IOException e){
			//test
		}
		return  fileData.toString();	
	}
	
	//havn't tested this method
	public static void ParseFilesInDir() throws IOException{
		//File dirs = new File(".");
		//String dirPath = dirs.getCanonicalPath() + File.separator+"src"+File.separator;
 
		//File root = new File(dirPath);
		//System.out.println(rootDir.listFiles());
		//File[] files = root.listFiles ( );
		//String filePath = null;
 
		 //for (File f : files ) {
			 //filePath = f.getAbsolutePath();
			 //if(f.isFile()){
				 //start(readFileToString(filePath).toCharArray());
			 //}
		 //}
	}
	
	//calls readFileToString
	//creates compilation unit
	//counts number of method declarations
	//prints number of method declarations
	public static void start(String input) throws IOException{
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		input = readFileToString(input);
		//parser.setSource("public class A { int i = 9;  \n int j; \n ArrayList<Integer> al = new ArrayList<Integer>();j=1000; public void testMethod(){\\this is a comment\nSystem.out.print();} }".toCharArray());
		parser.setSource(input.toCharArray());
		//parser.setSource("/*abc*/".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		//ASTNode node = parser.createAST(null);
 
		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
		//System.out.println(cu.toString());
		cu.accept(new ASTVisitor() {
			
			//these are the visitors of the parser, can add more (read documentation)
			public boolean visit(MethodDeclaration node) {
		        //int startLineNumber = cu.getLineNumber(node.getStartPosition()) - 1;
				//System.out.println(startLineNumber +" "+node.toString());
		        methodCount++;
				return true;
		    }
			
		});
		System.out.println("Number of methods: "+methodCount);
	}


	/*
	public void startAnalysis(){

		ASTParser parser = ASTParser.newParser(AST.JLS3);
		input = readFileToString(input);
		parser.setSource(input.toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);

		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);

		List<Metric> metricList;
		for each metric {
			create metricType
			add metricType to listFiles
			metricType.calculate(cu)
		}

		calcAttributes(metricList);
	}

	*/
}