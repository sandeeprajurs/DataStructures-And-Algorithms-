package com.algos.arrays;

import java.math.BigInteger;

public class FactorialsOfLargeNumber {
	
	//Factorials of large numbers 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(1000));
	}
	
	//O(n) Time | O(1) Space
	public static BigInteger factorial(int num){
	    BigInteger res = BigInteger.valueOf(1);
	    for(int i=num; i>0; i--){
	        res = res.multiply(BigInteger.valueOf(i));
	    }
	    return res;
	}

}
