package com.algos.binarysearch;

import java.util.Arrays;

public class FIndPositionOFElemntInInfiniteSortedArr {

	public static void main(String[] args) {
		int[] arr = new int[1000];
		for (int i = 0; i < 100; i++) {
			arr[i] = i;
		}
		int[] range = getRange(arr, 48);
		System.out.println(Arrays.toString(range));
		System.out.println(binarySearch(arr, 48, range[0], range[1]));
	}

	static int[] getRange(int[] arr, int searchEle) {
		int start = 0;
		int end = 1;
		while (arr[end] <= searchEle) {
			start = end;
			end = end * 2;
		}
		return new int[] { start, end };
	}

	static int binarySearch(int[] arr, int searchEle, int startIdx, int endIdx) {
		int start = startIdx;
		int end = endIdx;
		int middle = 0;
		while (start <= end) {
			middle = (start + end) / 2;

			if (searchEle == arr[middle])
				return middle;

			else if (searchEle < arr[middle])
				end = middle - 1;
			else
				start = middle + 1;
		}
		return -1;
	}
}
