package com.algos.strings;

import java.util.*;

public class SecondMaxOccuranceOfWord {
	//O(n) ST
	//Second most repeated string in a sequence
	//https://practice.geeksforgeeks.org/problems/second-most-repeated-string-in-a-sequence0534/1#
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(secondMaxOccuranceOfWord(new String[] {"aaa", "bbb", "ccc",  "bbb", "aaa", "aaa"}));
	}
	
	public static String secondMaxOccuranceOfWord(String[] words) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String word : words) {
			if(!map.containsKey(word))
				map.put(word, 0);
			map.put(word, map.get(word)+1);
		}
		
		int max = Integer.MIN_VALUE;
		int secMax = Integer.MIN_VALUE;
		String maxStr = "";
		String secMaxStr = "";
		for(String key:map.keySet()) {
			if(map.get(key) > max) {
				max = map.get(key);
				maxStr = key;
			}
		}
		
		for(String key:map.keySet()) {
			if(!key.equals(maxStr) && map.get(key) > secMax) {
				secMax = map.get(key);
				secMaxStr = key;
			}
		}
		return secMaxStr;
	}

}
