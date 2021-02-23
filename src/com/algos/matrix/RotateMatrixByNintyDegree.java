package com.algos.matrix;

import java.util.Arrays;

public class RotateMatrixByNintyDegree {
	//https://practice.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1#
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[3][3];
		matrix[0] = new int[]{1, 2, 3};
		matrix[1] =  new int[]{4, 5, 6};
		matrix[2] =  new int[]{7, 8, 9};
		rotateby90(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}
	
	// O(NM) Time and O(1) Space
	public static void rotateby90(int matrix[][]) {
		
		for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        int i=0;
        int j=matrix[0].length-1;
        while(i<j){
            int[] temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
            i++;
            j--;
        }
	}

}
