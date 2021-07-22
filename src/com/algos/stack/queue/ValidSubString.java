package com.algos.stack.queue;

import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/valid-substring0624/1#
public class ValidSubString {
	
	//O(n) ST
	public static void main(String[] args) {
		System.out.println(findMaxLen("))()))(()))"));
	}
	
	static int findMaxLen(String S) {
        //O(n) ST
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int total = 0;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == '(')
                stack.push(i);
            else
                stack.pop();
            
            if(!stack.isEmpty())
                total = Math.max(total, Math.abs(i-stack.peek()));
            else
                stack.push(i);
        }
        return total;
    }
}
