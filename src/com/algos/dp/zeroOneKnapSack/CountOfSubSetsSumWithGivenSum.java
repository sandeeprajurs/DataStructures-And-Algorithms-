package com.algos.dp.zeroOneKnapSack;

public class CountOfSubSetsSumWithGivenSum {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 3, 5, 6, 8, 10 };
		int sum = 10;
		int countSubSets = countSubSets(nums, sum);
		System.out.println(countSubSets);
	}

	public static int countSubSets(int[] nums, int sum) {
		// initilization
		int[][] t = new int[nums.length + 1][sum + 1];
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				if (i == 0)
					t[i][j] = 0;
				if (j == 0) {
					t[i][j] = 1;
				}
//					t[i][j] = (int) Math.pow(2, i);
			}
		}

		for (int i = 1; i < t.length; i++) {
			for (int j = 1; j < t[0].length; j++) {
				if (nums[i - 1] <= j)
					t[i][j] = t[i - 1][j - nums[i - 1]] + t[i - 1][j];

				else if (nums[i - 1] > j)
					t[i][j] = t[i - 1][j];
			}
		}
		return t[t.length - 1][t[0].length - 1];
	}
}
