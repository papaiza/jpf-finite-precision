package main;

public class DoubleMain {
	public static void main(String[] args) {
		double f = 0.35f;
		double g = 2.11f;
		// This should pass
		double x = f + g;		
		
		double aa = 0.890123f;
		double bb = 0.543212f;
		// This should pass
		double y = aa + bb;
		
		double a = Double.MAX_VALUE;
	    double b = 0.46329866f;
	    // This should fail
	    double res = a + b;
	    
	    double a2 = Double.MAX_VALUE;
	    double b2 = 0.4f;
	    // This should fail
	    double res2 = a2 - b2;
	    
	    double a3 = Double.MAX_VALUE;
	    double b3 = 0.46329866f;
	    // This should fail
	    double res3 = a3 * b3;
	    
	    double a4 = Double.MAX_VALUE;
	    double b4 = 20.46329866f;
	    // This should fail
	    double res4 = a4 / b4;
	}
}
