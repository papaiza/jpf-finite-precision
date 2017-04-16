package listener;


public class DoubleOperations {
	/*
	 * Handle Double Division Overflow
	 */
	public static void handleDoubleAdd(double val1, double val2) {
		
		double result = val1 + val2;
		
		if(isNaN(result)){
			throw new ArithmeticException("Result is not a number: " + val1 + "+" + val2 + "=" + result);
		}
		
		if(checkCancellation(val1, val2, result)){
			throw new ArithmeticException("Result will have a potential round off error: " + val1 + "+" + val2 + "=" + result);
		}
		
	}
	
	
	
	/*
	 * Handle Double Subtraction Overflow and Underflow
	 */
	public static void handleDoubleSub(double val1, double val2){
		
		double result = val1 - val2;
		
		if(isNaN(result)){
			throw new ArithmeticException("Result is not a number: " + val1 + "-" + val2 + "=" + result);
		}
		
		if(checkCancellation(val1, val2, result)){
			throw new ArithmeticException("Result will have a potential round off error: " + val1 + "-" + val2 + "=" + result);
		}
		
	}
	
	/*
	 * Handle Double Multiplication Overflow and Underflow
	 */
	public static void handleDoubleMult(double val1, double val2){
		
		double result = val1 * val2;
		
		if(isNaN(result)){
			throw new ArithmeticException("Result is not a number: " + val1 + "*" + val2 + "=" + result);
		}
		
		if(checkCancellation(val1, val2, result)){
			throw new ArithmeticException("Result will have a potential round off error: " + val1 + "*" + val2 + "=" + result);
		}
		
	}
	
	/*
	 * Handle Double Division Overflow
	 */
	public static void handleDoubleDiv(double val1, double val2){
		
		double result = val2 / val1;
		
		if(isNaN(result)){
			throw new ArithmeticException("Result is not a number: " + val2 + "/" + val1 + "=" + result);
		}
		
		if(checkCancellation(val1, val2, result)){
			throw new ArithmeticException("Result will have a potential round off error: " + val2 + "/" + val1 + "=" + result);
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
