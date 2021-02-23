package com.algos.matrix;

import java.util.HashSet;
import java.util.Set;

public class CommonElementsInMatrix {
	//https://practice.geeksforgeeks.org/problems/find-distinct-elements2054/1#
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[4][4];
		matrix[0] = new int[]{2, 1, 4, 3};
		matrix[1] = new int[]{1, 2, 3, 2};
		matrix[2] = new int[]{3, 6, 2, 3};
		matrix[3] = new int[]{5, 2, 5, 3};
		System.out.println(distinct(matrix));
	}
	
	//O(N*M) Time || O(N) Space
	public static int distinct(int M[][]) {
		// code here
		int count = 0;
		Set<Integer> numsSet = new HashSet<Integer>();

		for (int i = 0; i < M[0].length; i++) {

			int row = 0;
			int column = 0;
			int num = M[row][i];
			if (numsSet.contains(num))
				continue;
			numsSet.add(num);
			while (row < M.length && column >= 0 && column < M[0].length) {
				if (M[row][column] == num) {
					column = 0;
					row++;
				} else
					column++;
			}
			if (row == M.length)
				count++;
		}
		return count;
	}
}
