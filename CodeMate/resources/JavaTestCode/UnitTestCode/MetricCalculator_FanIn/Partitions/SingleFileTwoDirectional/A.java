import java.util.*;
import java.io.IOException;

public class A {
	
	public void funcA() {
		otherFuncA();
	}
	
	public void otherFuncA() {
		funcA();
		funcA();
	}
}