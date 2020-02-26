import java.util.*;

import data.MetricData;
import data.MethodData;
import helper.Utility;

import java.io.IOException;

public class FanOutTest{
	// Class fan out count = 7 (4 unique)
	
	// Method fan out = 2
	public void main(String args[]) throws IOException{
		MetricData metric = new MetricData();
		MethodData method = new MethodData();
		FanOutTest fot = new FanOutTest();
		
		Utility.Test();
		
		fot.start();
		
		FileData fileData = new FileData();
		
		metric.getName();
		metric.getValue();
		
	}
	
	// Method fan out = 3
	private void start(){
		MetricData metric = new MetricData();
		metric.getName();
		metric.getValue();
		metric.setValue(2);
	}
}

public class FanOutTest2{
	public void testing() {
		FanOutTest fot = new FanOutTest();
	}
}

enum blah{Blaeg}