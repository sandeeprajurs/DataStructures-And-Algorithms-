package com.algos.arrays;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithZeroSum {
	//Find if there is a sub array with 0 sum
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subArrayWithZeroSums(new int[] {4, 2, -3, 1, 6}));
	}
	
	//O(n) ST
	public static boolean subArrayWithZeroSums(int[] arr) {
		int sum = 0;
		Set<Integer> sums = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum == 0)
				return true;
			else if (sums.contains(sum))
				return true;
			else
				sums.add(sum);
		}
		return false;
	}
}
