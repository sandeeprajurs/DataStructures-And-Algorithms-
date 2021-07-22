package com.algos.graph;

public class NoOfIslands {
	//https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1#
	public static void main(String[] args) {
		char[][] grid = new char[4][2];
		grid[0] = new char[]{'0','1'};
		grid[1] = new char[]{'1','0'};
		grid[2] = new char[]{'1','1'};
		grid[3] = new char[]{'1','0'};
		System.out.println(numIslands(grid));
	}

	public static int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					grid[i][j] = '0';
					count += getCountOfIslands(grid, i, j);
				}
			}
		}
		return count;
	}

	public static int getCountOfIslands(char[][] grid, int i, int j) {
		if (isValid(i + 1, j, grid) && grid[i + 1][j] == '1') {
			grid[i+1][j] = '0';
			getCountOfIslands(grid, i + 1, j);
		}
		if (isValid(i - 1, j, grid) && grid[i - 1][j] == '1') {
			grid[i-1][j] = '0';
			getCountOfIslands(grid, i - 1, j);
		}
		if (isValid(i, j + 1, grid) && grid[i][j + 1] == '1') {
			grid[i][j+1] = '0';
			getCountOfIslands(grid, i, j + 1);
		}
		if (isValid(i, j - 1, grid) && grid[i][j - 1] == '1') {
			grid[i][j-1] = '0';
			getCountOfIslands(grid, i, j - 1);
		}
		
		if (isValid(i-1, j - 1, grid) && grid[i-1][j - 1] == '1') {
			grid[i-1][j-1] = '0';
			getCountOfIslands(grid, i-1, j - 1);
		}
		if (isValid(i+1, j-1, grid) && grid[i+1][j-1] == '1') {
			grid[i+1][j-1] = '0';
			getCountOfIslands(grid, i+1, j-1);
		}
		if (isValid(i-1, j+1, grid) && grid[i-1][j+1] == '1') {
			grid[i-1][j+1] = '0';
			getCountOfIslands(grid, i-1, j+1);
		}
		if (isValid(i+1, j+1, grid) && grid[i+1][j+1] == '1') {
			grid[i+1][j+1] = '0';
			getCountOfIslands(grid, i+1, j+1);
		}
		return 1;
	}

	public static boolean isValid(int i, int j, char[][] grid) {
		if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length -1)
			return false;
		return true;
	}

}
