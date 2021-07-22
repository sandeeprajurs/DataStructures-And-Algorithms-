package com.algos.stack.queue;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
	//https://www.geeksforgeeks.org/next-smaller-element/
	//O(N) ST
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(nextSmallerElement(new long[] {4, 8, 5, 2, 25}, 5)));
	}

	public static long[] nextSmallerElement(long[] arr, int n) {
		Stack<Integer> stack = new Stack<Integer>();
		long[] result = new long[n];
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
				int idx = stack.pop();
				result[idx] = arr[i];
			}

			if (stack.isEmpty() || arr[i] > arr[stack.peek()])
				stack.push(i);
		}
		while (!stack.isEmpty()) {
			int idx = stack.pop();
			result[idx] = -1;
		}
		return result;
	}
}
