package com.algos.dp.mcm;

import java.util.HashMap;
import java.util.Map;

public class EvaluateExpressionTrue {
	static Map<String, Integer> t;
//	T|T&F^T
	public static void main(String[] args) {
		String str = "T^F&T";
		t = new HashMap<String, Integer>();
		int ans = solve(str, 0, str.length()-1, true);
		System.out.println(ans);
	}
	
//	public static int solve(String str, int i, int j, boolean isTrue) {
//		if(i>j) return 0;
//		if(i==j) {
//			if(isTrue)
//				return str.charAt(i) == 'T'? 1 : 0;
//			else
//				return str.charAt(i) == 'F'? 1 : 0;
//		}
//		int ans=0;
//		for(int k=i+1; k<=j-1; k=k+2) {
//			int lt=solve(str, i, k-1, true);
//			int lf=solve(str, i, k-1, false);
//			int rt=solve(str, k+1, j, true);
//			int rf=solve(str, k+1, j, false);
//			
//			if(str.charAt(k) == '&') {
//				if(isTrue)
//					ans = ans + (lt * rt);
//				else
//					ans = ans + (lt*rf) + (lf*rt) + (lf*rf);
//			}
//			else if(str.charAt(k) == '|') {
//				if(isTrue)
//					ans = ans + (lf*rt) + (lt*rf) + (lt * rt);
//				else
//					ans = ans + (lf * rf);
//			}
//			else if(str.charAt(k) == '^') {
//				if(isTrue)
//					ans = ans + (lf * rt) + (lt * rf);
//				else
//					ans = ans + (lf * rf) + (lt * rt);
//			}
//		}
//		return ans;
//	}
	
	//Memoization
	//3dmatrix is difficult so used hash map with i,j,isTrue as key and ans as value
	public static int solve(String str, int i, int j, boolean isTrue) {
		String key = i+"_"+j+"_"+isTrue;
		if(t.containsKey(key)) return t.get(key);
		
		if(i>j) return 0;
		if(i==j) {
			if(isTrue) return str.charAt(i) == 'T' ? 1: 0;
			else return str.charAt(i) == 'F' ? 1 : 0;
		}
		int ans=0;
		for(int k=i+1; k<=j-1; k=k+2) {
			int lt=solve(str, i, k-1, true);
			int lf=solve(str, i, k-1, false);
			int rt=solve(str, k+1, j, true);
			int rf=solve(str, k+1, j, false);
			
			if(str.charAt(k) == '&') {
				if(isTrue)
					ans += (lt*rt);
				else
					ans += (lf*rf) + (lt*rf) + (lf*rt);
			}
			else if(str.charAt(k) == '|') {
				if(isTrue)
					ans += (lt*rt) + (lt*rf) + (lf*rt);
				else
					ans += (lf*rf);
			}
			else if(str.charAt(k) == '^') {
				if(isTrue)
					ans += (lt*rf) + (lf*rt);
				else
					ans += (lf*rf) + (lt*rt);
			}
		}
		t.put(key, ans);
		return ans;
	}
}
