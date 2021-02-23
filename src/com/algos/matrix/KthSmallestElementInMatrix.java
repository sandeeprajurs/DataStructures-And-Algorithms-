package com.algos.matrix;

public class KthSmallestElementInMatrix {
	public static void main(String[] args) {
		int[][] matrix = new int[3][3];
		matrix[0] = new int[]{1,5,9};
		matrix[1] = new int[]{10, 11, 13};
		matrix[2] = new int[]{12, 13, 15};
		System.out.println(kthSmallest(matrix, 8));
	}
	
	//O(n log(n)) Time | O(1) Space
	public static int kthSmallest(int[][] matrix, int k) {
        int min = matrix[0][0];
        int max = matrix[matrix.length-1][matrix.length-1];
        //This is binary search so log n
        while(min < max){
            int mid = (min + max)/2;
            if(findCount(mid, matrix) < k){
                min = mid+1;
            }
            else{
                max = mid;
            }
        }
        return max;
    }
    
    public static int findCount(int mid, int[][] matrix){
    	//this runs n times
        int row = 0;
        int column = matrix.length - 1;
        int count = 0;
        while(row<matrix.length && column >=0){
            if(matrix[row][column] <= mid){
                count += column + 1;
                row++;
            }
            else{
                column--;
            }
        }
        return count;
    }
}
