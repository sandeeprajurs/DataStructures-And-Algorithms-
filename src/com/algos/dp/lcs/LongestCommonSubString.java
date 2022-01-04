package com.algos.dp.lcs;

import java.util.Arrays;

public class LongestCommonSubString {

	static int[][] t;

	public static void main(String[] args) {
		String x = "abcdgh";
		String y = "abedfhr";
		t = new int[x.length() + 1][y.length() + 1];
		int ans = longestCommonSubString(x, y, t.length-1, t[0].length-1);
		System.out.println(ans);
	}

	public static int longestCommonSubString(String x, String y, int m, int n) {
		// initilization (base condeition in recursion)
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				if (i == 0 || j == 0)
					t[i][j] = 0;
			}
		}

		// conditional diagram part
		for (int i = 1; i < t.length; i++) {
			for (int j = 1; j < t[0].length; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1))
					t[i][j] = 1 + t[i - 1][j - 1];
				else
					t[i][j] = 0;
			}
		}
		
		
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < t.length; i++) {
			for (int j = 1; j < t[0].length; j++) {
				max = Math.max(t[i][j], max);
			}
		}
		System.out.println(Arrays.deepToString(t));
		return max;
	}
}
