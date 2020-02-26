package data;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * FileData stores all information about the file. It also stores the list of classes
 * found in the file.
 * @author Angus Walsh
 *
 */
public class FileData extends DataPackage {
	/**
	 * Variables
	 */
	private List<TypeData> types = new ArrayList<>(); // list of classes/interfaces in the file.
	
	/**
	 * Constructor differs from super in that it specifies the AST node to be accepted as a Compilation unit.
	 * @param _name
	 * @param _fileAsString
	 * @param _node
	 */
	public FileData(String _name, String _fileAsString, CompilationUnit _node)
	{		
		super(_name, _fileAsString, _node);
	}

	/**
	 * Accessors
	 */
	@Override
	public CompilationUnit getASTNode() { return (CompilationUnit)node; } // Explicitly return ASTNode as CompilationUnit
	public List<TypeData>  getTypes() { return types; }
	public TypeData getTypeData(int index) { return types.get(index); }
	
	/**
	 * addTypeData adds a class/interface to the list associated with this file.
	 * @param _type
	 */
	public void addTypeData(TypeData _type) { types.add(_type); }
	
	/**
	 * getMethods returns a list of references to all the methods found in all the classes/interfaces
	 * contained in this file.
	 * @return methods
	 */
	public List<MethodData>  getMethods() {
		List<MethodData> methods = new ArrayList<>();		
		for(TypeData td: types) {
			for(MethodData md: td.getMethods()) {
				methods.add(md);
			}
		}		
		return methods;
	}
	
	/**
	 * getMethodData gets a specific method in the file.
	 * @param index
	 * @return MethodData
	 */
	public MethodData getMethodData(int index) {return getMethods().get(index);}
}
