package com.algos.dp.grid;

public class UniquePath2 {
	static int[][] t;
	public static void main(String[] args) {
		int[][] grid = new int[3][4];
		grid[1][2]=1;
		grid[1][0]=1;
		
		t=new int[grid.length][grid[0].length];

//		int ans = solve(grid,0,0);
		int ans = solve(grid);
		System.out.println(ans);
	}
	
	//Recursive
	public static int solve(int[][] grid, int i, int j) {
		if (i >= grid.length || j >= grid[0].length || grid[i][j] == 1)
			return 0;
		if (i == grid.length - 1 && j == grid[0].length - 1)
			return 1;

		int x = solve(grid, i, j + 1);
		int y = solve(grid, i + 1, j);

		return x + y;
	}
	
	//Dp(Top Down Approach)
	public static int solve(int[][] grid) {
		for(int n=0; n<t.length; n++) {
			for(int m=0; m<t[0].length; m++) {
				if(n==0 || m==0) t[n][m] = 1;
				if(grid[n][m] == 1) t[n][m] = 0;
				if(n>0 && m==0 && t[n-1][m] == 0 || m>0 && n==0 && t[n][m-1] == 0)  t[n][m] = 0;
			}
		}
		for(int i=1; i<grid.length; i++) {
			for(int j=1; j<grid[0].length; j++) {
				if(grid[i][j] == 1) continue;
				
				t[i][j] = t[i][j-1] + t[i-1][j]; 
			}
		}
		return t[grid.length-1][grid[0].length-1];
	}
}
