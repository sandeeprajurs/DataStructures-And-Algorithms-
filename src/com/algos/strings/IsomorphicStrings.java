package com.algos.strings;

import java.util.Arrays;

public class IsomorphicStrings {
	
	//O(n) time | O(1) space
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIsomorphic("aab", "xxy"));
	}
	
	public static boolean isIsomorphic(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		
		int[] m1 = new int[256];
		int[] m2 = new int[256];
		Arrays.fill(m1, -1);
		Arrays.fill(m2, -1);
		
		for(int i=0; i<s1.length(); i++) {
			if(m1[s1.charAt(i)] == -1 && m2[s2.charAt(i)] == -1) {
				m1[s1.charAt(i)] = s1.charAt(i);
				m2[s2.charAt(i)] = s1.charAt(i);
			}
			else if(m1[s1.charAt(i)] != m2[s2.charAt(i)])
				return false;
		}
		return true;
	}

}
