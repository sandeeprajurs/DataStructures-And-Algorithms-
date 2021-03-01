package com.algos.strings;

import java.util.*;

public class MinimumWindowSubstring {
	//https://leetcode.com/problems/minimum-window-substring/submissions/
	public static void main(String[] args) {
		System.out.println(minWindowSubString("ADOBECODEBANC", "ABC"));
	}
	
	//O(n) ST
	public static String minWindowSubString(String s, String p) {
		Map<Character, Integer> window = new HashMap<>();
		Map<Character, Integer> minWindow = new HashMap<>();
		
		for(int i=0; i<p.length(); i++) {
			char c = p.charAt(i);
			if(!window.containsKey(c))
				window.put(c, 0);
			window.put(c, window.get(c) + 1);
		}
		
		int l = 0;
		int r = 0;
		int minLeftIdx = 0;
		int minRightIdx = 0;
		int result = -1;
		int required = window.size();
		int expected = 0;
		while(r<s.length()) {
			char currChar = s.charAt(r);
			if(window.containsKey(currChar)) {
				if(!minWindow.containsKey(currChar))
					minWindow.put(currChar, 0);
				minWindow.put(currChar, minWindow.get(currChar)+1);
				if(window.get(currChar).intValue() == minWindow.get(currChar).intValue())
					expected++;
			}
			while(l<=r && required == expected) {
				char leftChar = s.charAt(l);
				if(result == -1 || result > (r-l)+1) {
					result = (r-l)+1;
					minLeftIdx = l;
					minRightIdx = r;
				}
				
				if(window.containsKey(leftChar)) {
					if(minWindow.containsKey(leftChar))
						minWindow.put(leftChar, minWindow.get(leftChar) - 1);
					if(minWindow.get(leftChar).intValue() < window.get(leftChar).intValue())
						expected--;
				}
				l++;
			}
			r++;
		}
		return result == -1? "-1": s.substring(minLeftIdx, minRightIdx+1);
	}

}
