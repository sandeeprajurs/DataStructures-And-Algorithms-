package com.algos.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SortKSortedArray {
	
	static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	static List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		int[] arr = new int[] { 7, 10, 4, 3, 20, 15 };
		int k = 3;
		solve(arr, k);
	}
	
	public static void solve(int[] arr, int k) {
		for(int i=0; i<k; i++) {
			minHeap.add(arr[i]);
		}
		
		for (int i = k; i < arr.length; i++) {
			minHeap.add(arr[i]);
			while(minHeap.size() > k) {
				list.add(minHeap.poll());
			}
		}

		while (!minHeap.isEmpty()) {
			list.add(minHeap.poll());
		}
		
		System.out.println(list);
	}
}
