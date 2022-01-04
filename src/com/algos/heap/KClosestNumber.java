package com.algos.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair implements Comparator<Pair>{
	
	int key;
	int value;
	
	public Pair(){
		
	}
	
	public Pair(int key, int value){
		this.key = key;
		this.value = value;
	}

	@Override
	public int compare(Pair pair1, Pair pair2) {
		//min heap
//		if(pair2.value < pair1.value) return 1;
//		else if(pair2.value == pair1.value) return 0;
//		else return -1;
		
		//max heap
		if(pair2.value < pair1.value) return -1;
		if(pair2.value == pair1.value) return 0;
		else return 1;
	}
	
}

public class KClosestNumber {
	
	static PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(new Pair());
	
	public static void main(String[] args) {
		int[] arr = new int[] { 7, 10, 4, 3, 20, 15 };
		int k = 3;
		int x= 7;
		solve(arr, k, x);
	}
	
	public static void solve(int[] arr, int k, int x) {
		for (int i = 0; i < arr.length; i++) {
			maxHeap.add(new Pair(arr[i], Math.abs(arr[i] - x)));
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		
		while (!maxHeap.isEmpty()) {
			System.out.println(maxHeap.poll().key);
		}
		
	}
	
	
}
