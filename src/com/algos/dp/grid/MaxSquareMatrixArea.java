package com.algos.dp.grid;

import java.util.Arrays;

public class MaxSquareMatrixArea {
	public static void main(String[] args) {
		int[][] grid = new int[4][5];
		grid[0]= new int[] {1,0,1,1,1};
		grid[1]= new int[] {1,0,1,1,1};
		grid[2]= new int[] {1,1,1,1,1};
		grid[3]= new int[] {1,0,0,1,1};
		int ans = solve(grid);
		System.out.println(ans);
	}
	
	public static int solve(int[][] grid) {
		int[][] t=new int[grid.length+1][grid[0].length+1];
		//by default there will be 0s initilized
		int largest = Integer.MIN_VALUE;
		for(int i=1; i<t.length; i++) {
			for(int j=1; j<t[0].length; j++) {
				if(grid[i-1][j-1] == 1) {
					t[i][j] = 1+Math.min(t[i-1][j-1], Math.min(t[i-1][j], t[i][j-1]));
					if(t[i][j] > largest)
						largest = t[i][j];
				}
			}
		}
		System.out.println(Arrays.deepToString(t));
		return largest;
	}
}
