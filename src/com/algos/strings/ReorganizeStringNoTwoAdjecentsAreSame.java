package com.algos.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeStringNoTwoAdjecentsAreSame {
	//https://leetcode.com/problems/reorganize-string/
	//https://www.youtube.com/watch?v=zaM_GLLvysw&t=331s&ab_channel=KevinNaughtonJr.
	public static void main(String[] args) {
		System.out.println(rearrangeString("abbabbaaab"));
	}
	
	//O(n) ST
	public static String rearrangeString(String s) {
		Map<Character, Integer> map =new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(!map.containsKey(c))
				map.put(c, 0);
			map.put(c, map.get(c)+1);
		}
		
		PriorityQueue<Character> maxHeap = new PriorityQueue<Character>((a,b) -> map.get(b) - map.get(a));
		maxHeap.addAll(map.keySet());
		
		StringBuilder result = new StringBuilder();
		while(maxHeap.size() > 1) {
			char first = maxHeap.remove();
			char second = maxHeap.remove();
			result.append(first);
			result.append(second);
			
			map.put(first, map.get(first) -1);
			map.put(second,  map.get(second)-1);
			
			if(map.get(first) > 0)
				maxHeap.add(first);
			if(map.get(second) > 0)
				maxHeap.add(second);
		}
		
		while(!maxHeap.isEmpty()) {
			char c = maxHeap.remove();
			if(map.get(c) > 0)
				return "";
			result.append(c);
		}
		return result.toString();
	}

}
