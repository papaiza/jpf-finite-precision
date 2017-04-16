package tests;

import org.junit.Test;

import listener.FloatOperations;

public class FloatTest {
	@Test(expected=ArithmeticException.class)
	public void testFloatAddCancellation(){
		float val1 = Float.MAX_VALUE;
	    float val2 = 0.463298662704123123f;
		
		FloatOperations.handleFloatAdd(val1, val2);
		
	}
	
	@Test(expected=ArithmeticException.class)
	public void testFloatAddNaN(){
		float val1 = 1.0f/0.0f;
		float val2 = 2;
		
		FloatOperations.handleFloatAdd(val1, val2);
		
	}
	
	@Test
	public void testFloatAdd(){
		float val1 = 8.25123123f;
		float val2 = 5.35123123f;
		
		FloatOperations.handleFloatAdd(val1, val2);		
	}
	
	@Test(expected=ArithmeticException.class)
	public void testFloatSubCancellation(){
		float val1 = Float.MAX_VALUE;
	    float val2 = 0.463298662704123123f;
		
		FloatOperations.handleFloatSub(val2, val1);
		
	}
	
	@Test(expected=ArithmeticException.class)
	public void testFloatSubNaN(){
		float val1 = Float.NEGATIVE_INFINITY;
		float val2 = Float.POSITIVE_INFINITY;
		
		FloatOperations.handleFloatSub(val2, val1);
		
	}
	
	@Test
	public void testFloatSub(){
		float val1 = 8.1234123f;
		float val2 = 5.123123234f;
		
		FloatOperations.handleFloatSub(val1, val2);		
	}
	
	@Test(expected=ArithmeticException.class)
	public void testFloatMultCancellation(){
		float val1 = Float.MAX_VALUE;
		float val2 = 5;
		
		FloatOperations.handleFloatMult(val1, val2);
		
	}
	
	@Test(expected=ArithmeticException.class)
	public void testFloatMultNaN(){
		float val1 = Float.MIN_VALUE;
		float val2 = 5;
		
		FloatOperations.handleFloatMult(val1, val2);
		
	}
	
	@Test
	public void testFloatMult(){
		float val1 = 8;
		float val2 = 5;
		
		FloatOperations.handleFloatMult(val1, val2);		
	}
	
	@Test(expected=ArithmeticException.class)
	public void testFloatDivCancellation(){
		float val1 = -1;
		float val2 = Float.MIN_VALUE;
		
		FloatOperations.handleFloatDiv(val1, val2);
		
	}
	
	@Test
	public void testFloatDiv(){
		float val1 = 8;
		float val2 = 5;
		
		FloatOperations.handleFloatDiv(val1, val2);		
	}

}
