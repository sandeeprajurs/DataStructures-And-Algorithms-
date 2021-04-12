package com.algos.arrays;

public class MaximumProductSubarray {
	// Maximum Product Subarray
	// https://leetcode.com/problems/maximum-product-subarray/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxProductSubArray(new int[] { 6, -3, -10, 1, 0, 2 } ));
	}
	
	// O(n) Time | O(1) Space
	static long maxProductSubArray(int[] arr) {
		// Variables to store maximum and minimum
		// product till ith index.
		long minVal = arr[0];
		long maxVal = arr[0];

		long maxProduct = arr[0];

		for (int i = 1; i < arr.length; i++) {

			// When multiplied by -ve number,
			// maxVal becomes minVal
			// and minVal becomes maxVal.
			if (arr[i] < 0) {
				long temp = maxVal;
				maxVal = minVal;
				minVal = temp;
			}

			// maxVal and minVal stores the
			// product of subarray ending at arr[i].
			maxVal = Math.max(arr[i], maxVal * arr[i]);
			minVal = Math.min(arr[i], minVal * arr[i]);

			// Max Product of array.
			maxProduct = Math.max(maxProduct, maxVal);
		}

		// Return maximum product found in array.
		return maxProduct;
	}
	
	// O(n) Time | O(1) Space
//	public static int maxProductSubArray(int[] nums) {
//		int max = nums[0];
//		int max_end_i = nums[0];
//		int min_end_i = nums[0];
//		for(int i=1; i<nums.length; i++) {
//			int temp = max_end_i;
//			max_end_i = Math.max(nums[i], Math.max(max_end_i*nums[i], min_end_i*nums[i]));
//			min_end_i = Math.min(nums[i], Math.min(temp*nums[i], min_end_i*nums[i]));
//			max = Math.max(max_end_i, max);
//		}
//		return max;
//	}
}