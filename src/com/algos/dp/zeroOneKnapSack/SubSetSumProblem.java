package com.algos.dp.zeroOneKnapSack;

public class SubSetSumProblem {

	static boolean[][] t;

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 3, 7, 8, 10 };
		int sum = 6;
		t = new boolean[nums.length + 1][sum + 1];
//		for(int i=0; i<t.length; i++) {
//			for(int j=0; j<t[0].length; j++) {
//				if(i == 0) 
//					t[i][j] = false;
//				if(j == 0) 
//					t[i][j] = true;
//			}
//		}

		boolean ans = doesSubSetExist(nums, sum);
		System.out.println(ans);

	}

//	Recursion
//	public static boolean doesSubSetExist(int[] nums, int sum, int n) {
//		if(sum == 0 && n == 0 || sum == 0 && n >= 0) return true;
//		if(sum >= 0 && n == 0) return false;
//		
//		if(nums[n-1] <= sum) 
//			return doesSubSetExist(nums, sum - nums[n-1], n-1) || doesSubSetExist(nums, sum, n-1);
//		else if(nums[n-1] > sum)
//			return doesSubSetExist(nums, sum, n-1);
//		return false;
//	}

//	Recursion with memoization
//	public static boolean doesSubSetExist(int[] nums, int sum, int n) {
//		if(sum == 0 && n == 0 || sum == 0 && n >= 0) return true;
//		if(sum >= 0 && n == 0) return false;
//		if(t[n][sum]) return t[n][sum];
//		
//		if(nums[n-1] <= sum) {
//			t[n][sum] = doesSubSetExist(nums, sum - nums[n-1], n-1) || doesSubSetExist(nums, sum, n-1);
//			return t[n][sum];
//		}
//		else if(nums[n-1] > sum) {
//			t[n][sum] = doesSubSetExist(nums, sum, n-1);
//			return t[n][sum];
//		}
//		return false;
//	}

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
