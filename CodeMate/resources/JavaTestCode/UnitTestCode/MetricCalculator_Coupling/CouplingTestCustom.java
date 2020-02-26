import java.util.*;

import data.MetricData;
import data.MethodData;
import helper.Utility;

import java.io.IOException;

// Coupling = 5
public class CouplingTest{
	
	public void main(String args[]) throws IOException{
		MetricData metric = new MetricData();
		MethodData method = new MethodData();
		CouplingTest fot = new CouplingTest();
		
		Utility.Test();
		
		fot.start();
		
		FileData fileData = new FileData();
		
		metric.getName();
		
	}
	
	private void start(){
		MetricData metric = new MetricData();
		metric.getName();
		metric.getValue();
		metric.setValue(2);
	}
}

// Coupling = 1
public class CouplingTest2{
	public void testing() {
		Utility.Test();
		CouplingTest fot = new CouplingTest();
	}
}