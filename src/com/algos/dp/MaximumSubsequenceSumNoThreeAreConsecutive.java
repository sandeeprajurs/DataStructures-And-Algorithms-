package com.algos.dp;

//O(n) Time | O(1) Space
//https://www.geeksforgeeks.org/maximum-subsequence-sum-such-that-no-three-are-consecutive/
public class MaximumSubsequenceSumNoThreeAreConsecutive {

	public static void main(String[] args) {
		System.out.println(maxSumWO3Consec(new int[]{1, 2, 3}, 3));
	}

	static int maxSumWO3Consec(int arr[], int n) {
		if (arr.length == 0)
			return 0;
		if (arr.length == 1)
			return arr[0];
		if (arr.length == 2)
			return arr[1];
		arr[2] = Math.max(arr[2], Math.max(arr[2] + arr[1], arr[2] + arr[0]));
		for (int i = 3; i < n; i++)
			arr[i] = Math.max(arr[i], Math.max(arr[i - 1] + arr[i], arr[i - 2] + arr[i]));
		return arr[n - 1];
	}

}
