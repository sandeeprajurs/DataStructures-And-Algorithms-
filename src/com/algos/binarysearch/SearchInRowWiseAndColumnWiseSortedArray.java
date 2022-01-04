package com.algos.binarysearch;

import java.util.Arrays;

public class SearchInRowWiseAndColumnWiseSortedArray {

	public static void main(String[] args) {
		int[][] arr = new int[4][4];
		arr[0] = new int[] {10,20,30,40};
		arr[1] = new int[] {15,25,35,45};
		arr[2] = new int[] {27,29,37,48};
		arr[3] = new int[] {32,33,39,50};
		int[] ans=solve(arr, 29);
		System.out.println(Arrays.toString(ans));
	}

	static int[] solve(int[][] arr, int key) {
		int i = 0;
		int j = arr[0].length - 1;
		while (i >= 0 && i <= arr.length - 1 && j >= 0 && j <= arr[0].length - 1) {
			if(arr[i][j] == key)
				return new int[]{i, j};
			else if(arr[i][j] > key)
				j--;
			else if(arr[i][j] < key)
				i++;
		}
		return new int[]{-1, -1};
	}
}
