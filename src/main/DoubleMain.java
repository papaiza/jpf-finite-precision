package main;

public class DoubleMain {
	public static void main(String[] args) {
		double f = 0.35;
		double g = 2.11;
		// This should pass
		double x = f + g;		
		
		double aa = 0.890123134233;
		double bb = 0.543212234522;
		// This should pass
		double y = aa + bb;
		
		double a = Double.MAX_VALUE;
	    double b = 0.4632986623433;
	    // This should fail
	    double res = a + b;
	    
	    double a2 = Double.MAX_VALUE;
	    double b2 = 0.42343234;
	    // This should fail
	    double res2 = b2 - a2;
	    
	    double a3 = Double.MAX_VALUE;
	    double b3 = 0.46329866;
	    // This should fail
	    double res3 = a3 * b3;
	    
	    double a4 = Double.MAX_VALUE;
	    double b4 = 20.46329866;
	    // This should fail
	    double res4 = a4 / b4;
	}
}
