package com.algos.dp.mcm;

public class PalindromicPartitioning {

	static int[][] t;

	public static void main(String[] args) {
		String str = "nitina";
		t = new int[str.length() + 1][str.length() + 1];
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				t[i][j] = -1;
			}
		}
		int ans = palindromicPartitioning(str, 0, str.length() - 1);
		System.out.println(ans);
		// nitin and a so 1 =>> nitin||a
	}

//	Recursion
//	public static int palindromicPartitioning(String str, int i, int j) {
//		if(i>=j) return 0;
//		if(isPalindrome(str, i, j)) return 0;
//		int min = Integer.MAX_VALUE;
//		for(int k=i; k<j; k++) {
//			int temp = 1 + palindromicPartitioning(str, i, k) + palindromicPartitioning(str, k+1, j);
//			if(temp < min)
//				min = Math.min(temp,min);
//		}
//		return min;
//	}

	// Memoization
	public static int palindromicPartitioning(String str, int i, int j) {
		if (i >= j)
			return 0;
		if (isPalindrome(str, i, j))
			return 0;
		if(t[i][j] != -1) return t[i][j];
		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int temp = 1 + palindromicPartitioning(str, i, k) + palindromicPartitioning(str, k + 1, j);
			if (temp < min)
				min = Math.min(temp, min);
		}
		t[i][j] = min;
		return min;
	}

	public static boolean isPalindrome(String str, int i, int j) {
		while (i <= j) {
			if (str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}
