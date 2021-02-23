package com.algos.matrix;

public class RowWithMaxOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[4][4];
		matrix[0] = new int[] {0, 1, 1, 1};
		matrix[1] = new int[] {0, 0, 1, 1};
		matrix[2] = new int[] {1, 1, 1, 1};
		matrix[3] = new int[] {0, 0, 0, 0};
		System.out.println(rowWithMaxOnes(matrix));
	}
	
	//O(n+m) Time | O(1) Space
	public static int rowWithMaxOnes(int[][] matrix) {
		int row = 0;
		int column = matrix[0].length-1;
		int maxRowIndex = -1;
		while(row < matrix.length && column >= 0) {
			if(matrix[row][column] == 1) {
				maxRowIndex = row;
				column--;
			}
			else {
				row++;
			}
		}
		return maxRowIndex;
	}

}
