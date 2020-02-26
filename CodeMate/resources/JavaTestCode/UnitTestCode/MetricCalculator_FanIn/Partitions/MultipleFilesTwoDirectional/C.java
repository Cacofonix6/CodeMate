import java.util.*;
import java.io.IOException;

public class C {
	private A a;
	private B b;
	
	public C(A _a, B _b) {
		a = _a;
		b = _b;
	}
	
	public void funcC() {
		a.funcA();
	}
	
	public void otherFuncC() {
		a.otherFuncA();
		b.otherFuncB();
	}
}