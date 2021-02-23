package com.algos.arrays;

import java.util.Arrays;

public class RotateAnArrayByN {

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4, 5,6};
		rotateByN(arr, 1);
		System.out.println(Arrays.toString(arr));
	}
	
	//O(n) Time || O(1) Space
	public static void rotateByN(int[] nums, int n) {
		n = n% nums.length;
		reverse(0, nums.length-1, nums);
		reverse(0, n-1, nums);
		reverse(n, nums.length-1, nums);
	}
	
	public static void reverse(int start, int end, int[] nums) {
		while(start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

}
