package data;

import org.eclipse.jdt.core.dom.MethodDeclaration;

/**
 * MethodData stores all information about a method. 
 * @author Angus Walsh
 *
 */
public class MethodData extends DataPackage {
	/**
	 * Variables
	 */
	private int lineNumber;
	
	/**
	 * Constructor differs from super in that it specifies the AST node as a MethodDeclaration and stores
	 * the line number the method was found in the class.
	 * @param _name
	 * @param _lineNumber
	 * @param _methodAsString
	 * @param _node
	 */
	public MethodData(String _name, int _lineNumber, String _methodAsString, MethodDeclaration _node) {		
		super(_name, _methodAsString, _node);
		lineNumber = _lineNumber;
	}
	
	/**
	 * Accessors
	 */
	@Override
	public MethodDeclaration getASTNode() {return (MethodDeclaration)node;} // Explicitly return ASTNode as MethodDeclaration	
	public int getLineNumer() {return lineNumber;}	
}
