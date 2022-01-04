package com.algos.dp.lcs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LCS {

	static int[][] t;
	public static void main(String[] args) {
		String x="abcdgh";
		String y="abedfhr";
		t=new int[x.length()+1][y.length()+1];
		
//      Initilization for recursive Solution
//		for(int i=0; i<t.length; i++) {
//			for(int j=0; j<t[0].length; j++) {
//				t[i][j]=-1;
//			}
//		}
		
		int ans = lcs(x, y, t.length-1, t[0].length-1);
		System.out.println(ans);
		printLCS(x,y,t);
	}
	
	//Recursive approach
//	public static int lcs(String x, String y, int m, int n) {
//		if(m==0 || n==0) return 0;
//		
//		if(x.charAt(m-1) == y.charAt(n-1))
//			return 1+lcs(x, y, m-1, n-1);
//		else
//			return Math.max(lcs(x, y, m, n-1), lcs(x, y, m-1, n));
//	}
	
	//Memoization(Bottem up)
//	public static int lcs(String x, String y, int m, int n) {
//		if(m==0 || n==0) return 0;
//		
//		if(t[m][n] != -1) return t[m][n]; 
//		
//		if(x.charAt(m-1) == y.charAt(n-1))
//			return t[m][n] = 1+lcs(x, y, m-1, n-1);
//		else
//			return t[m][n] = Math.max(lcs(x, y, m, n-1), lcs(x, y, m-1, n));
//	}
	
	//Top Down Approach
	public static int lcs(String x, String y, int m, int n) {
		//initilization (base condeition in recursion) 
		for(int i=0; i<t.length; i++) {
			for(int j=0; j<t[0].length; j++) {
				if(i==0||j==0) t[i][j] = 0;
			}
		}
		
		//conditional diagram part
		for(int i=1; i<t.length; i++) {
			for(int j=1; j<t[0].length; j++) {
				if(x.charAt(i-1) == y.charAt(j-1))
					t[i][j] = 1+t[i-1][j-1];
				else
					t[i][j] = Math.max( t[i-1][j],  t[i][j-1]);
			}
		}
		return t[t.length-1][t[0].length-1];
	}
	
	public static void printLCS(String x, String y, int[][] t) {
		int i=x.length();
		int j=y.length();
		List<Character> chars = new ArrayList();
		while(i>0 && j>0) {
			if(x.charAt(i-1) == y.charAt(j-1)) {
				chars.add(x.charAt(i-1));
				i--;
				j--;
			}
			else {
				if(t[i-1][j] > t[i][j-1])
					i--;
				else
					j--;
			}
		}
		Collections.reverse(chars);
		System.out.println(chars);
	}
}
