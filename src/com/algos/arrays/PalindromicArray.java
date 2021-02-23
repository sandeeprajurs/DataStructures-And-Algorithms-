package com.algos.arrays;


public class PalindromicArray {
//	https://practice.geeksforgeeks.org/problems/palindromic-array-1587115620/1#
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(palindromicArray(new int[]{111,222,333,151}));
	}
	
	//O(n)Time | O(1) Space
	public static int palindromicArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			int reverse = 0;
			int num = arr[i];
			while(num > 0) {
				int rem = num % 10;
				reverse = reverse * 10 + rem;
				num = num/10;
			}
			if(reverse != arr[i]) {
				return 0;
			}
		}
		return 1;
	}
	

}
