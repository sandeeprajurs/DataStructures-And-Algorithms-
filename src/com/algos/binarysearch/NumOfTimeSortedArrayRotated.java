package com.algos.binarysearch;

public class NumOfTimeSortedArrayRotated {
	
	public static void main(String[] args) {
		int arr[] = new int[] {15,17,18,2,5,6,8,11,12};
		System.out.println(solve(arr));
	}
	
	static int solve(int[] arr) {
		int mid=0;
		int start=0;
		int end = arr.length-1;
		
		int N = arr.length;
		while(start <= end) {
			mid = (start+end)/2;
			
			int next = (mid+1) % N;
			int prev = (mid+N -1) % N;
			
			if(arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
				return mid;
			}
			
			else if(arr[start] <= arr[mid]) {
				start=mid+1;
			}
			else if(arr[mid] <= arr[end]) {
				end = mid-1;
			}
		}
		return -1;
	}
	
	
}
