package main;

public class LongMain {
	public static void main(String[] args) {
		long a = 1L;
		long b = 2L;
		long c = a + b;
		long mult = a *b;
//		long div = b / a;
		long sub = b - a;
		
		long d = Long.MAX_VALUE;
		long e = Long.MIN_VALUE;
		long g = -2L;
		long h = -5L;
		long i = -1L;
		
		long overSum = d + b;
		long underSum = e + g;
		long overSub = d - h;
		long underSub = e - a;
		long overMult = d * b;
		long underMult = e * b;
		long overDiv = d / i;
		long underDiv = e/ i;
		
	}
}
