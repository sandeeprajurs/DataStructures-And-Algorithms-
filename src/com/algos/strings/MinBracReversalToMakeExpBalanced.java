package com.algos.strings;

import java.util.Stack;

public class MinBracReversalToMakeExpBalanced {
	//https://practice.geeksforgeeks.org/problems/count-the-reversals/0
	public static void main(String[] args) {
		System.out.println(getMinReverseCount("}{{}}{{{"));
	}
	
	//O(n) ST
	public static int getMinReverseCount(String str) {
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<str.length(); i++) {
			if(stack.size() > 0 && str.charAt(i) == '}') {
				if(stack.peek() == '{')
					stack.pop();
				else if(stack.peek() == '}')
					stack.push(str.charAt(i));
			}
			else
				stack.push(str.charAt(i));
		}
		
		int n=0;
		int stackLength = stack.size();
		while(stack.size() >0 && stack.peek() == '{') {
			stack.pop();
			n++;
		}
		//ceeling operation
		return stackLength/2 + n%2;
	}

}
