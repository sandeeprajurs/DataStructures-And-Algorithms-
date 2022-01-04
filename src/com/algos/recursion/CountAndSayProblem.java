package com.algos.recursion;

public class CountAndSayProblem {
	
	public static void main(String[] args) {
		System.out.println(solve(5));
	}
	
	public static String solve(int N) {
		//base condition
		if(N == 1) return "1";
		//Hypothesis (including method def)
		String str = solve(N-1);
		//induction
		StringBuilder strBldr = new StringBuilder();
		int count=1;
		for(int i=1; i<str.length(); i++) {
			if(str.charAt(i-1) != str.charAt(i)) {
				strBldr.append(count);
				strBldr.append(str.charAt(i-1));
				count=0;
			}
			count++;
		}
		strBldr.append(count);
		strBldr.append(str.charAt(str.length()-1));
		return strBldr.toString();
	}
}
