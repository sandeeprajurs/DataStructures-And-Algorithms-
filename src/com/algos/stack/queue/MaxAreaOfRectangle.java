package com.algos.stack.queue;

import java.util.Stack;

//O(N)ST
//https://leetcode.com/problems/largest-rectangle-in-histogram/submissions/
public class MaxAreaOfRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMaxArea(new long[] {1,2,2}));
	}
	
	 public static long getMaxArea(long hist[])  {
	        Stack<Integer> stack = new Stack<Integer>();
	        // stack.add(0);
	        int[] left = new int[hist.length];
	        int[] right = new int[hist.length];
	        for(int i=0; i<hist.length; i++){
	            while(!stack.isEmpty() && hist[i] <= hist[stack.peek()]){
	                stack.pop();
	            }
	            if(!stack.isEmpty() && hist[i] > hist[stack.peek()])
	                left[i] = stack.peek() + 1;
	            if(stack.isEmpty())
	                left[i] = 0;
	            stack.add(i);
	        }
	        
	        stack.clear();
	        // stack.push(n-1);
	        for(int i=hist.length-1; i>=0; i--){
	            while(!stack.isEmpty() && hist[i] <= hist[stack.peek()]){
	                stack.pop();
	            }
	            if(!stack.isEmpty() && hist[i] > hist[stack.peek()])
	                right[i] = stack.peek() - 1;
	            if(stack.isEmpty())
	                right[i] = hist.length-1;
	            stack.add(i);
	        }
	        
	        long[] result = new long[hist.length];
	        for(int i=0; i<result.length; i++){
	            result[i] = (Math.abs(left[i] - right[i]) +1)*hist[i];
	        }
	        long max = 0L;
	        for(int i=0; i<result.length; i++){
	            if(result[i] > max)
	                max = result[i];
	        }
	        return max;
	    }

}
