package com.algos.strings;

public class LongestCommonPrefix {
	//https://leetcode.com/problems/longest-common-prefix/
	//O(n) Time | O(1) Space
	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
	}
	
	public static String longestCommonPrefix(String[] strArr) {
		String prefix = strArr[0];
		for(int i=1; i<strArr.length; i++) {
			while(strArr[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() -1);
			}
		}
		return prefix;
	}
}
