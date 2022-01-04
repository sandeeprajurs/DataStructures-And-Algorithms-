package com.algos.recursion;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(printFactorial(7));
	}
	
	//smaller input method
	static int printFactorial(int n){
		if(n==1)
			return 1;
		int factorial = printFactorial(n-1);
		return factorial*(n-1);
	}
}
