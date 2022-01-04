package com.algos.dp.zeroOneKnapSack;

import java.util.ArrayList;
import java.util.List;

public class MinSubSetDifferenceProblem {
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,6,11,5};
		int minSubSetDiff = getMinSubSetDiff(nums);
		System.out.println(minSubSetDiff);
	}
	
	public static int getMinSubSetDiff(int[] nums) {
		int range=0;
		//first I will find the max range
		for(int i=0; i<nums.length; i++)
			range += nums[i];
		
		//initilize t array for top down approach
		boolean[][] t = new boolean[nums.length+1][range+1];
		for(int i=0; i<t.length; i++) {
			for(int j=0; j<t[0].length; j++) {
				if(i==0) t[i][j] = false;
				if(j==0) t[i][j] = true;
			}
		}
		
		//get if sum exists or not for given nums(same as subsetsum problem)
		for(int i=1; i<t.length; i++) {
			for(int j=1; j<t[0].length; j++) {
				if(nums[i-1] <= j)
					t[i][j] = t[i-1][j - nums[i-1]] || t[i-1][j];
				else if(nums[i-1] > j)
					t[i][j] = t[i-1][j];
			}
		}
		
		
		List<Integer> s1 = new ArrayList<Integer>();
		int i=t.length-1;
		//compute only last row as we need all elements in num[] to compute min diff
		//here we will compute till range/2 as s1 should be less than ranges/2 bcs we are doing s2-s1
		for(int j=0; j<t[0].length; j++) {
			if(t[i][j] && j <= range/2)
				s1.add(j);
		}
		
		//0 <---> range
		// s1+s2 = range
		// s2 = range - s1
		// s2 - s1 --> min diff
		// (range - s1) - s1 --> min diff
		// range - 2s1 --> min diff
		int min = Integer.MAX_VALUE;
		for(int k=0; k<s1.size(); k++)
			min = Math.min(min, range - (2*s1.get(k)));
		return min;
	}
}
