package com.algos.arrays;

import java.util.Arrays;
//Sort an array of 0s, 1s and 2s without using any sorting algorithms.
public class SortArraysTypeOne {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortArray(new int[] {0, 1, 2, 0, 1, 2})));
	}
	
	//O(n) Time | O(1) Space
	public static int[] sortArray(int[] arr) {
		int l = 0;
		int m = 0;
		int h = arr.length - 1;
		while (m <= h) {
			if (arr[m] == 0) {
				swap(m, l, arr);
				m++;
				l++;
			} else if (arr[m] == 1) {
				m++;
			} else if (arr[m] == 2) {
				swap(m, h, arr);
				h--;
			}
		}
		return arr;
	}
	
	public static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
