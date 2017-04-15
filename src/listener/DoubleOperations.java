package listener;

import java.math.BigDecimal;

public class DoubleOperations {
	/*
	 * Handle Double Division Overflow
	 */
	public static void handleDoubleAdd(double v1, double v2) {
		
		double result = v1 + v2;
		
		if(isNaN(result)){
			throw new ArithmeticException("Result is not a number: " + v1 + "+" + v2 + "=" + result);
		}
		
		BigDecimal val1 = new BigDecimal(Double.toString(v1));
		BigDecimal val2 = new BigDecimal(Double.toString(v2));
		BigDecimal res = new BigDecimal(result);
		
		System.out.println("Result is " + res);
		
//		if(!val1.add(val2).equals(res)){
//			throw new ArithmeticException("Result will have a potential round off error: " + v1 + "+" + v2 + "=" + result);
//		}
		if(checkCancellation(v1, v2, result)){
			throw new ArithmeticException("Result will have a potential round off error: " + v1 + "+" + v2 + "=" + result);
		}
		
	}
	
	
	
	/*
	 * Handle Double Subtraction Overflow and Underflow
	 */
	public static void handleDoubleSub(double val1, double val2){
		
		double result = val2 - val1;
		
		if((val2 >= 0 && val1 < 0 && result <= 0 ) || 
				(val2 < 0 && val1 > 0 && result >= 0 )){
			throw new ArithmeticException("double overflow: " + val2 + "-" + val1 + "=" + result);
		}
		
	}
	
	/*
	 * Handle Double Multiplication Overflow and Underflow
	 */
	public static void handleDoubleMult(double val1, double val2){
		
		double result = val1 * val2;
		BigDecimal v1 = new BigDecimal(val1);
		BigDecimal v2 = new BigDecimal(val2);
		if(! v1.multiply(v2).equals(new BigDecimal(result))){
			throw new ArithmeticException("double overflow: " + val1 + "*" + val2 + "=" + result);
		}
		
	}
	
	/*
	 * Handle Double Division Overflow
	 */
	public static void handleDoubleDiv(double val1, double val2){
		
		if(val1 == 0){
			throw new ArithmeticException("division by 0!");
		}
		
		double result = val2 / val1;
		
		if(val2 == Double.MIN_VALUE && val1 == -1){
			throw new ArithmeticException("double overflow: " + val2 + "/" + val1 + "=" + result);
		}
		
	}
	
	private static boolean isNaN(double val){
		return Double.isNaN(val) || Double.isInfinite(val);
	}
	
	/*
	 * Method to check whether a catastrophic cancellation would occur.
	 * Strategy found  on page 2 of :
	 * https://pdfs.semanticscholar.org/484a/c19ab1b94d59ab72fe75b864aabdcf141cba.pdf
	 */
	private static boolean checkCancellation (double f1, double f2, double result){	    
	    long bits1 = Double.doubleToLongBits(f1);
	    long exponent1 = ((bits1 & 0x7ff0000000000000L) >> 52) - 1023;
	    double exponentDouble1 = Double.longBitsToDouble(exponent1);
	    
	    long bits2 = Double.doubleToLongBits(f2);
	    long exponent2 = ((bits2 & 0x7ff0000000000000L) >> 52) - 1023;
	    double exponentDouble2 = Double.longBitsToDouble(exponent2);
	    
	    long bitsRes = Double.doubleToLongBits(result);
	    
	    long exponentRes = ((bitsRes & 0x7ff0000000000000L) >> 52) - 1023;
	    double exponentDoubleRes = Double.longBitsToDouble(exponentRes);
	    
	    if(Math.max(exponentDouble1, exponentDouble2) - exponentDoubleRes >= 10){
	    	return true;
	    }else{
	    	return false;
	    }
	  }

}
