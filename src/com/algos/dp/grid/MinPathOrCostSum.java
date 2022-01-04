package com.algos.dp.grid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinPathOrCostSum {
	static Map<String, Integer> t;
	public static void main(String[] args) {
		int[][] grid = new int[3][3];
		grid[0][0] = 1;
		grid[0][1] = 3;
		grid[0][2] = 1;
		grid[1][0] = 2;
		grid[1][1] = 3;
		grid[1][2] = 2;
		grid[2][0] = 4;
		grid[2][1] = 3;
		grid[2][2] = 1;
		t=new HashMap<String, Integer>();
		System.out.println(Arrays.deepToString(grid));
		int ans = solve(grid, 0, 0);
//		int ans = solve(grid);
//		System.out.println(Arrays.deepToString(grid));
		System.out.println(ans);
	}

//	public static int solve(int[][] grid, int i, int j) {
//		if (i < 0 || j < 0)
//			return Integer.MAX_VALUE;
//		else if (i == 0 && j == 0)
//			return grid[i][j];
//		
//		int m = solve(grid, i - 1, j);
//		int n = solve(grid, i, j - 1);
//		
//		return grid[i][j] + Math.min(m, n);
//	
//		
//	}
	
	//Memoization
	public static int solve(int[][] grid, int i, int j) {
		String key=i+"_"+j;
		if(t.containsKey(key)) return t.get(key);
		
		if (i > grid.length-1 || j > grid[0].length-1)
			return Integer.MAX_VALUE;
		else if (i == grid.length-1 && j == grid[0].length-1)
			return grid[i][j];
		
		int m = solve(grid, i + 1, j);
		int n = solve(grid, i, j + 1);
		t.put(key, grid[i][j] + Math.min(m, n));
		return grid[i][j] + Math.min(m, n);
		
	}
	
	public static int solve(int[][] grid) {
		int[][] t= grid;
		for(int n=0; n<t.length; n++) {
			for(int m=0; m<t[0].length; m++) {
				if(n==0 && m>0) t[n][m] += t[n][m-1];
				if(n>0 && m==0) t[n][m] += t[n-1][m];
			}
		}
		System.out.println(Arrays.deepToString(t));
		for(int i=1; i<grid.length; i++) {
			for(int j=1; j<grid[0].length; j++) {
				t[i][j] += Math.min(t[i-1][j], t[i][j-1]);
			}
		}
		System.out.println(Arrays.deepToString(t));
		return t[grid.length-1][grid[0].length-1];
	}
}
