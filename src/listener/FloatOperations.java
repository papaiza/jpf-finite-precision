package listener;

import java.math.BigDecimal;

public class FloatOperations {
	
	/*
	 * Handle Float Division Overflow
	 */
	public static void handleFloatAdd(float val1, float val2) {
		
		float result = val1 + val2;
		
		if(isNaN(result)){
			throw new ArithmeticException("Result is not a number: " + val1 + " + " + val2 + " = " + result);
		}
		
		BigDecimal v1 = new BigDecimal(val1);
		BigDecimal v2 = new BigDecimal(val2);
		BigDecimal res = new BigDecimal(result);
		BigDecimal comp = new BigDecimal(1e-4);
		
		if(checkCancellation(val1, val2, result) || (v1.add(v2).subtract(res).compareTo(comp) == 1)){
			throw new ArithmeticException("Result will have a potential round off error: " + val1 + " + " + val2 + " = " + result);
		}
		
		
	}
	
	
	
	/*
	 * Handle Float Subtraction Overflow and Underflow
	 */
	public static void handleFloatSub(float val1, float val2){
		
		float result = val1 - val2;
		BigDecimal v1 = new BigDecimal(val1);
		BigDecimal v2 = new BigDecimal(val2);
		BigDecimal res = new BigDecimal(result);
		BigDecimal comp = new BigDecimal(1e-4);
		
		if(isNaN(result)){
			throw new ArithmeticException("Result is not a number: " + val1 + " - " + val2 + " = " + result);
		}
		
		if(checkCancellation(val1, val2, result) || (v1.add(v2).subtract(res).compareTo(comp) == 1)){
			throw new ArithmeticException("Result will have a potential round off error: " + val1 + " - " + val2 + " = " + result);
		}
		
	}
	
	/*
	 * Handle Float Multiplication Overflow and Underflow
	 */
	public static void handleFloatMult(float val1, float val2){
		
		float result = val1 * val2;
		BigDecimal v1 = new BigDecimal(val1);
		BigDecimal v2 = new BigDecimal(val2);
		BigDecimal res = new BigDecimal(result);
		BigDecimal comp = new BigDecimal(1e-4);
		
		if(isNaN(result)){
			throw new ArithmeticException("Result is not a number: " + val1 + " * " + val2 + " = " + result);
		}
		
		if(checkCancellation(val1, val2, result) || (v1.add(v2).subtract(res).compareTo(comp) == 1)){
			throw new ArithmeticException("Result will have a potential round off error: " + val1 + " * " + val2 + " = " + result);
		}
		
	}
	
	/*
	 * Handle Float Division Overflow
	 */
	public static void handleFloatDiv(float val1, float val2){
		
		float result = val2 / val1;
		BigDecimal v1 = new BigDecimal(val1);
		BigDecimal v2 = new BigDecimal(val2);
		BigDecimal res = new BigDecimal(result);
		BigDecimal comp = new BigDecimal(1e-4);
		
		if(isNaN(result)){
			throw new ArithmeticException("Result is not a number: " + val2 + " / " + val1 + " = " + result);
		}
		
		if(checkCancellation(val1, val2, result) || (v1.add(v2).subtract(res).compareTo(comp) == 1)){
			throw new ArithmeticException("Result will have a potential round off error: " + val2 + " / " + val1 + " = " + result);
		}
		
	}
	
	private static boolean isNaN(float val){
		return Float.isNaN(val) || Float.isInfinite(val);
	}
	
	/*
	 * Method to check whether a catastrophic cancellation would occur.
	 * Strategy found  on page 2 of :
	 * https://pdfs.semanticscholar.org/484a/c19ab1b94d59ab72fe75b864aabdcf141cba.pdf
	 */
	private static boolean checkCancellation (float f1, float f2, float res){	    
	    int bits1 = Float.floatToIntBits(f1);
	    int exponent1 = ((bits1 & 0x7f800000) >> 22);
	    

	    int bits2 = Float.floatToIntBits(f2);
	    int exponent2 = ((bits2 & 0x7f800000) >> 22);
	    
	    int bitsRes = Float.floatToIntBits(res);
	    int exponentRes = ((bitsRes & 0x7f800000) >> 22);
	    System.out.printf("V1: %.6f, V2: %.6f, Res: %.6f\n", f1, f2, res);
	    System.out.printf("Bits1: %d , Bits2: %d, BitsRes: %d\n", exponent1, exponent2, exponentRes);
	  

	    if(Math.max(exponent1, exponent2) - exponentRes >= 3){
	    	return true;
	    }else{
	    	return false;
	    }

	  }

}
