package listener;

import java.math.BigDecimal;

public class LongOperations {
	/*
	 * Handle Long Addition Overflow and Underflow
	 */
	public static void handleLongAdd(long val1, long val2){
		
		long result = val1 + val2;
		
		if((val1 > 0 && val2 > 0 && result <= 0 ) || 
				(val1 < 0 && val2 < 0 && result >= 0 )){
			throw new ArithmeticException("long overflow: " + val1 + "+" + val2 + "=" + result);
		}
		
	}
	
	/*
	 * Handle Long Subtraction Overflow and Underflow
	 */
	public static void handleLongSub(long val1, long val2){
		
		long result = val2 - val1;
		
		if((val2 >= 0 && val1 < 0 && result <= 0 ) || 
				(val2 < 0 && val1 > 0 && result >= 0 )){
			throw new ArithmeticException("long overflow: " + val2 + "-" + val1 + "=" + result);
		}
		
	}
	
	/*
	 * Handle Long Multiplication Overflow and Underflow
	 */
	public static void handleLongMult(long val1, long val2){
		
		long result = val1 * val2;
		BigDecimal v1 = new BigDecimal(val1);
		BigDecimal v2 = new BigDecimal(val2);
		if(! v1.multiply(v2).equals(new BigDecimal(result))){
			throw new ArithmeticException("long overflow: " + val1 + "*" + val2 + "=" + result);
		}
		
	}
	
	/*
	 * Handle Long Division Overflow
	 */
	public static void handleLongDiv(long val1, long val2){
		
		if(val1 == 0){
			throw new ArithmeticException("division by 0!");
		}
		
		long result = val2 / val1;
		
		if(val2 == Long.MIN_VALUE && val1 == -1){
			throw new ArithmeticException("long overflow: " + val2 + "/" + val1 + "=" + result);
		}
		
	}
}
