package com.algos.dp.lcs;

public class LPS_MinNumOfDeletionToMakeStrPalindrome {

	public static void main(String[] args) {
		String a = "agbcba";
		String b = new StringBuilder(a).reverse().toString();
		int lps = getLCS(a, b);
		int ans = a.length() - lps;
		System.out.println(ans);
	}

	public static int getLCS(String x, String y) {
		int[][] t = new int[x.length() + 1][y.length() + 1];
		// initilization (base condeition in recursion)
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				if (i == 0 || j == 0)
					t[i][j] = 0;
			}
		}

		for (int i = 1; i < t.length; i++) {
			for (int j = 1; j < t[0].length; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1))
					t[i][j] = 1 + t[i - 1][j - 1];
				else
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
			}
		}
		return t[t.length - 1][t[0].length - 1];
	}
}
