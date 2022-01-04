package com.algos.binarysearch;

public class AllocateMinNumOfPages {

	public static void main(String[] args) {
		int[] arr = new int[] {10, 20, 30, 40};
		System.out.println(solve(arr, 2));
	}
	
	static int solve(int[] arr, int k){
		int start= getMax(arr);
		int end=getSum(arr);
		int result = -1;
		while(start<=end) {
			int mid=(start+end)/2;
			
			if(isValid(arr, k, mid)) {
				result = mid;
				end = mid-1;
			}
			else
				start = mid+1;
		}
		return result;
	}
	
	static int getMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++)
			max = Math.max(max, arr[i]);
		return max;
	}
	
	static int getSum(int[] arr) {
		int sum = 0;
		for(int i=0; i<arr.length; i++)
			sum = sum+arr[i];
		return sum;
	}
	
	static boolean isValid(int[] arr, int k, int mid) {
		int pages=0;
		int students=1;
		for(int i=0; i<arr.length; i++) {
			pages += arr[i];
			if(pages>mid) {
				students++;
				pages=arr[i];
			}
			
			if(students > k) return false;
		}
		return true;
	}
}
