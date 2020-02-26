import java.util.*;
import java.io.IOException;

public class B {
	
	private A a;
	private C c;
	
	public B(A _a, C _c) {
		a = _a;
		c = _c;
	}
	
	public void funcB() {
		a.funcA();
	}
	
	public void otherFuncB() {
		c.otherFuncC();
	}
}