package com.algos.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

	static List<String> ans = new ArrayList<String>();
	static List<String> strList = new ArrayList<String>();
	
	static Map<String, Boolean> map = new HashMap<String, Boolean>();
	public static void main(String[] args) {
		String str = "ilike";
		strList = new ArrayList<String>();
		strList.add("i");
		strList.add("like");
		strList.add("sam");
		strList.add("sung");
		strList.add("samsung");
		strList.add("mobile");
		strList.add("ice");
		str = "ilike";
		
		System.out.println(wordBreak(str));
	}

	//Recursive
//	public static boolean wordBreak(String str) {
//		if(str.length() == 0) return true;
//		for(int i=1; i<=str.length(); i++) {
//			System.out.println(str);
//			if(strList.contains(str.substring(0, i)) && wordBreak(str.substring(i, str.length())))
//				return true;
//		}
//		return false;
//	}
	
	//Memoization
//	public static boolean wordBreak(String str) {
//		if(str.length() == 0) return true;
//		if(map.containsKey(str)) return map.get(str);
//		for(int i=1; i<=str.length(); i++) {
//			if(strList.contains(str.substring(0, i)) && wordBreak(str.substring(i, str.length()))) {
//				map.put(str, true);
//				return true;
//			}
//		}
//		map.put(str, false);
//		return false;
//	}
	
	public static boolean wordBreak(String str) {
		boolean[] dp = new boolean[str.length()+1];
		dp[0] = true;
		for(int len=1; len<=str.length(); len++) {
			for(int i=0; i<len; i++) {
				if(dp[i] && strList.contains(str.substring(i, len))) {
					dp[len] = true;
					break; //break
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[str.length()];
	}
}
