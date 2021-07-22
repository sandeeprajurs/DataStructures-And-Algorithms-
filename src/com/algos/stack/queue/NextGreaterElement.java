package com.algos.stack.queue;

import java.util.Arrays;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1#
//O(N) ST
public class NextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(nextLargerElement(new long[] {1, 3, 2, 4}, 4)));
	}
	
	 public static long[] nextLargerElement(long[] arr, int n) { 
		 Stack<Integer> stack = new Stack<Integer>();
		 long[] result = new long[n];
		 for(int i=0; i<n; i++) {
			 while(!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
				 int idx = stack.pop();
				 result[idx] = arr[i]; 
			 }
			 
			 if(stack.isEmpty() || arr[i] < arr[stack.peek()]) {
				 stack.add(i);
			 }
		 }
		 while(!stack.isEmpty()) {
			 int idx = stack.pop();
			 result[idx] = -1;
		 }
		 return result;
	 }
}
