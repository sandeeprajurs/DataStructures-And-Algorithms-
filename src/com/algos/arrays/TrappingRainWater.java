package com.algos.arrays;

public class TrappingRainWater {
	
	//Trapping Rain Water
	public static void main(String[] args) {
		System.out.println(trapRainingWater(new int[] {7,4,0,9}));
	}
	
	//O(n) ST
	public static int trapRainingWater(int[] arr) {
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		int water = 0;
		left[0] = arr[0];
		for(int i=1; i<arr.length; i++) {
			left[i] = Math.max(left[i-1], arr[i]);
		}
		right[arr.length - 1] = arr[arr.length-1];
		for(int i=arr.length - 2; i>=0; i--) {
			right[i] = Math.max(arr[i], right[i+1]);
		}
		
		for(int i=0; i<arr.length; i++) {
			water += Math.min(left[i], right[i]) - arr[i];
		}
		return water;
	}
}
