package com.algos.binarysearch;

public class FindFloorOfElementInSortedArray {

	//ceil and floor refer same problem
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,6,7,8,9};
		System.out.println(solve(arr, 5));
	}
	
	static int solve(int[] arr, int searchEle){
		int start=0;
		int end = arr.length-1;
		int middle = 0;
		int candidate=-1;
		while(start <= end) {
			middle = (start + end)/2;
			if(searchEle == arr[middle])
				return middle;
			else if(searchEle > arr[middle]) {
				//floor
				candidate = arr[middle];
				start= middle+1;
			}
			else if(searchEle < arr[middle]) {
				//ceil
//				candidate = arr[middle];
				end = middle-1;
			}
		}
		return candidate;
	}
}
