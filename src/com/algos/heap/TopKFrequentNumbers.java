package com.algos.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentNumbers {

	static PriorityQueue<Pair_1> minHeap = new PriorityQueue<Pair_1>(new Pair_1());

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(3);
		list.add(2);
		list.add(2);
		list.add(4);
		solve(2, list);
	}

	public static void solve(int k, List<Integer> list) {
		//create mapping
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<list.size(); i++) {
			if(map.containsKey(list.get(i)))
				map.put(list.get(i), map.get(list.get(i)) + 1);
			else
				map.put(list.get(i), 1);
		}
		
		//store in heap
		for(int key : map.keySet()) {
			minHeap.add(new Pair_1(key, map.get(key)));
			if(minHeap.size() > k)
				minHeap.poll();
		}
		
		while(!minHeap.isEmpty()) {
			System.out.println(minHeap.poll().key);
		}
	
	}
}

class Pair_1 implements Comparator<Pair_1> {

	int key;
	int value;

	public Pair_1() {

	}

	public Pair_1(int key, int value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public int compare(Pair_1 p1, Pair_1 p2) {
		//Min Heap
		if(p2.value < p1.value) return 1;
		if(p2.value == p1.value) return 0;
		return -1;
	}

}
