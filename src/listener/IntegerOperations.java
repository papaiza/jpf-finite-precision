package listener;

public class IntegerOperations {
	
	/*
	 * Handle Integer Addition Overflow and Underflow
	 */
	public static boolean handleIntAdd(int val1, int val2){
		
		int result = val1 + val2;
		
		if((val1 > 0 && val2 > 0 && result <= 0 ) || 
				(val1 < 0 && val2 < 0 && result >= 0 )){
			System.out.println("integer overflow: " + val1 + " + " + val2 + " = " + result);
			return false;
		}
		return true;
	}
	
	/*
	 * Handle Integer Subtraction Overflow and Underflow
	 */
	public static boolean handleIntSub(int val1, int val2){
		
		int result = val2 - val1;
		
		if((val2 >= 0 && val1 < 0 && result <= 0 ) || 
				(val2 < 0 && val1 > 0 && result >= 0 )){
			System.out.println("integer overflow: " + val2 + " - " + val1 + " = " + result);
			return false;
		}
		return true;
		
	}
	
	/*
	 * Handle Integer Multiplication Overflow and Underflow
	 */
	public static boolean handleIntMult(int val1, int val2){
		
		int result = val1 * val2;
		
		if((long) val1 * (long)val2 != result){
			System.out.println("integer overflow: " + val1 + " * " + val2 + " = " + result);
			return false;
		}
		return true;
		
	}
	
	/*
	 * Handle Integer Division Overflow
	 */
	public static boolean handleIntDiv(int val1, int val2){
		
		if(val1 == 0){
			System.out.println("division by 0!: " + val2 + " / " + val1);
			return false;
		}
		
		int result = val2 / val1;
		
		if(val2 == Integer.MIN_VALUE && val1 == -1){
			System.out.println("integer overflow: " + val2 + " / " + val1 + " = " + result);
			return false;
		}
		return true;
	}
	
}
