package com.algos.dp.zeroOneKnapSack;

public class CountSubSetWithGivenDiffProblem {
	
	public static void main(String[] args) {
		int[] num = new int[] {1,1,2,3};
		int ans = getSubSetCountForGivenDiff(num, 1);
		System.out.println(ans);
	}
	
	public static int getSubSetCountForGivenDiff(int[] nums, int diff) {
		int arrSum = 0;
		for(int i=0; i<nums.length; i++)
			arrSum += nums[i];
		//sum(s1) - sum(s2) = diff
		//sum(s1) + sum(s2) = arr(sum)
		// 2 sum(s1) = diff + arr(sum)
		// sum(s1) = diff + arr(sum) / 2;
		int sumS1 = (diff + arrSum)/2;
		
		//sum(s1) - sum(s2) = diff
		// sum(s1) - diff = sum(s2)
		//so now we need to find sum(s1) count in array so that we get the count of [sum(s1) - sum(s2)] == diff 
		int[][] t = new int[nums.length+1][arrSum+1];
		for(int i=0; i<t.length; i++) {
			for(int j=0; j<t.length; j++) {
				if(i == 0)
					t[i][j] = 0;
				if(j == 0)
					t[i][j] = 1;
			}
		}
		
		for(int i=1; i<t.length; i++) {
			for(int j=1; j<t.length; j++) {
				if(nums[i-1] <= j)
					t[i][j] = t[i-1][j - nums[i-1]] + t[i-1][j];
				else
					t[i][j] = t[i-1][j];
			}
		}
		//last row and that particular sum(sumS1) gives count
		return t[t.length-1][sumS1];
	}
}
