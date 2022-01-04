package com.algos.binarysearch;

public class FindEleInRotatedSortedArray {

	public static void main(String[] args) {
		int arr[] = new int[] { 15, 17, 18, 2, 5, 6, 8, 11, 12 };
		int idx = getSortedArrCount(arr);
		int temp1 = binarySearch(arr, 0, idx - 1, 6);
		int temp2 = binarySearch(arr, idx, arr.length - 1, 6);

		if (temp1 != -1) {
			System.out.println(temp1);
			return;
		} else if (temp2 != -1) {
			System.out.println(temp2);
			return;
		} else {
			System.out.println("no ans found");
		}

	}

	static int getSortedArrCount(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		int N = arr.length - 1;
		while (start <= end) {
			int prev = (mid + N - 1) % N;
			int next = (mid + 1) % N;
			mid = (start + end) / 2;
			if (arr[mid] <= arr[prev] & arr[mid] <= arr[next]) {
				return mid;
			} else if (arr[start] <= arr[mid]) {
				start = mid + 1;
			} else if (arr[mid] <= arr[end]) {
				end = mid - 1;
			}
		}
		return -1;
	}

	static int binarySearch(int[] arr, int startIdx, int endIdx, int searchEle) {
		int start = startIdx;
		int end = endIdx;
		int mid = 0;
		int N = arr.length - 1;
		while (start <= end) {
			mid = (start + end) / 2;
			if (arr[mid] == searchEle) {
				return mid;
			} else if (searchEle < arr[mid]) {
				end = mid - 1;
			} else if (searchEle > arr[mid]) {
				start = mid + 1;
			}
		}
		return -1;
	}
}
