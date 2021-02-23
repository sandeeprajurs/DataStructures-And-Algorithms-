package com.algos.arrays;

import java.util.Arrays;

public class AlternativePositiveAndNegativeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
		rearrangePositiveNegative(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void rightRotate(int start, int end, int[] nums) {
		int temp = nums[end];
		for(int i=end; i>start; i--) {
			nums[i] = nums[i-1];
		}
		nums[start] = temp;
	}
	
	//O(N) Time | O(1) Space
	public static void rearrangePositiveNegative(int[] arr) {
		int wrongIndex = -1;
		for (int i = 0; i < arr.length; i++) {
			if (wrongIndex != -1) {
				if (arr[wrongIndex] >= 0 && arr[i] < 0 || arr[wrongIndex] < 0 && arr[i] >= 0) {
					rightRotate(wrongIndex, i, arr);
					if(i - wrongIndex >=2)
						wrongIndex += 2;
					else
						wrongIndex = -1;
				}
			} else if (wrongIndex == -1) {
				if (arr[i] >= 0 && i % 2 == 0 || arr[i] < 0 && i % 2 == 1) {
					wrongIndex = i;
				}
			}

		}
	}

}
