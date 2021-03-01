package com.algos.strings;

public class MinNumberOfFlipsOs1s {
	//https://practice.geeksforgeeks.org/problems/min-number-of-flips/0#
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getFlipCount(new int[] {0,0,1}));
		System.out.println(getFlipCount(new int[] {0,0,0,1,1,1,0,1}));
	}
	
	//O(n) Time | O(1) Space
	public static int getFlipCount(int[] arr) {
		int count1=0;
		int count2=0;
		for(int i=0; i<arr.length; i++) {
			if(i%2 == 0 && arr[i] == 1) count1++;
			if(i%2 != 0 && arr[i] == 0) count1++;
			
			if(i%2 == 0 && arr[i] == 0) count2++;
			if(i%2 != 0 && arr[i] == 1) count2++;
		}
		
		return Math.min(count1, count2);
	}

}
