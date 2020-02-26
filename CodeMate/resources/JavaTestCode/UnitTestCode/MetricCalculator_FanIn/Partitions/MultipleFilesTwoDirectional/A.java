import java.util.*;
import java.io.IOException;

public class A {
	
	private B b;
	private C c;
	
	public A(B _b, C _c) {
		b = _b;
		c = _c;
	}
	
	public void funcA() {
		b.funcB();
	}
	
	public void otherFuncA() {
		c.otherFuncC();
	}
}


