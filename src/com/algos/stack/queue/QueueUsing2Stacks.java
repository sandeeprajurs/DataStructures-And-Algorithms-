package com.algos.stack.queue;

import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/queue-using-two-stacks/1
public class QueueUsing2Stacks {

	public static void main(String[] args) {
	}

	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();

	// Function to push an element in queue by using 2 stacks.
	// O(1) ST
	void Push(int x) {
		s1.push(x);
	}

	// Function to pop an element from queue by using 2 stacks.
	// O(n) ST
	int Pop() {
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				int num = s1.pop();
				s2.push(num);
			}
		}
		return s2.isEmpty() ? -1 : s2.pop();
	}

}
