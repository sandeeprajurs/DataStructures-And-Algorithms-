package com.algos.strings;

import java.util.ArrayList;
import java.util.List;

//O(2^n) ST
//abc each char can take 2 decision so 2*2*2 = 2^3 = 2^n
public class AllSubsequenceOfAString {
	
	static List<String> list = new ArrayList<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getAllSubsequence("abcd","");
		System.out.println(list);
	}
	
	public static void getAllSubsequence(String string, String ans) {
		if(string.length() == 0) {
			list.add(ans);
			return;
		}
		//decision 1
		getAllSubsequence(string.substring(1), ans+string.charAt(0));
		//decision 2
		getAllSubsequence(string.substring(1), ans);
	}

}
