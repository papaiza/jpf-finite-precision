package listener;

public class FloatOperations {
	
	public static void handleFloatAdd(float v1, float v2) {
		
		float val1 = v1 * (float)Math.pow(10, 16);
		float val2 = v2 * (float)Math.pow(10, 16);
		
		float valTotal = val1 + val2;
		if(valTotal >= Float.MAX_VALUE){
			System.out.println("Would result in rounding error. Too precise.");
		}
		
		System.out.println(val1);
		
		System.out.println("Random!");
	}
}
