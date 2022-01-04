package com.algos.stack.queue;

import java.util.Stack;

//Formulas
//2*x - min
//2*min - x
public class AV_MinStack_NoExtraSpace {
	
	public static void main(String[] args) {
		push(5);
		System.out.println(getMin());
		push(6);
		System.out.println(getTop());
		push(3);
		System.out.println(getTop());
		System.out.println(getMin());
		pop();
		System.out.println(getTop());
		System.out.println(getMin());
	}
	
	static int min;
	static Stack<Integer> stack = new Stack<Integer>();
	
	static int getMin() {
		if(stack.size() == 0) return -1;
		return min;
	}
	
	static int getTop() {
		if(stack.size() == 0) return -1;
		else if(stack.peek() >= min) return stack.peek();
		else if(stack.peek() < min) return min;
		return 0;
	}
	
	static void push(int x) {
		if(stack.size() == 0) {
			min=x;
			stack.push(x);
		}
		else if(x >= min)
			stack.push(x);
		else if(x < min) {
			stack.push((2*x) - min);
			min = x;
		}
	}
	
	static void pop() {
		if(stack.size() == 0) return;
		else if(stack.peek() >= min)
			stack.pop();
		else if(stack.peek() < min) {
			min = (2*min) - stack.peek();
			stack.pop();
		}
	}
	
}
