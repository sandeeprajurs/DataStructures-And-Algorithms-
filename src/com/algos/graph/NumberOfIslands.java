package com.algos.graph;

public class NumberOfIslands {
	
	public static void main(String[] args) {
		int[][] matrix = new int[4][5];
		matrix[0]=new int[] {1,1,0,0,0};
		matrix[1]=new int[] {1,1,0,0,0};
		matrix[2]=new int[] {0,0,1,0,0};
		matrix[3]=new int[] {0,0,0,1,1};
		
		System.out.println(solve(matrix));
	}
	
	public static int solve(int[][] matrix) {
		int islands = 0;
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(matrix[i][j] == 1) {
					islands += 1;
					dfs(matrix, i, j);
				}
			}
		}
		return islands;
	}
	
	public static void dfs(int[][] matrix, int i, int j) {
		//Bc
		if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length) return;
		if(matrix[i][j] == 0) return;
		
		matrix[i][j] = 0; //Induxtion
		
		//Hypothesis
		dfs(matrix, i+1, j);
		dfs(matrix, i-1, j);   
		dfs(matrix, i, j+1);
		dfs(matrix, i, j-1);
	}
}


