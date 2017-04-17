package tests;

import org.junit.Assert;
import org.junit.Test;

import listener.DoubleOperations;

public class DoubleTest {
	@Test
	public void testDoubleAddCancellation(){
		double val1 = Double.MAX_VALUE;
	    double val2 = 0.46329866123123;
		
		Assert.assertFalse(DoubleOperations.handleDoubleAdd(val1, val2));
		
	}
	@Test
	public void testDoubleAddNaN(){
		double val1 = 1.0/0.0;
		double val2 = 2;
		
		Assert.assertFalse(DoubleOperations.handleDoubleAdd(val1, val2));
		
	}
	
	@Test
	public void testDoubleAdd(){
		double val1 = 8.251231231231222;
		double val2 = 5.351231231231231;
		
		Assert.assertTrue(DoubleOperations.handleDoubleAdd(val1, val2));		
	}

	@Test
	public void testDoubleSubCancellation(){
		double val1 = Double.MAX_VALUE;
	    double val2 = 0.1231243498234234324;
		
	    Assert.assertFalse(DoubleOperations.handleDoubleSub(val1, val2));
		
	}
	@Test
	public void testDoubleSubNaN(){
		double val1 = Double.POSITIVE_INFINITY;
		double val2 = Double.NEGATIVE_INFINITY;
		
		Assert.assertFalse(DoubleOperations.handleDoubleSub(val2, val1));
		
	}
	
	@Test
	public void testDoubleSub(){
		double val1 = 0.4522;
		double val2 = 1.2233;
		
		Assert.assertTrue(DoubleOperations.handleDoubleSub(val1, val2));		
	}
	@Test
	public void testDoubleMultCancellation(){
		double val1 = 0.463298661231233443834945;
		double val2 = 0.123429894554845934589345;
		
		Assert.assertFalse(DoubleOperations.handleDoubleMult(val1, val2));
		
	}
	@Test
	public void testDoubleMultNaN(){
		double val1 = Double.POSITIVE_INFINITY;
		double val2 = 5;
		
		Assert.assertFalse(DoubleOperations.handleDoubleMult(val1, val2));
		
	}
	
	@Test
	public void testDoubleMult(){
		double val1 = 8.0212323;
		double val2 = 5.05123123;
		
		Assert.assertTrue(DoubleOperations.handleDoubleMult(val1, val2));		
	}
	@Test
	public void testDoubleDivCancellation(){
		double val1 = 0.46329866123123;
		double val2 = Double.MAX_VALUE;
		
		Assert.assertFalse(DoubleOperations.handleDoubleDiv(val1, val2));
		
	}
	@Test
	public void testDoubleDivNaN(){
		double val1 = Double.MIN_VALUE;
		double val2 = 5;
		
		Assert.assertFalse(DoubleOperations.handleDoubleDiv(val1, val2));
		
	}
	
	@Test
	public void testDoubleDiv(){
		double val1 = 1;
		double val2 = 1;
		
		Assert.assertTrue(DoubleOperations.handleDoubleDiv(val1, val2));		
	}

}
