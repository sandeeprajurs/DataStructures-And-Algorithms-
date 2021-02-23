package com.algos.arrays;

import java.util.Arrays;

public class ChocolateDistributionProblem {
	
	//Chocolate Distribution Problem 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(distributeChocolates(new int[] {3, 4, 1, 9, 56, 7, 9, 12}, 5));
	}
	
	//O(n) Time | O(1) Space
	public static int distributeChocolates(int[] chocolates, int children){
	    Arrays.sort(chocolates);
	    int minDiff = Integer.MAX_VALUE;
	    for(int i=0; i<=chocolates.length-children; i++){
	        int min = chocolates[i];
	        int max = chocolates[i+children-1];
	        int currDiff = max - min;
	        if(minDiff > currDiff)
	            minDiff = currDiff;
	    }
	    return minDiff;
	}

}
