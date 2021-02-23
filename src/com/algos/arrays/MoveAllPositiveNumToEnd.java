package com.algos.arrays;

import java.util.Arrays;

public class MoveAllPositiveNumToEnd {
	//Move all the positive nums to end and negative numbs to beginning
	//O(n) Time | O(1) Space
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(movePositiveAtEnd(new int[] {-12, 11, -13, -5, 6, -7, 5, -3, -6})));
	}
	
	//Without retaining order
	public static int[] movePositiveAtEnd(int[] arr) {
		int i = 0;
		int j = arr.length - 1;
		while (i <= j) {
			while (i <= j && arr[i] < 0)
				i++;
			swap(i, j, arr);
			j--;
		}
		return arr;
	}
	
	public static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
