package com.algos.greedy;

import java.util.Arrays;
import java.util.Comparator;

//https://www.geeksforgeeks.org/fractional-knapsack-problem/
public class FractionalKnapSackProblem {
	
	public static void main(String[] args) {
		int[] profits = new int[] {60, 100, 120};
		int[] weights = new int[] {10, 20, 30};
		int capacity  = 50;
		solve(weights, profits, capacity);
	}
	
	public static void solve(int[] weights, int[] profits, int capacity) {
		int[][] fraction = new int[profits.length][2];
		for(int i=0; i<profits.length; i++) {
			fraction[i][0] = i;
			fraction[i][1] = profits[i]/weights[i];
		}
		
		Arrays.sort(fraction, (a, b) -> Integer.compare(b[1], a[1]));
		
		double totalValue= 0d;
		for(int i=0; i<weights.length; i++) {
			int index = fraction[i][0];
			if(capacity - weights[index] >= 0) {
				capacity -= weights[index];
				totalValue += profits[index];
			}
			else {
				 double farctionWeight = (double)capacity/(double)weights[index];
				 double farctionProfit = (double)capacity/(double)profits[index];
				 
				 double currWght = weights[index] * farctionWeight;
				 double currProfit = profits[index] * farctionProfit;
				 capacity -= currWght;
				 totalValue += currProfit;
			}
		}
		//Total max profit
		System.out.println(totalValue);
	}
}
