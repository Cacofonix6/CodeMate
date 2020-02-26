import java.util.*;
import java.io.IOException;

public class B {
	
	private A a;
	
	public B(A _a) {
		a = _a;
	}
	
	public void funcA() {
		
	}
	
	public void funcB() {
		a.funcA();
		a.funcA();
		funcA();
	}
}