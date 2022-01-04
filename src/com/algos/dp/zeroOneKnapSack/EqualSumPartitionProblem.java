package com.algos.dp.zeroOneKnapSack;

public class EqualSumPartitionProblem {
	static boolean[][] t;

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 5, 11, 5, 2 };
		System.out.println(equalSubSet(nums));
	}

	public static boolean equalSubSet(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++)
			sum += nums[i];

		if (sum % 2 != 0)
			return false;
		t = new boolean[nums.length + 1][sum + 1];
		return doesSubSetExist(nums, sum / 2);
	}

	// Top Down Iteratrive approach
	public static boolean doesSubSetExist(int[] nums, int sum) {
		// initilization
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				if (i == 0)
					t[i][j] = false;
				if (j == 0)
					t[i][j] = true;
			}
		}

		for (int i = 1; i < t.length; i++) {
			for (int j = 1; j < t[0].length; j++) {
				if (nums[i - 1] <= j)
					t[i][j] = t[i - 1][j - nums[i - 1]] || t[i - 1][j];

				else if (nums[i - 1] > j)
					t[i][j] = t[i - 1][j];
			}
		}
		return t[t.length - 1][t[0].length - 1];
	}
}
