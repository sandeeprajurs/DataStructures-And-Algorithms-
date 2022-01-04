package com.algos.stack.queue;

public class AV_TappingRainWaterProblem {
	public static void main(String[] args) {
		int ans = solve(new int[] {3,0,0,2,0,4});
		System.out.println(ans);
	}
	
	public static int solve(int[] arr) {
		int[] maxRight = new int[arr.length];
		int[] maxLeft = new int[arr.length];
		
		maxLeft[0] = arr[0];
		for(int i=1; i<maxLeft.length; i++) {
			maxLeft[i] = Math.max(maxLeft[i-1], arr[i]);
		}
		
		maxRight[arr.length-1] = arr[arr.length-1];
		for(int i=arr.length-2; i>=0; i--) {
			maxRight[i] = Math.max(maxRight[i+1], arr[i]);
		}
		
		int[] water = new int[arr.length];
		int sum=0;
		for(int i=0; i<arr.length; i++) {
			water[i] = Math.min(maxLeft[i], maxRight[i]) - arr[i];
			sum += water[i];
		}
		return sum;
	}
}
