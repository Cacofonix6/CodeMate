
public class DepthOfConditionalNestingTest {
	//should return 3
	public void testDepth1() {
		int a = 3;
		int b = 5;
		int c = 2;
		if(a>b) {
			if(b>c){
				
			}
			else {
				if(b == 5) {

				}
			}
		}
		else {
			
		}
	}
	
	public int testDepth2() {
		//should return 4
	int a = 3;
	int b = 5;
	int c = 2;
	if(a>b) {
		for(int i =0;i<8;i++){
			if(b>c){
				
			}
			else {
				if(b == 5) {
					if(b == 5) {
						
					}
				}
			}
		}
	}
	else {
		
	}
	return a;
	}
}