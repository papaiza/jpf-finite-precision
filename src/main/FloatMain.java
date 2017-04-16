package main;
import static java.lang.Math.*;

public class FloatMain {

	public static void main(String[] args) {
		float f = 0.35f;
		float g = 2.11f;
		// This should pass
		float x = f + g;
//		System.out.println(x);
		
		
		float aa = 0.890123f;
		float bb = 0.543212f;
		// This should pass
		float y = aa + bb;
//		System.out.println(y);
		
		float a = Float.MAX_VALUE;
	    float b = 0.46329866f;
	    // This should fail
	    float res = a + b;
//	    System.out.println(res);
	    
	}

}
