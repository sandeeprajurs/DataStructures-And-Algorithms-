package com.algos.matrix;

//Search a 2D Matrix
public class SearchIn2DMatrix {
	//O(w*h) Time || O(1) Space
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	 public boolean searchMatrix(int[][] matrix, int target) {
	        int i =0;
	        int j =matrix[0].length-1;
	        while(i>=0 && i<matrix.length && j>=0 && j<matrix[0].length){
	            if(matrix[i][j] > target){
	                j--;
	            }
	            else if(matrix[i][j] < target){
	                i++;
	            }
	            else{
	                return true;
	            }
	        }
	        return false;
	    }
}
