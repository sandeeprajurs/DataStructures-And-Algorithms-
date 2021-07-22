package com.algos.dp;

public class CountAllSubsequencesHavingProductLessThanK {
	//O(n) Time | O(1) Space
	//https://www.geeksforgeeks.org/count-subsequences-product-less-k/
	public static void main(String[] args) {
		System.out.println(productLestThanK(new int[] { 4, 8, 7, 2 }, 50));
	}

	public static int productLestThanK(int arr[], int k) {
		int start = 0;
		int end = 0;
		int product = 1;
		int count = 0;
		while (start < arr.length && end < arr.length) {
			product *= arr[end];
			if (start < end && product >= k) {
				product /= arr[start];
				start++;
			}
			if (product < k) {
				end++;
				count += (end - start) + 1;
			}
		}
		return count;
	}

}
