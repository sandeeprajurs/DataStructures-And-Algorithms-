package com.algos.dp.zeroOneKnapSack;

import java.util.Arrays;

public class ZeroOneKnapSackProblem {
	
	static int[][] t = null;
	public static void main(String[] args) {
		int[] weights = new int[] { 5, 3, 1, 4};
		int[] values = new int[] { 1, 2, 4, 6};
		int w = 7;
//		int ans = knapSackSimpleRecursion(weights, values, w, weights.length);
//		System.out.println(ans);
		
		//Memozitation
//		t = new int[weights.length+1][w+1];
//		for(int i=0; i<t.length; i++) {
//			for(int j=0; j<t[0].length; j++) {
//				t[i][j] = -1;
//			}
//		}
//		int ans1 = knapSack(weights, values, w, weights.length);
//		System.out.println(ans1);
		
		//Top down
		int ans1 = knapSack(weights, values, w, weights.length);
		System.out.println(ans1);
	}
	
	//Recursive approach
	//T O(2^n)
//	static int knapSackSimpleRecursion(int[] weights, int[] values, int w, int n) {
//		if(n==0 || w==0) return 0;
//		
//		if(weights[n-1] <= w)
//			return Math.max(values[n-1]+knapSackSimpleRecursion(weights, values, w- weights[n-1], n-1), knapSackSimpleRecursion(weights, values, w, n-1));
//		else if(weights[n-1] > w)
//			return knapSackSimpleRecursion(weights, values, w, n-1);
//		return -1;
//	}
	
	
	//Using Memoization
//	static int knapSack(int[] weights, int[] values, int w, int n) {
//		if(n==0 || w==0) return 0;
//		
//		if(t[n][w] != -1)
//			return t[n][w];
//		
//		if(weights[n-1] <= w) {
//			t[n][w] = Math.max(values[n-1]+knapSack(weights, values, w- weights[n-1], n-1), knapSack(weights, values, w, n-1));
//			return t[n][w];
//		}
//		else if(weights[n-1] > w) {
//			t[n][w] = knapSack(weights, values, w, n-1);
//			return t[n][w];
//		}
//		return -1;
//	}
	
	
	//Using Top Down Approact
	static int knapSack(int[] weights, int[] values, int w, int n) {
		t = new int[n+1][w+1];
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=w; j++) {
				if (i == 0 || j == 0) // base case // filling 1st row and 1st column of the matrix with zero as per the base condition of the recursive solution 
					t[i][j] = 0;
				
				else if(weights[i-1] <= j) {
					t[i][j] = Math.max(values[i-1] + t[i-1][j - weights[i-1]], t[i-1][j]);
				}
				else if(weights[i-1] > j) {
					t[i][j] = t[i-1][j];
				}
			}
		}
		System.out.println(Arrays.deepToString(t));
		return t[n][w];	
	}
}
