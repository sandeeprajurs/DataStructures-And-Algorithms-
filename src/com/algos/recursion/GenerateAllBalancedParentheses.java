package com.algos.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBalancedParentheses {
	
	static List<String> strList = new ArrayList<String>();
	public static void main(String[] args) {
		int N=3;
		int open=N;
		int close=N;
		solve(open, close, "");
		System.out.println(strList);
	}
	
	//Input = open, close here
	static void solve(int open, int close, String output){
		if(open == 0 && close == 0) {
			strList.add(output);
			return;
		}
		
		if(open > 0) {
			String output1 = output;
			output1 += "(";
			solve(open-1, close, output1);
		}
		if(close > open) {
			String output2 = output;
			output2 += ")";
			solve(open, close-1, output2);
		}
	}
}
