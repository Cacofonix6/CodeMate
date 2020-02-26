package metriccalculator;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.MethodInvocation;

import data.FileData;
import data.MetricData;
import data.TypeData;
import helper.Keys;

/**
 * MetricCalculator_Coupling is the implementation of the coupling metric.
 * @author Angus Walsh
 *
 */
public class MetricCalculator_Coupling extends MetricCalculator {
	
	/**
	 * Variables
	 */
	private String metricNameClassCoupling = "Coupling";	

	/**
	 * calculate is the implementation of the coupling metric.
	 * @param _fileData
	 */
	@Override
	public void calculate(List<FileData> _fileData) {
		// Extract a reference to all the classes from the files
		List<TypeData> allClasses = new ArrayList<>();		
		for(FileData fileData: _fileData) {
			for(TypeData typeData: fileData.getTypes()) {
				allClasses.add(typeData);
			}
		}
		
		// Calculate for every class. An index is used because every class needs to look at 
		// every other class.
		for(int currentIndex = 0; currentIndex < allClasses.size(); currentIndex++) {
			
			String currentType = allClasses.get(currentIndex).getName();
			
			// Find all the classes called by this class (including duplicates)
			List<String> totalClasses = totalTypesCalled(allClasses.get(currentIndex));
			
			// Use a LinkedHashSet to remove all duplicate classes and save it in a separate list
			LinkedHashSet<String> hasSetOut = new LinkedHashSet<>(totalClasses);
			List<String> uniqueClassesOut = new ArrayList<>(hasSetOut);

			// Find all classes that call the current class
			List<String> totalClassesIn = new ArrayList<>();			
			for(int otherIndex = 0; otherIndex < allClasses.size(); otherIndex++) {
				if(otherIndex != currentIndex) {
					// For every other class find all the classes it calls.
					List<String> tempTotalClasses = totalTypesCalled(allClasses.get(otherIndex));
										
					// See if any of those calls were this class, if so, add them
					for(String s: tempTotalClasses) {
						if(s.equals(currentType)) {
							totalClasses.add(allClasses.get(otherIndex).getName());
							totalClassesIn.add(allClasses.get(otherIndex).getName());
							break;
						}
					}
				}
			}
			
			// Use a LinkedHashSet to remove all duplicate classes
			LinkedHashSet<String> hasSetIn = new LinkedHashSet<>(totalClassesIn);
			List<String> uniqueClassesIn = new ArrayList<>(hasSetIn);
			
			LinkedHashSet<String> hasSet = new LinkedHashSet<>(totalClasses);
			List<String> uniqueClasses = new ArrayList<>(hasSet);
			
			/*
			 * There is now a list of all the classes coupled to this class (uniqueClasses)
			 * A list of all the classes coupled from this class to another (uniqueClassesOut)
			 * And a list of all the classes coupled from other classes to this one (uniqueClassesIn)
			 */
			
			// Create a metric to save the results.
			int result = uniqueClasses.size();
			MetricData metric = new MetricData(metricNameClassCoupling, result);
			
			// Create a recommendation
			String rec = "";			
			if(result > 9) {
				rec += "\n      * Coupling may be too high, try abstracting.";
			}			
			rec += "\n      * " + currentType + " calls: ";
			
			for (String s: uniqueClassesOut) {
				rec += "(" + s + ") ";
			}
			rec += "\n      * Is called by: ";
			
			for (String s: uniqueClassesIn) {
				rec += "(" + s + ") ";
			}
			
			// set the recommendation and add the metric.
			metric.setRecommendation(rec);				
			allClasses.get(currentIndex).addMetricData(Keys.COUPLING.toString(), metric);			
		}
					
	}// calculate
	
	/**
	 * totalTypesCalled returns all the types found either by declaration of a type or from 
	 * a method invocation that belongs to a type. 
	 * @param _typeData
	 * @return
	 */
	private List<String> totalTypesCalled(TypeData _typeData){
		List<String> totalClasses = new ArrayList<>();
		// create a visitor to traverse the AST.
		ASTVisitor methodInvVisitor = new ASTVisitor(){
			// override the visit function that visits MethodInvocation nodes.
			@Override
			public boolean visit(MethodInvocation _node) {
				String name = null;
				// check the binding information is set before trying to access it.
				if(_node.resolveMethodBinding() != null) {
					name = _node.resolveMethodBinding().getDeclaringClass().getName().toString();
				}
				// if the declaring type was found and it isn't the current type then add it
				if(name != null && !name.equals(_typeData.getName()))
					totalClasses.add(name);
				return true;
			}
			
		};// End of "visitor"			
		_typeData.getASTNode().accept(methodInvVisitor);
		
		// create a visitor to find all the declaration of classes.
		ASTVisitor classDecVisitor = new ASTVisitor(){			
			@Override
			public boolean visit(ClassInstanceCreation _node) {
				String name = _node.getType().toString();
				
				if(!name.equals(_typeData.getName()))
					totalClasses.add(name);
				return true;
			}
			
		};// End of "visitor"			
		_typeData.getASTNode().accept(classDecVisitor);
				
		return totalClasses;
	}
}// MetricCalculator_Coupling

