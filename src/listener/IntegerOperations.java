package listener;

public class IntegerOperations {
	
	/*
	 * Handle Integer Addition Overflow and Underflow
	 */
	public static void handleIntAdd(int val1, int val2){
		
		int result = val1 + val2;
		
		if((val1 > 0 && val2 > 0 && result <= 0 ) || 
				(val1 < 0 && val2 < 0 && result >= 0 )){
			throw new ArithmeticException("integer overflow: " + val1 + "+" + val2 + "=" + result);
		}
		
	}
	
	/*
	 * Handle Integer Subtraction Overflow and Underflow
	 */
	public static void handleIntSub(int val1, int val2){
		
		int result = val2 - val1;
		
		if((val2 >= 0 && val1 < 0 && result <= 0 ) || 
				(val2 < 0 && val1 > 0 && result >= 0 )){
			throw new ArithmeticException("integer overflow: " + val2 + "-" + val1 + "=" + result);
		}
		
	}
	
	/*
	 * Handle Integer Multiplication Overflow and Underflow
	 */
	public static void handleIntMult(int val1, int val2){
		
		int result = val1 * val2;
		
		if((long) val1 * (long)val2 != result){
			throw new ArithmeticException("integer overflow: " + val1 + "*" + val2 + "=" + result);
		}
		
	}
	
	/*
	 * Handle Integer Division Overflow
	 */
	public static void handleIntDiv(int val1, int val2){
		
		if(val1 == 0){
			throw new ArithmeticException("division by 0!");
		}
		
		int result = val2 / val1;
		
		if(val2 == Integer.MIN_VALUE && val1 == -1){
			throw new ArithmeticException("integer overflow: " + val2 + "/" + val1 + "=" + result);
		}
		
	}
	
}
