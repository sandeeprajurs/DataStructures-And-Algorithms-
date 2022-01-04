package com.algos.recursion;

public class Print1toNAndNto1 {

	public static void main(String[] args) {
		printNTo1(7);
	}
	
	//smaller input method
	public static void print1ToN(int n) {
		if(n==1) {
			System.out.println(n);
			return;
		}
		print1ToN(n-1);
		System.out.println(n);
	}
	
	public static void printNTo1(int n) {
		if(n==1) {
			System.out.println(n);
			return;
		}
		System.out.println(n);
		printNTo1(n-1);
	}
}


