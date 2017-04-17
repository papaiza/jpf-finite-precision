package listener;

import java.math.BigDecimal;

public class DoubleOperations {
	/*
	 * Handle Double Addition Rounding Errors
	 */
	public static boolean handleDoubleAdd(double val1, double val2) {
		
		double result = val1 + val2;
		
		if(isNaN(result)){
			System.out.println("WARNING: Result is not a number: " + val1 + " + " + val2 + " = " + result);
			return false;
		}
		
		if(checkCancellation(val1, val2, result, "+")){
			System.out.println("WARNING: Result will have a potential round off error: " + val1 + " + " + val2 + " = " + result);
			return false;
		}
		return true;
		
	}
	
	/*
	 * Handle Double Subtraction Rounding Errors
	 */
	public static boolean handleDoubleSub(double val1, double val2){
		
		double result = val2 - val1;
		
		if(isNaN(result)){
			System.out.println("WARNING: Result is not a number: " + val2 + " - " + val1 + " = " + result);
			return false;
		}
		
		if(checkCancellation(val1, val2, result, "-")){
			System.out.println("WARNING: Result will have a potential round off error: " + val2 + " - " + val1 + " = " + result);
			return false;
		}
		return true;
	}
	
	/*
	 * Handle Double Multiplication Rounding Errors
	 */
	public static boolean handleDoubleMult(double val1, double val2){
		
		double result = val1 * val2;
		
		if(isNaN(result)){
			System.out.println("WARNING: Result is not a number: " + val1 + " * " + val2 + " = " + result);
			return false;
		}
		
		if(checkCancellation(val1, val2, result, "*")){
			System.out.println("WARNING: Result will have a potential round off error: " + val1 + " * " + val2 + " = " + result);
			return false;
		}
		return true;
	}
	
	/*
	 * Handle Double Division Rounding Errors
	 */
	public static boolean handleDoubleDiv(double val1, double val2){
		
		double result = val2 / val1;
		
		if(isNaN(result)){
			System.out.println("WARNING: Result is not a number: " + val2 + " / " + val1 + " = " + result);
			return false;
		}
		
		if(checkCancellation(val1, val2, result, "/")){
			System.out.println("WARNING: Result will have a potential round off error: " + val2 + " / " + val1 + " = " + result);
			return false;
		}
		return true;
	}
	
	/*
	 * Method that compares two doubles, finds the smallest one and then extracts how many decimal values it has
	 */
	private static int getDecimalAmount(double v1, double v2){
		double min = Double.min(v1, v2);
		String text = Double.toString(Math.abs(min));
		int integerPlaces = text.indexOf('.');
		return -(text.length() - integerPlaces - 1);
	}
	
	/*
	 * Method to compare the difference between double operations and big decimal operations
	 */
	private static boolean compareToBigDecimal(double val1, double val2 , double result, String operator) {
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
			try{
				return (v2.divide(v1).subtract(res).compareTo(comp) == 1);
			}catch(ArithmeticException e){
				return true;
			}
		}else{
			return false;
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
	private static boolean checkCancellation (double f1, double f2, double result, String operator){	    
	    long bits1 = Double.doubleToLongBits(f1);
	    long exponent1 = ((bits1 & 0x7ff0000000000000L) >> 52) - 1023;
	    
	    long bits2 = Double.doubleToLongBits(f2);
	    long exponent2 = ((bits2 & 0x7ff0000000000000L) >> 52) - 1023;
	    
	    long bitsRes = Double.doubleToLongBits(result);
	    long exponentRes = ((bitsRes & 0x7ff0000000000000L) >> 52) - 1023;
	    
	    if(Math.max(exponent1, exponent2) - exponentRes >= 3 || compareToBigDecimal(f1, f2, result, operator)){
	    	return true;
	    }else{
	    	return false;
	    }
	  }

}
