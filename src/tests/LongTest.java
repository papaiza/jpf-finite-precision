package tests;

import org.junit.Test;

import listener.LongOperations;

public class LongTest {
	@Test(expected=ArithmeticException.class)
	public void testLongAddOverflow(){
		long val1 = Long.MAX_VALUE;
		long val2 = 5;
		
		LongOperations.handleLongAdd(val1, val2);
		
	}
	
	@Test(expected=ArithmeticException.class)
	public void testLongAddUnderflow(){
		long val1 = Long.MIN_VALUE;
		long val2 = -5;
		
		LongOperations.handleLongAdd(val1, val2);
		
	}
	
	@Test
	public void testLongAdd(){
		long val1 = 8;
		long val2 = 5;
		
		LongOperations.handleLongAdd(val1, val2);		
	}
	
	@Test(expected=ArithmeticException.class)
	public void testLongSubOverflow(){
		long val1 = Long.MAX_VALUE;
		long val2 = -5;
		
		LongOperations.handleLongSub(val2, val1);
		
	}
	
	@Test(expected=ArithmeticException.class)
	public void testLongSubUnderflow(){
		long val1 = Long.MIN_VALUE;
		long val2 = 5;
		
		LongOperations.handleLongSub(val2, val1);
		
	}
	
	@Test
	public void testLongSub(){
		long val1 = 8;
		long val2 = 5;
		
		LongOperations.handleLongSub(val1, val2);		
	}
	
	@Test(expected=ArithmeticException.class)
	public void testLongMultOverflow(){
		long val1 = Long.MAX_VALUE;
		long val2 = 5;
		
		LongOperations.handleLongMult(val1, val2);
		
	}
	
	@Test(expected=ArithmeticException.class)
	public void testLongMultUnderflow(){
		long val1 = Long.MIN_VALUE;
		long val2 = 5;
		
		LongOperations.handleLongMult(val1, val2);
		
	}
	
	@Test
	public void testLongMult(){
		long val1 = 8;
		long val2 = 5;
		
		LongOperations.handleLongMult(val1, val2);		
	}
	
	@Test(expected=ArithmeticException.class)
	public void testLongDivOverflow(){
		long val1 = -1;
		long val2 = Long.MIN_VALUE;
		
		LongOperations.handleLongDiv(val1, val2);
		
	}
	
	@Test
	public void testLongDiv(){
		long val1 = 8;
		long val2 = 5;
		
		LongOperations.handleLongDiv(val1, val2);		
	}
}
