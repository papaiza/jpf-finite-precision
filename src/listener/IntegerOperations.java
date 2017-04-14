package listener;

public class IntegerOperations {
	
	public static void handleIntAdd(int val1, int val2){
		
		int result = val1 + val2;
		
		if((val1 > 0 && val2 > 0 && result <= 0 ) || 
				(val1 < 0 && val2 < 0 && result >= 0 )){
			throw new ArithmeticException("integer overflow: " + val1 + "+" + val2 + "=" + result);
		}
		
	}
	
	public static void handleIntSub(int val1, int val2){
		
		int result = val2 - val1;
		
		if((val2 >= 0 && val1 < 0 && result <= 0 ) || 
				(val2 < 0 && val1 > 0 && result >= 0 )){
			throw new ArithmeticException("integer overflow: " + val2 + "-" + val1 + "=" + result);
		}
		
	}
	
	public static void handleIntMult(int val1, int val2){
		
		int result = val1 * val2;
		
		if((long) val1 * (long)val2 != result){
			throw new ArithmeticException("integer overflow: " + val1 + "*" + val2 + "=" + result);
		}
		
	}
	
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
