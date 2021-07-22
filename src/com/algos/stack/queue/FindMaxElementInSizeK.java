package com.algos.stack.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FindMaxElementInSizeK {
	//https://leetcode.com/problems/sliding-window-maximum/
	//O(n) ST
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] {1}, 1)));
	}

	 public static int[] maxSlidingWindow(int[] nums, int k) {
		 Stack<Integer> stack = new Stack<Integer>();
		 List<Integer> result = new ArrayList<Integer>();
		 for(int i=0; i<k; i++) {
			 while(!stack.isEmpty() && nums[i] > nums[stack.peek()])
				 stack.pop();
			 stack.add(i);
		 }
		 
		 for(int i=k; i<nums.length; i++) {
			 result.add(nums[stack.get(0)]);
			 while(!stack.isEmpty() && stack.get(0) < i-k+1)
				 stack.remove(0);
			 
			 while(!stack.isEmpty() && nums[i] > nums[stack.peek()])
				 stack.pop();
			 stack.add(i);
		 }
		 result.add(nums[stack.get(0)]);
		 int[] res = new int[result.size()];
		 for(int i=0; i<result.size();i++)
	            res[i] = result.get(i);
		 return res;
	 }
}
