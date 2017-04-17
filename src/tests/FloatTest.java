package tests;

import org.junit.Assert;
import org.junit.Test;

import listener.FloatOperations;

public class FloatTest {
	@Test
	public void testFloatAddCancellation(){
		float val1 = Float.MAX_VALUE;
	    float val2 = 0.46329866f;
		
		Assert.assertFalse(FloatOperations.handleFloatAdd(val1, val2));
		
	}
	@Test
	public void testFloatAddNaN(){
		float val1 = 1.0f/0.0f;
		float val2 = 2;
		
		Assert.assertFalse(FloatOperations.handleFloatAdd(val1, val2));
		
	}
	
	@Test
	public void testFloatAdd(){
		float val1 = 8.25123123f;
		float val2 = 5.35123123f;
		
		Assert.assertTrue(FloatOperations.handleFloatAdd(val1, val2));		
	}
	@Test
	public void testFloatSubCancellation(){
		float val1 = Float.MAX_VALUE;
	    float val2 = 0.1231243f;
				
	    Assert.assertFalse(FloatOperations.handleFloatSub(val1, val2));
		
	}
	@Test
	public void testFloatSubNaN(){
		float val1 = Float.POSITIVE_INFINITY;
		float val2 = Float.NEGATIVE_INFINITY;
		
		Assert.assertFalse(FloatOperations.handleFloatSub(val2, val1));
		
	}
	
	@Test
	public void testFloatSub(){
		float val1 = 0.890123f;
		float val2 = 0.543212f;
		
		Assert.assertTrue(FloatOperations.handleFloatSub(val1, val2));		
	}
	@Test
	public void testFloatMultCancellation(){
		float val1 = 0.46329866f;
		float val2 = Float.MAX_VALUE;
		
		Assert.assertFalse(FloatOperations.handleFloatMult(val1, val2));
		
	}
	@Test
	public void testFloatMultNaN(){
		float val1 = Float.POSITIVE_INFINITY;
		float val2 = 5;
		
		Assert.assertFalse(FloatOperations.handleFloatMult(val1, val2));
		
	}
	
	@Test
	public void testFloatMult(){
		float val1 = 8.02f;
		float val2 = 5.05f;
		
		Assert.assertTrue(FloatOperations.handleFloatMult(val1, val2));		
	}
	@Test
	public void testFloatDivCancellation(){
		float val1 = 0.46329866f;
		float val2 = Float.MAX_VALUE;
		
		Assert.assertFalse(FloatOperations.handleFloatDiv(val1, val2));
		
	}
	@Test
	public void testFloatDivNaN(){
		float val1 = Float.MIN_VALUE;
		float val2 = 5;
		
		Assert.assertFalse(FloatOperations.handleFloatDiv(val1, val2));
		
	}
	
	@Test
	public void testFloatDiv(){
		float val1 = 1f;
		float val2 = 1f;
		
		Assert.assertTrue(FloatOperations.handleFloatDiv(val1, val2));		
	}

}
