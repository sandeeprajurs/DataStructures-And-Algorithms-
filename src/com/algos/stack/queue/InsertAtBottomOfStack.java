package com.algos.stack.queue;

import java.util.Stack;

//O(n) ST
//https://stackoverflow.com/questions/45130465/inserting-at-the-end-of-stack
public class InsertAtBottomOfStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		insertAtBottom(s, 0);
		System.out.println(s);
	}
	
	public static void insertAtBottom(Stack<Integer> s, int num) {
		if(s.isEmpty()) {
			s.push(num);
			return;
		}
		int x = s.pop();
		insertAtBottom(s, num);
		s.push(x);
	}
	
}
