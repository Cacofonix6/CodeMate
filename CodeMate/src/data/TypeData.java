package data;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.TypeDeclaration;

/**
 * TypeData stores all information about a class/interface. It also stores a 
 * list of methods found in the class.
 * @author Angus Walsh
 *
 */
public class TypeData extends DataPackage {

	/**
	 * Variables
	 */
	private int lineNumber;
	private String classInterface;
	private List<MethodData> methods = new ArrayList<>();
	
	/**
	 * Constructor differs from super in that it specifies the AST node as a TypeDeclaration, stores the line
	 * number the type was found in the document and if it's an interface instead of a class.
	 * @param _name
	 * @param _lineNumber
	 * @param _typeAsString
	 * @param _node
	 * @param _isInterface
	 */
	public TypeData(String _name, int _lineNumber, String _typeAsString, TypeDeclaration _node, boolean _isInterface) {
		super(_name, _typeAsString, _node);
		lineNumber = _lineNumber;		
		if(_isInterface)
			classInterface = "Interface";
		else
			classInterface = "Class";
	}
	
	/**
	 * Accessors
	 */
	@Override
	public TypeDeclaration getASTNode() {return (TypeDeclaration)node;} // Explicitly return ASTNode as TypeDeclaration	
	public List<MethodData>  getMethods() {return methods;}	
	public int getLineNumer() {return lineNumber;}	
	public String getTypeType() {return classInterface;}
	
	/**
	 * getMethodData retruns a method at a specific index
	 * @param index
	 * @return MethodData
	 */
	public MethodData getMethodData(int index) {return methods.get(index);}
	
	/**
	 * addMethodData adds a method to the list associated with this type.
	 * @param methodData
	 */
	public void addMethodData(MethodData methodData) {methods.add(methodData);}
}
