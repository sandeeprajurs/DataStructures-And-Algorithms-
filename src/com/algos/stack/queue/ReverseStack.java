package com.algos.stack.queue;

import java.util.Stack;

public class ReverseStack {
	//O(N^2) Time | O(1) Space
	//https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) return;
		
		int x = stack.pop();
		reverse(stack);
		insertAtBottom(stack, x);
	}
	
	static void insertAtBottom(Stack<Integer> stack, int num){
		if(stack.isEmpty()) {
			stack.add(num);
			return;
		}
		int x = stack.pop();
		insertAtBottom(stack, num);
		stack.push(x);
	}
}
