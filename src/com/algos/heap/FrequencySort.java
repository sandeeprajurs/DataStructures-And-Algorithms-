package com.algos.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
	
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
		solve(list);
	}
	
	public static void solve(List<Integer> list) {
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
		}
		
		List<Integer> result = new ArrayList<Integer>();
		while(!minHeap.isEmpty()) {
			Pair_1 pair = minHeap.poll();
			int element = pair.key;
			int frequency = pair.value;
			for(int i=0; i<frequency; i++) {
				result.add(element);
			}
		}//elements with less frequency is printed first
		System.out.println(result);
	}
}
