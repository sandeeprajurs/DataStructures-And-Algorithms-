package com.algos.stack.queue;

import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/valid-substring0624/1#
public class LongestValidParenthesis {
	
	//O(n) ST
	public static void main(String[] args) {
		System.out.println(findMaxLen(")()())"));
	}
	
	
	static int findMaxLen(String S) {
        // code here
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		stack.push(-1);
		for(int i=0; i<S.length(); i++) {
			if(S.charAt(i) == '(') {
				stack.push(i);
			}
			else {
				stack.pop();
				if(!stack.isEmpty())
					max = Math.max(max, Math.abs(i-stack.peek()));
				else
					stack.push(i);
			}
		}
		return max;
    }
}
