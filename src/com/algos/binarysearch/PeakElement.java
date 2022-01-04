package com.algos.binarysearch;

public class PeakElement {
	
	public static void main(String[] args) {
		int[] arr=new int[] {5,10,20,15};
		System.out.println(solve(arr));
	}
	
	public static int solve(int[] arr) {
		int start=0;
		int end = arr.length-1;
		while(start <= end) {
			int mid = (start+end)/2;
			
			if(mid >0 && mid<arr.length-1) {
				if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
					return mid;
				if(arr[mid-1] > arr[mid+1])
					end = mid-1;
				else
					start = mid+1;
			}
			else if(mid ==0) {
				if(arr[mid] > arr[mid+1])
					return mid;
				else
					return mid+1;
			}
			else if(mid == arr.length-1) {
				if(arr[mid] > arr[mid-1])
					return mid;
				else
					return mid-1;
			}
		}
		return -1;
	}
}
