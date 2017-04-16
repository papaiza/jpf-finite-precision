package tests;

import org.junit.Assert;
import org.junit.Test;

import listener.DoubleOperations;

public class DoubleTest {
	@Test
	public void testDoubleAddCancellation(){
		double val1 = Double.MAX_VALUE;
	    double val2 = 0.46329866f;
		
		Assert.assertFalse(DoubleOperations.handleDoubleAdd(val1, val2));
		
	}
	@Test
	public void testDoubleAddNaN(){
		double val1 = 1.0f/0.0f;
		double val2 = 2;
		
		Assert.assertFalse(DoubleOperations.handleDoubleAdd(val1, val2));
		
	}
	
	@Test
	public void testDoubleAdd(){
		double val1 = 8.25123123f;
		double val2 = 5.35123123f;
		
		Assert.assertTrue(DoubleOperations.handleDoubleAdd(val1, val2));		
	}
	@Test
	public void testDoubleSubCancellation(){
		double val1 = Double.MIN_VALUE;
	    double val2 = Double.MAX_VALUE;
		
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
		double val1 = 0.45f;
		double val2 = 1.2f;
		
		Assert.assertTrue(DoubleOperations.handleDoubleSub(val1, val2));		
	}
	@Test
	public void testDoubleMultCancellation(){
		double val1 = 0.46329866f;
		double val2 = Double.MAX_VALUE;
		
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
		double val1 = 8.02f;
		double val2 = 5.05f;
		
		Assert.assertTrue(DoubleOperations.handleDoubleMult(val1, val2));		
	}
	@Test
	public void testDoubleDivCancellation(){
		double val1 = 0.46329866f;
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
		double val1 = 1f;
		double val2 = 1f;
		
		Assert.assertTrue(DoubleOperations.handleDoubleDiv(val1, val2));		
	}

}
