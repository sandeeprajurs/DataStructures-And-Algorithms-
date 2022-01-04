package com.algos.dp.mcm;

public class MCM {

	static int[][] t = null;
	public static void main(String[] args) {
		int[] arr= new int[] {10,30,5,60};
		t = new int[arr.length+1][arr.length+1];
		//Initilizing matrix
		for(int i=0; i<t.length; i++) {
			for(int j=0; j<t[0].length; j++) {
				t[i][j] = -1;
			}
		}
		System.out.println(solveMCM(arr, 1, arr.length-1));
	}
	
	//Recursive Code
//	public static int solveMCM(int[] arr, int i, int j) {
//		if(i>=j) return 1;
//		int min = Integer.MAX_VALUE;
//		for(int k=i; k<=j-1; k++) {
//			int tempAns = solveMCM(arr, i, k) + solveMCM(arr, k+1, j) + (arr[i-1] * arr[k] * arr[j]);
//			if(tempAns < min)
//				min = tempAns;
//		}
//		return min;
//	}
	
	//Memoization
	public static int solveMCM(int[] arr, int i, int j) {
		if(i>=j) return 1;
		if(t[i][j] != -1) return t[i][j];
		int min = Integer.MAX_VALUE;
		for(int k=i; k<=j-1; k++) {
			int tempAns = solveMCM(arr, i, k) + solveMCM(arr, k+1, j) + (arr[i-1] * arr[k] * arr[j]);
			if(tempAns < min)
				min = tempAns;
		}
		t[i][j] = min;
		return t[i][j];
	}
}
