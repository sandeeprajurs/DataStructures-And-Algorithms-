package com.algos.arrays;

public class BuyAndSellStocks {
	
	//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxProfit(new int[] {10, 22, 5, 75, 65, 80}));
	}
	
	//O(n) Time | O(1) Space
//	public static int maxProfit(int[] prices) {
//		int minPrice = Integer.MAX_VALUE;
//		int maxProfit = 0;
//		for (int i = 0; i < prices.length; i++) {
//			minPrice = Math.min(minPrice, prices[i]);
//			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
//		}
//		return maxProfit;
//	}
	
	public static int maxProfit(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		int overAllProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			if(prices[i] < maxProfit) {
				minPrice = prices[i];
				maxProfit = 0;
			}
			else
				minPrice = Math.min(minPrice, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - minPrice); 
		}
		return overAllProfit;
	}
}
