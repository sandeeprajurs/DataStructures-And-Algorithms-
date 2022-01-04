package com.algos.dp.unboundKnapSack;

import java.util.Arrays;

public class CoinChangeMaxNumOfWays {
	
	public static void main(String[] args) {
		int[] coins = new int[] {1,2,3};
		int sum = 5;
		int ans = getMaxNumOfWays(coins, sum);
		System.out.println(ans);
	}
	
	public static int getMaxNumOfWays(int[] coins, int sum) {
		int[][] t = new int[coins.length+1][sum+1];
		for(int i=0; i<t.length; i++) {
			//Initilization
			for(int j=0; j<t[0].length; j++) {
				if(i==0)
					t[i][j] = 0;
				if(j==0)
					t[i][j] = 1;
			}
		}
		
		//t[i][j - coins[i-1]] + t[i-1][j] here + bcs we need to find max number of ways so adding 
		for(int i=1; i<t.length; i++) {
			for(int j=1; j<t[0].length; j++) {
				if(coins[i-1] <= j)
					t[i][j] = t[i][j - coins[i-1]] + t[i-1][j];
				else if(coins[i-1] > j)
					t[i][j] = t[i-1][j];
			}
		}
		System.out.println(Arrays.deepToString(t));
		return t[t.length-1][t[0].length-1];
	}
}
