package com.algos.graph;

import java.util.ArrayList;
import java.util.Collections;

//https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
public class RatInMaze {
	// O((N2)4) Time || O(N2) Space
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		int[][] m = new int[4][4];
		m[0] = new int[] { 1, 0, 0, 0 };
		m[1] = new int[] { 1, 1, 0, 1 };
		m[2] = new int[] { 1, 1, 0, 0 };
		m[3] = new int[] { 0, 1, 1, 1 };
        if(m[0][0] == 0) {
        	System.out.println("not able reach destination");
        	return;
        }
        findPath(m, 0, 0, new String(), list);
        Collections.sort(list);
        System.out.println(list);
	}

	public static void findPath(int[][] m, int i, int j, String str, ArrayList<String> list) {
		if (i == m.length - 1 && j == m[0].length - 1) {
			list.add(str);
			return;
		}
		if (i + 1 <= m.length - 1 && m[i + 1][j] == 1) {
			m[i][j] = 0;
			findPath(m, i + 1, j, str + "D", list);
			m[i][j] = 1;
		}
		if (j + 1 <= m[0].length-1 && m[i][j + 1] == 1) {
			m[i][j] = 0;
			findPath(m, i, j + 1, str + "R", list);
			m[i][j] = 1;
		}
		if (j - 1 >= 0 && m[i][j - 1] == 1) {
			m[i][j] = 0;
			findPath(m, i, j - 1, str + "L", list);
			m[i][j] = 1;
		}
		if (i - 1 >= 0 && m[i - 1][j] == 1) {
			m[i][j] = 0;
			findPath(m, i - 1, j, str + "U", list);
			m[i][j] = 1;
		}
	}
}
