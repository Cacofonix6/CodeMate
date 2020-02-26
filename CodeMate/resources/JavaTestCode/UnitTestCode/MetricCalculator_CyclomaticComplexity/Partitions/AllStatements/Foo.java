
public class Foo {
	
	// 1
	public void cyclomaticFunc()  {
		
		private int a = 1;
		private int b = 2;
		private int c = 3;
		private int result = 0;
		private int counter = 0;
		private int[] array = new int[] {1,2,3,4,5};
	
		// 2
		if (a == b)  {
			
			// 3
			result = (b > c) ? b : c;
			
			// 4
			switch (a)
			{
				case 1:
					result = 3;
					break;
			}
			
			try {
				a = 5;
				result = 4;
				
				// 5
			} catch(Exception e) {
				
			}
		}
		
		// 6
		while (a == b)  {
			a = 2;
			
			// 7
			for (int i = 0; i < 5; i++) {
				a++;
			}
		}
		
		// 8
		do  {
			a = 2;
			
			// 9
			for (int iter : array) {
				counter++;
			}
			
		} while (a == b);
    }
	
	// 1
	public void controlFunc()  {
	
    }
}