package com.algos.arrays;

import java.util.Arrays;

public class ThreeWayPartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(threeWayPartitioning(new int[] { 76, 8, 75, 22, 59, 96, 30, 38, 36 }, 44, 62)));
	}

	public static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	//O(n) Time || O(1) Space
	public static int[] threeWayPartitioning(int[] arr, int a, int b) {
		int low = a;
		int high = b;
		int low_idx = 0;
		int mid_idx = 0;
		int high_idx = arr.length - 1;
		while (mid_idx < high_idx) {
			if (arr[mid_idx] < low) {
				swap(mid_idx, low_idx, arr);
				low_idx++;
				mid_idx++;
			} else if (arr[mid_idx] > high) {
				swap(mid_idx, high_idx, arr);
				high_idx--;
			} else
				mid_idx++;
		}
		return arr;
	}

}
