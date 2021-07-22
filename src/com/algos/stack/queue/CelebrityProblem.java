package com.algos.stack.queue;

import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1
//O(n)ST
public class CelebrityProblem {

	public static void main(String[] args) {
		int[][] M = new int[3][3];
		M[0] = new int[] { 0, 1, 0 };
		M[1] = new int[] { 0, 0, 0 };
		M[2] = new int[] { 0, 1, 0 };

		celebrity(M, 3);
	}

	static int celebrity(int M[][], int n) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < M.length; i++) {
			s.push(i);
		}
		return getCelebrity(s, M);
	}

	public static boolean knows(int[][] M, int a, int b) {
		if (M[a][b] == 1)
			return true;
		else
			return false;
	}

	public static int getCelebrity(Stack<Integer> s, int[][] M) {
		while (s.size() > 1) {
			int first = s.pop();
			int second = s.pop();
			boolean know = knows(M, first, second);
			if (know) {
				s.push(second);
			} else {
				s.push(first);
			}
		}
		int potential = s.pop();
		for (int i = 0; i < M.length; i++) {
			if (i == potential) {
				continue;
			}
			if (M[i][potential] != 1 || M[potential][i] == 1) {
				return -1;
			}

		}
		return potential;
	}

}
