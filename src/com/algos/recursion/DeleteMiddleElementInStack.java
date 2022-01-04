package com.algos.recursion;

import java.util.Stack;

public class DeleteMiddleElementInStack {
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack);
		delMiddle(stack);
		System.out.println(stack);
	}
	
	public static void delMiddle(Stack<Integer> stack) {
		if(stack.size() == 0) return;
		int k= (stack.size()/2) + 1;
		solve(stack, k);
	}

	private static void solve(Stack<Integer> stack, int k) {
		if(k==1) {
			stack.pop();
			return;
		}
		int temp = stack.pop();
		solve(stack, k-1);
		stack.push(temp);
		return;
	}
}
