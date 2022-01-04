package com.algos.stack.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class AV_NextSmallerElement_Left_and_Right {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(5);
		list.add(2);
		list.add(10);
		list.add(8);
		solve(list);
	}
	
//	 Nearest Smaller to Left
//	public static void solve(List<Integer> list) {
//		Stack<Integer> stack = new Stack<Integer>();
//		List<Integer> result = new ArrayList<Integer>();
//		for(int i=0; i<list.size(); i++) {
//			if(stack.size() == 0) {
//				result.add(-1);
//			}
//			else if(stack.size() >0 && stack.peek() <= list.get(i)) {
//				result.add(stack.peek());
//			}
//			else if(stack.size() >0 && stack.peek() > list.get(i)) {
//				while(stack.size() >0 && stack.peek() > list.get(i)) {
//					stack.pop();
//				}
//				
//				if(stack.size() == 0) result.add(-1);
//				else if(stack.peek() <= list.get(i)) {
//					result.add(stack.peek());
//				}
//			}
//			stack.push(list.get(i));
//		}
//		System.out.println(result);
//	}
	
	
	// Nearest Smaller to Right
	public static void solve(List<Integer> list) {
		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		for(int i=list.size()-1; i>=0; i--) {
			if(stack.size() == 0) {
				result.add(-1);
			}
			else if(stack.size() >0 && stack.peek() <= list.get(i)) {
				result.add(stack.peek());
			}
			else if(stack.size() >0 && stack.peek() > list.get(i)) {
				while(stack.size() >0 && stack.peek() > list.get(i)) {
					stack.pop();
				}
				
				if(stack.size() == 0) result.add(-1);
				else if(stack.peek() <= list.get(i)) {
					result.add(stack.peek());
				}
			}
			stack.push(list.get(i));
		}
		Collections.reverse(result);
		System.out.println(result);
	}
}
