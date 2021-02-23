package com.algos.arrays;

public class MinNumberOfJumps {
	//Minimum number of jumps
	public static void main(String[] args) {
		System.out.println(minNumberOfJumps(new int[] {1,3,5,8,9,2,6,7,6,8,9}));
	}
	
	//O(n) Time | O(1) Space
	public static int minNumberOfJumps(int[] nums) {
		int maxReach = 0;
		int currReach = 0;
		int jump = 0;
		for(int i =0; i<nums.length; i++) {
			maxReach = Math.max(i+nums[i], maxReach);
			if(i == currReach) {
				jump++;
				currReach = maxReach;
				if(currReach >= nums.length-1)
					return jump;
			}
		}
		return -1;
	}

}
