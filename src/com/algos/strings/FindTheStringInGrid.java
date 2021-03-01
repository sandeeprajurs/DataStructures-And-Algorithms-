package com.algos.strings;

public class FindTheStringInGrid {
	//https://leetcode.com/problems/word-search/submissions/
	//https://practice.geeksforgeeks.org/problems/find-the-string-in-grid/0#
	public static void main(String[] args) {
		char[][] board = new char[6][6];
		board[0] = new char[] {'B','B','M','B','B','M'};
		board[1] = new char[] {'C','B','A','B','A','B'};
		board[2] = new char[] {'I','B','G','G','B','B'};
		board[3] = new char[] {'G','B','I','I','B','B'};
		board[4] = new char[] {'A','B','C','B','B','B'};
		board[5] = new char[] {'M','C','I','G','A','M'};
		findString(board, "MAGIC");
	}
	
	//O(n*m) Time || O(n) Space 
	public static void findString(char[][] board, String word) {
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(word.charAt(0) == board[i][j] && search(board, i, j, 0, word))
					System.out.println("pattern found at "+i+" "+j);
			}
		}
	}

	public static boolean search(char[][] board, int row, int col, int count, String word) {
		if(count==word.length()) return true;
		
		if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || word.charAt(count) != board[row][col])
			return false;
		char temp = board[row][col];
		board[row][col] = ' ';
		
		boolean found = search(board, row, col+1, count+1, word) || search(board, row, col-1, count+1, word)
						|| search(board, row-1, col, count+1, word) || search(board, row+1, col, count+1, word) 
						|| search(board, row+1, col+1, count+1, word) || search(board, row+1, col-1, count+1, word) 
						|| search(board, row-1, col+1, count+1, word) || search(board, row-1, col-1, count+1, word);
		board[row][col] = temp;
		return found;
	}

}
