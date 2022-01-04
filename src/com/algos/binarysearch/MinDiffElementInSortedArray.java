package com.algos.binarysearch;

public class MinDiffElementInSortedArray {

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
	    System.out.println(binarySearch(arr, 12));
	}


	public static int binarySearch(int[] arr, int key) {
		int start=0;
		int end = arr.length-1;
		int middle = 0;
		while(start <= end) {
			middle = (start + end)/2;
			
			if(key == arr[middle])
				return key - arr[middle];
			
			else if(key < arr[middle])
				end = middle-1;
			else
				start= middle+1;
		}
		
		int temp1 = key - (end%arr.length);
		int temp2 = key - (start%arr.length);
		if(temp1 < temp2) return arr[end];
		if(temp2 < temp1) return arr[start];
		return arr[end];
	}
}
