package com.algos.heap;

import java.util.PriorityQueue;

public class PrintKLargestElements {

	static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	
	public static void main(String[] args) {
		int[] arr = new int[] { 7, 10, 4, 3, 20, 15 };
		int k = 3;
		solve(arr, k);
	}
	
	public static void solve(int[] arr, int k) {
		for (int i = 0; i < arr.length; i++) {
			minHeap.add(arr[i]);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		while (!minHeap.isEmpty()) {
			System.out.println(minHeap.poll());
		}
	}
	
}
