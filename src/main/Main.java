package main;
import static java.lang.Math.*;

public class Main {

	public static void main(String[] args) {
		float f = 0.34f;
		float g = 0.55f;
		
		float x = f + g;
		System.out.println(x);
		
		
		float aa = 0.890123f;
		float bb = 0.543212f;
		
		float y = aa + bb;
		System.out.println(y);
		
		double a = 77617.0;
	    double b = 33096.0;
	    double res = 333.75*pow(b,6) + pow(a,2)*(11*pow(a,2)*pow(b,2) - pow(b,6) - 121*pow(b,4) - 2) + 5.5*pow(b,8) + a/(2*b);
	    System.out.println("res=" + res + " (should be -0.827396...)");

	}

}
