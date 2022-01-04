package com.algos.stack.queue;

import java.util.Stack;

public class AV_MinStack {

	static Stack<Integer> stack = new Stack<Integer>();
	static Stack<Integer> minStack = new Stack<Integer>();
	
	public static void main(String[] args) {
		push(18);
		push(19);
		push(29);
		pop();
		System.out.println(minStack.peek());
		push(15);
		push(16);
		pop();
		System.out.println(minStack.peek());
		pop();
		System.out.println(minStack.peek());
	}

	public static void push(int num) {
		stack.push(num);
		if(minStack.isEmpty() || num <= minStack.peek()) 
			minStack.push(num);
	}

	static int pop() {
		if(stack.isEmpty()) return -1;
		int temp = stack.pop();
		if(temp == minStack.peek())
			minStack.pop();
		return temp;
	}
}
