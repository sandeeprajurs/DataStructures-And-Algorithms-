package com.algos.binarysearch;

public class BinarySearch {
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
	    System.out.println(solve(arr, 5));
	}
	
//	static int solve(int[] arr, int searchEle){
//		int start=0;
//		int end = arr.length-1;
//		int middle = 0;
//		while(start <= end) {
//			middle = (start + end - start)/2;
//			
//			if(searchEle == arr[middle])
//				return middle;
//			
//			else if(searchEle < arr[middle])
//				end = middle-1;
//			else
//				start= middle+1;
//		}
//		return -1;
//	}
	
	//when order not known
	static int solve(int[] arr, int searchEle){
		int start=0;
		int end = arr.length-1;
		int middle = 0;
		if(arr.length == 1) return 0;
		
		boolean asc = true;
		if(arr[0] < arr[1]) asc = true;
		else if(arr[0] > arr[1]) asc = false;
		
		while(start <= end) {
			middle = (start + end - start)/2;
			
			if(searchEle == arr[middle])
				return middle;
			
			else if(asc && searchEle < arr[middle])
				start = middle+1;
			else if(asc && searchEle > arr[middle])
				end = middle-1;
			
			else if(searchEle < arr[middle])
				end = middle-1;
			else if(searchEle > arr[middle])
				start= middle+1;
		}
		return -1;
	}
}
