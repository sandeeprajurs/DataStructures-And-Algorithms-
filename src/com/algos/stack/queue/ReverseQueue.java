package com.algos.stack.queue;

import java.util.Queue;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/queue-reversal/1
//O(n) ST
public class ReverseQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public Queue<Integer> rev(Queue<Integer> q) {
		Stack<Integer> s1 = new Stack<Integer>();
		while (!q.isEmpty()) {
			s1.push(q.poll());
		}

		while (!s1.isEmpty()) {
			q.add(s1.pop());
		}
		return q;
	}

}
