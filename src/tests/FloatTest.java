package tests;

import org.junit.Test;

import listener.FloatOperations;

public class FloatTest {
	@Test(expected=ArithmeticException.class)
	public void testFloatAddOverflow(){
		float val1 = Float.MAX_VALUE;
		float val2 = 5;
		
		FloatOperations.handleFloatAdd(val1, val2);
		
	}
	
	@Test(expected=ArithmeticException.class)
	public void testFloatAddUnderflow(){
		float val1 = Float.MIN_VALUE;
		float val2 = -5;
		
		FloatOperations.handleFloatAdd(val1, val2);
		
	}
	
	@Test
	public void testFloatAdd(){
		float val1 = 8;
		float val2 = 5;
		
		FloatOperations.handleFloatAdd(val1, val2);		
	}
	
	@Test(expected=ArithmeticException.class)
	public void testFloatSubOverflow(){
		float val1 = Float.MAX_VALUE;
		float val2 = -5;
		
		FloatOperations.handleFloatSub(val2, val1);
		
	}
	
	@Test(expected=ArithmeticException.class)
	public void testFloatSubUnderflow(){
		float val1 = Float.MIN_VALUE;
		float val2 = 5;
		
		FloatOperations.handleFloatSub(val2, val1);
		
	}
	
	@Test
	public void testFloatSub(){
		float val1 = 8;
		float val2 = 5;
		
		FloatOperations.handleFloatSub(val1, val2);		
	}
	
	@Test(expected=ArithmeticException.class)
	public void testFloatMultOverflow(){
		float val1 = Float.MAX_VALUE;
		float val2 = 5;
		
		FloatOperations.handleFloatMult(val1, val2);
		
	}
	
	@Test(expected=ArithmeticException.class)
	public void testFloatMultUnderflow(){
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
	public void testFloatDivOverflow(){
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
