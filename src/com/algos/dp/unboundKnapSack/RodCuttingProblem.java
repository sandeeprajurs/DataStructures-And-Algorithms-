package com.algos.dp.unboundKnapSack;

public class RodCuttingProblem {

	public static void main(String[] args) {
		int[] length=new int[] {1,2,3,4};
		int[] price=new int[] {5,6,8,8};
		int N=7;
		int maxProfit = getMaxProfit(length, price, N);
		System.out.println(maxProfit);
	}
	
	public static int getMaxProfit(int[] length, int[] price, int N) {
		int[][] t = new int[price.length+1][N+1];
		for(int i=0; i<t.length; i++) {
			for(int j=0; j<t[0].length; j++) {
				if(i==0 || j==0)
					t[i][j] = 0;
			}
		}
		
		for(int i=1; i<t.length; i++) {
			for(int j=1; j<t[0].length; j++) {		
				if(length[i-1] <= j)
					t[i][j] = Math.max(price[i-1] + t[i][j - length[i-1]], t[i-1][j]);
				else if(length[i-1] > j)
					t[i][j] = t[i-1][j];
			}
			
		}
		return t[t.length-1][t[0].length-1];
	}
}
