
public class Foo {
	
	// 1
	public void cyclomaticFunc()  {
	
		int b = 2;
		int c = 3;
		int result;
		
		// 2
		result = (b > c) ? b : c;
		// 3
		result = (b > c) ? b : c;
		// 4
		result = (b > c) ? b : c;
		// 5
		result = (b > c) ? b : c;
		// 6
		result = (b > c) ? b : c;
		// 7
		result = (b > c) ? b : c;
    }
	
	// 1
	public void controlFunc()  {
	
    }
}