package com.algos.heap;

import java.util.PriorityQueue;

public class KthSmallestElement {

	static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b-a);

	public static void main(String[] args) {
		int[] arr = new int[] { 7, 10, 4, 3, 20, 15 };
		int k = 3;
		System.out.println(solve(arr, k));
	}

	public static int solve(int[] arr, int k) {
		for (int i = 0; i < arr.length; i++) {
			maxHeap.add(arr[i]);
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		return maxHeap.peek();
	}


}
