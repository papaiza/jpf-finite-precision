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
		
		if(checkCancellation(val1, val2, result, "+")){
			throw new ArithmeticException("Result will have a potential round off error: " + val1 + " + " + val2 + " = " + result);
		}
		
		
	}
	
	/*
	 * Handle Float Subtraction Overflow and Underflow
	 */
	public static void handleFloatSub(float val1, float val2){
		
		float result = val2 - val1;
		
		if(isNaN(result)){
			throw new ArithmeticException("Result is not a number: " + val1 + " - " + val2 + " = " + result);
		}
		
		if(checkCancellation(val1, val2, result, "-")){
			throw new ArithmeticException("Result will have a potential round off error: " + val1 + " - " + val2 + " = " + result);
		}
		
	}
	
	/*
	 * Handle Float Multiplication Overflow and Underflow
	 */
	public static void handleFloatMult(float val1, float val2){
		
		float result = val1 * val2;
		
		if(isNaN(result)){
			throw new ArithmeticException("Result is not a number: " + val1 + " * " + val2 + " = " + result);
		}
		
		if(checkCancellation(val1, val2, result, "*")){
			throw new ArithmeticException("Result will have a potential round off error: " + val1 + " * " + val2 + " = " + result);
		}
		
	}
	
	/*
	 * Handle Float Division Overflow
	 */
	public static void handleFloatDiv(float val1, float val2){
		
		float result = val2 / val1;
		
		if(isNaN(result)){
			throw new ArithmeticException("Result is not a number: " + val2 + " / " + val1 + " = " + result);
		}
		
		if(checkCancellation(val1, val2, result, "/")){
			throw new ArithmeticException("Result will have a potential round off error: " + val2 + " / " + val1 + " = " + result);
		}
		
	}
	
	/*
	 * Method that compares two floats, finds the smallest one and then extracts how many decimal values it has
	 */
	private static int getDecimalAmount(float v1, float v2){
		float min = Float.min(v1, v2);
		String text = Float.toString(Math.abs(min));
		int integerPlaces = text.indexOf('.');
		return -(text.length() - integerPlaces - 1);
	}
	
	private static boolean isNaN(float val){
		return Float.isNaN(val) || Float.isInfinite(val);
	}
	
	/*
	 * Method to check whether a catastrophic cancellation would occur.
	 * Strategy found  on page 2 of :
	 * https://pdfs.semanticscholar.org/484a/c19ab1b94d59ab72fe75b864aabdcf141cba.pdf
	 */
	private static boolean checkCancellation (float f1, float f2, float res, String operator){	    
	    int bits1 = Float.floatToIntBits(f1);
	    int exponent1 = ((bits1 & 0x7f800000) >> 22) -127;
	    
	    int bits2 = Float.floatToIntBits(f2);
	    int exponent2 = ((bits2 & 0x7f800000) >> 22) -127;
	    
	    int bitsRes = Float.floatToIntBits(res);
	    int exponentRes = ((bitsRes & 0x7f800000) >> 22) -127;
//	    System.out.printf("V1: %.6f, V2: %.6f, Res: %.6f\n", f1, f2, res);
	    System.out.printf("Bits1: %d , Bits2: %d, BitsRes: %d\n", exponent1, exponent2, exponentRes);
	       
	    if(Math.max(exponent1, exponent2) - exponentRes >= 3 || compareToBigDecimal(f1, f2, res, operator)){
	    	return true;
	    }else{
	    	return false;
	    }

	  }



	private static boolean compareToBigDecimal(float val1, float val2 , float result, String operator) {
		int decimal = getDecimalAmount(val1, val2);
		
		BigDecimal v1 = new BigDecimal(val1);
		BigDecimal v2 = new BigDecimal(val2);
		BigDecimal res = new BigDecimal(result);
		BigDecimal comp = new BigDecimal("1e" + (decimal + 2));
		
		if(operator == "+"){
			return (v1.add(v2).subtract(res).compareTo(comp) == 1);
		}else if(operator == "-"){
			return (v2.subtract(v1).subtract(res).compareTo(comp) == 1);
		}else if(operator == "*"){
			return (v1.multiply(v2).subtract(res).compareTo(comp) == 1);
		}else if(operator == "/"){
			return (v2.divide(v1).subtract(res).compareTo(comp) == 1);
		}else{
			return false;
		}
	}

}
