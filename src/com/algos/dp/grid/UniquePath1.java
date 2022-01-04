package com.algos.dp.grid;

import java.util.Arrays;

public class UniquePath1 {
	
	static int[][] t;
	public static void main(String[] args) {
		int[][] grid = new int[3][4];
		t=new int[grid.length][grid[0].length];
//		for(int i=0; i<t.length; i++) {
//			for(int j=0; j<t[0].length; j++) {
//				t[i][j]=-1;
//			}
//		}
		int ans = solve(grid);
		System.out.println(ans);
	}
	
	//Recursion
//	public static int solve(int[][] grid, int i, int j) {
//		if(i>= grid.length || j>= grid[0].length) return 0;
//		if(i==grid.length-1 && j== grid[0].length-1) return 1;
//		
//		int x = solve(grid, i, j+1);
//		int y = solve(grid, i+1, j);
//		
//		return x+y;
//	}
	
	//Memoization
//	public static int solve(int[][] grid, int i, int j) {
//		if(i>= grid.length || j>= grid[0].length) return 0;
//		if(i==grid.length-1 && j== grid[0].length-1) return 1;
//		
//		if(t[i][j] != -1) return t[i][j];
//		
//		int x = solve(grid, i, j+1);
//		int y = solve(grid, i+1, j);
//		t[i][j] = x+y;
//		return t[i][j];
//	}
	
	//DP(Top Down approach)
	public static int solve(int[][] grid) {
		for(int n=0; n<t.length; n++) {
			for(int m=0; m<t[0].length; m++) {
				if(n==0 || m==0) t[n][m] = 1;
			}
		}
		
		for(int i=1; i<grid.length; i++) {
			for(int j=1; j<grid[0].length; j++) {
				t[i][j] = t[i][j-1] + t[i-1][j]; 
			}
		}
		System.out.println(Arrays.deepToString(t));
		return t[grid.length-1][grid[0].length-1];
	}
	
	
}
