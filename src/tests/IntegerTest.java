package tests;

import org.junit.Assert;
import org.junit.Test;


import listener.IntegerOperations;

public class IntegerTest {
	@Test
	public void testIntegerAddOverflow(){
		int val1 = Integer.MAX_VALUE;
		int val2 = 5;
		
		Assert.assertFalse(IntegerOperations.handleIntAdd(val1, val2));
		
	}
	
	@Test
	public void testIntegerAddUnderflow(){
		int val1 = Integer.MIN_VALUE;
		int val2 = -5;
		
		Assert.assertFalse(IntegerOperations.handleIntAdd(val1, val2));
		
	}
	
	@Test
	public void testIntegerAdd(){
		int val1 = 8;
		int val2 = 5;
		
		Assert.assertTrue(IntegerOperations.handleIntAdd(val1, val2));		
	}
	
	@Test
	public void testIntegerSubOverflow(){
		int val1 = Integer.MAX_VALUE;
		int val2 = -5;
		
		Assert.assertFalse(IntegerOperations.handleIntSub(val2, val1));
		
	}
	
	@Test
	public void testIntegerSubUnderflow(){
		int val1 = Integer.MIN_VALUE;
		int val2 = 5;
		
		Assert.assertFalse(IntegerOperations.handleIntSub(val2, val1));
		
	}
	
	@Test
	public void testIntegerSub(){
		int val1 = 8;
		int val2 = 5;
		
		Assert.assertTrue(IntegerOperations.handleIntSub(val1, val2));		
	}
	
	@Test
	public void testIntegerMultOverflow(){
		int val1 = Integer.MAX_VALUE;
		int val2 = 5;
		
		Assert.assertFalse(IntegerOperations.handleIntMult(val1, val2));
		
	}
	
	@Test
	public void testIntegerMultUnderflow(){
		int val1 = Integer.MIN_VALUE;
		int val2 = 5;
		
		Assert.assertFalse(IntegerOperations.handleIntMult(val1, val2));
		
	}
	
	@Test
	public void testIntegerMult(){
		int val1 = 8;
		int val2 = 5;
		
		Assert.assertTrue(IntegerOperations.handleIntMult(val1, val2));		
	}
	
	@Test
	public void testIntegerDivOverflow(){
		int val1 = -1;
		int val2 = Integer.MIN_VALUE;
		
		Assert.assertFalse(IntegerOperations.handleIntDiv(val1, val2));
		
	}
	
	@Test
	public void testIntegerDiv(){
		int val1 = 8;
		int val2 = 5;
		
		Assert.assertTrue(IntegerOperations.handleIntDiv(val1, val2));		
	}
	
}
