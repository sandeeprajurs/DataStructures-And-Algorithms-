package com.algos.arrays;

public class SmallestSubArrayWithSumGreaterThanGivenValue {

	//Smallest subarray with sum greater than x
	public static void main(String[] args) {
		System.out.println(getSmallestSubArrayForGivenX(new long[] {1, 4, 45, 6, 0, 19}, 51));
	}
	
	//O(n) Time || O(1) Space
	public static long getSmallestSubArrayForGivenX(long[] nums, long num) {
		long result = Integer.MAX_VALUE;
		int left = 0;
		long sum = 0;
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
			while(sum > num) {
				result = Math.min(result, i+1 - left);
				sum -= nums[left];
				left++;
			}
		}
		return result;
	}

}
