package main;

public class FloatMain {

	public static void main(String[] args) {
		float f = 0.35f;
		float g = 2.11f;
		// This should pass
		float x = f + g;		
		
		float aa = 0.890123f;
		float bb = 0.543212f;
		// This should pass
		float y = aa + bb;
		
		float a = Float.MAX_VALUE;
	    float b = 0.46329866f;
	    // This should fail
	    float res = a + b;
	    
	    float a2 = Float.MAX_VALUE;
	    float b2 = 0.412312312f;
	    // This should fail
	    float res2 = b2 - a2;
	    
	    float a3 = Float.MAX_VALUE;
	    float b3 = 0.46329866f;
	    // This should fail
	    float res3 = a3 * b3;
	    
	    float a4 = Float.MAX_VALUE;
	    float b4 = 20.46329866f;
	    // This should fail
	    float res4 = a4 / b4;
	    
	}

}
