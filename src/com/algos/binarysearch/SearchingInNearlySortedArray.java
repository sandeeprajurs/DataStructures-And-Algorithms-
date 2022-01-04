package com.algos.binarysearch;

public class SearchingInNearlySortedArray {

	public static void main(String[] args) {
		int arr[] = new int[] {10,5,20,15,25,35,30,40};
		System.out.println(solve(arr, 50));
	}
	
	static int solve(int[] arr, int searchEle){
		int start = 0;
		int end = arr.length-1;
		int mid=0;
		while(start<=end) {
			mid= (start+end)/2;
			if( searchEle == arr[mid]) {
				return mid;
			}
			else if(mid-1 >= start && searchEle == arr[mid-1]) {
				return mid-1;
			}
			else if(mid+1 <= start && searchEle == arr[mid+1]) {
				return mid+1;
			}
			else if(searchEle < arr[mid]) {
				end=mid-2;
			}
			else if(searchEle > arr[mid]) {
				start=mid+2;
			}
		}
		return -1;
	}
}
