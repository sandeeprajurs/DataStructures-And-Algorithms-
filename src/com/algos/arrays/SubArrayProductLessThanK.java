package com.algos.arrays;

public class SubArrayProductLessThanK {
	
	//https://leetcode.com/problems/subarray-product-less-than-k/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100));
	}
	
	//O(n) Time | O(1) Space
	public static int numSubarrayProductLessThanK(int[] nums, int k) {
		int result = 0;
		int product = 1;
		int left = 0;
		for(int i=0; i<nums.length; i++) {
			product *= nums[i];
			if(product >= k) {
				product /= nums[left];
				left++;
			}
			result += i - left +1;
		}
		return result;
	}

}
