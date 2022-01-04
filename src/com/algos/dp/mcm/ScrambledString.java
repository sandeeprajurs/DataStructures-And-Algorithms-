package com.algos.dp.mcm;

import java.util.HashMap;
import java.util.Map;

public class ScrambledString {
	
	static Map<String, Boolean> t = new HashMap<String, Boolean>();
	public static void main(String[] args) {
		boolean ans = solve("great", "rgate");
		System.out.println(ans);
	}
	
//	public static boolean solve(String a, String b) {
//		if(a.length() != b.length()) return false;
//		if(a.equals(b)) return true;
//		if(a.length() < 1) {
//			return false;
//		}
//		
//		
//		int n = a.length();
//		boolean flag=false;
//		
//		for(int i=1; i<=n-1; i++) {
//			if((solve(a.substring(0, i), b.substring(n-i)) && solve(a.substring(i), b.substring(0, n-i))) ||
//				solve(a.substring(0, i), b.substring(0, i)) && solve(a.substring(i), b.substring(i))) {
//				flag = true;
//				break;
//			}
//		}
//		return flag;
//	}
	
	//Memoization
	public static boolean solve(String a, String b) {
		String key=a+"_"+b;
		if(t.containsKey(key)) return t.get(key);
		if(a.length() != b.length()) return false;
		if(a.equals(b)) return true;
		if(a.length() < 1) return false;
		
		int n = a.length();
		boolean flag=false;
		
		for(int i=1; i<=n-1; i++) {
			if((solve(a.substring(0, i), b.substring(n-i)) && solve(a.substring(i), b.substring(0, n-i))) ||
				solve(a.substring(0, i), b.substring(0, i)) && solve(a.substring(i), b.substring(i))) {
				flag = true;
				break;
			}
		}
		t.put(key, flag);
		return flag;
	}

}
