package com.algos.stack.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
//O(n) Time | O(k) Space
public class FindFirstNegativeNumInWindowOfSizeK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] l = printFirstNegativeInteger(new long[] { -8, 2, 3, -6, 10 }, 5, 2);
		System.out.println(Arrays.toString(l));
	}

	public static long[] printFirstNegativeInteger(long nums[], int N, int k) {
		Stack<Integer> stack = new Stack<Integer>();
		List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < k; i++) {
			if (nums[i] < 0)
				stack.add(i);
		}

		for (int i = k; i < N; i++) {
			if (!stack.isEmpty())
				list.add(nums[stack.get(0)]);
			else
				list.add(0L);

			while (!stack.isEmpty() && stack.get(0) < i - k + 1)
				stack.remove(0);

			if (nums[i] < 0)
				stack.add(i);
		}

		if (!stack.isEmpty())
			list.add(nums[stack.get(0)]);
		else
			list.add(0L);

		long[] result = new long[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

}
