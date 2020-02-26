/**
 * 
 * @author PMD - https://pmd.sourceforge.io/pmd-4.3.0/rules/codesize.html
 *
 */
public class Foo {
	
	// Expected cyclomatic complexity: 12
	
	// 1
	public void example()  {
	
		// 2
		if (a == b)  {
	
			// 3
			if (a1 == b1) {
                fiddle();
                
            // 4
			} else if (a2 == b2) {
                fiddle();
                
			} else {
                fiddle();
			}

		// 5
		} else if (c == d) {
	
			// 6
			while (c == d) {
                fiddle();
			}

		// 7
		} else if (e == f) {
	
			// 8
			for (int n = 0; n < h; n++) {
                fiddle();
			}
			
		} else {
			
            switch (z) {
            
            	// 9
            	case 1:
                    fiddle();
                    break;
                    
                // 10
            	case 2:
                    fiddle();
                    break;
                    
                // 11
            	case 3:
                    fiddle();
                    break;
                    
                // 12
            	case 4:
                    fiddle();
                    break;
            }
        }
    }
}