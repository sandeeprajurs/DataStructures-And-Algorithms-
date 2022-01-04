package com.algos.dp.unboundKnapSack;

public class CoinChangeMinNumOfCoins {
	
	public static void main(String[] args) {
		int[] coins = new int[] {1,2,3};
		int sum = 5;
		int ans = getMinNumberOfCoins(coins, sum);
		System.out.println(ans);
	}
	
	public static int getMinNumberOfCoins(int[] coins, int sum) {
		int[][] t = new int[coins.length+1][sum+1];
		//Initilization
		for(int i=0; i<t.length; i++) {
			for(int j=0; j<t[0].length; j++) {
				if(j==0)
					t[i][j] = 0;
				if(i==0)
					t[i][j] = Integer.MAX_VALUE-1;
				if(i==1) {
					if(j%coins[0] ==0)
						t[i][j] = j/coins[0];
					else
						t[i][j] = Integer.MAX_VALUE-1;
				}
			}
		}
		
		//Here we use min to find min coin count and using t[i][j - coins[i-1]]+1 "+1" because we need to get number of coins so adding the coin with 1
		for(int i=1; i<t.length; i++) {
			for(int j=1; j<t[0].length; j++) {
				if(coins[i-1] <= j)
					t[i][j] = Math.min(t[i][j - coins[i-1]]+1, t[i-1][j]);
				else if(coins[i-1] > j)
					t[i][j] = t[i-1][j];
			}
		}
		return t[t.length-1][t[0].length-1];
	}
}
