import java.util.*;
import java.io.IOException;

public class A {
	
	private B b;
	
	public A(B _b) {
		b = _b;
	}
	
	public void funcA() {
		b.funcB();
		b.funcB();
	}
	
	public void otherFuncA() {
		b.otherFuncB();
	}
}