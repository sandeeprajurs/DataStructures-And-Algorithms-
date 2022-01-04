package com.algos.dp.lcs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShortestCommonSuperSequence {

	static int[][] t;
	public static void main(String[] args) {
		getSCS("geek", "eke");
		printSCS("geek", "eke");
		//ans is geeke --> length 5
	}

	public static void getSCS(String x, String y) {
		int lcs = getLCS(x, y);
		int ans = (x.length() + y.length()) - lcs;
		System.out.println(ans);
	}

	public static int getLCS(String x, String y) {
		t = new int[x.length() + 1][y.length() + 1];
		// initilization (base condeition in recursion)
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				if (i == 0 || j == 0)
					t[i][j] = 0;
			}
		}
		
		for(int i=1; i<t.length; i++) {
			for(int j=1; j<t[0].length; j++) {
				if(x.charAt(i-1) == y.charAt(j-1))
					t[i][j] = 1+t[i-1][j-1];
				else 
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
			}
		}
		return t[t.length-1][t[0].length-1];
	}
	
	public static void printSCS(String x, String y) {
		int i=x.length();
		int j=y.length();
		List<Character> chars = new ArrayList();
		while(i>0 && j>0) {
			if(x.charAt(i-1) == y.charAt(j-1)) {
				chars.add(x.charAt(i-1));
				i--;
				j--;
			}
			else {
				if(t[i-1][j] > t[i][j-1]) {
					chars.add(x.charAt(i-1));
					i--;
				}
				else {
					chars.add(y.charAt(j-1));
					j--;
				}
			}
		}
		
		while(i>0) {
			chars.add(x.charAt(i-1));
			i--;
		}
		while(j>0) {
			chars.add(y.charAt(j-1));
			i--;
		}
		Collections.reverse(chars);
		System.out.println(chars);
	}

}
