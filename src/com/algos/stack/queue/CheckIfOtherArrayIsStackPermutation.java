package com.algos.stack.queue;

import java.util.Stack;

//O(n) ST
//https://www.geeksforgeeks.org/stack-permutations-check-if-an-array-is-stack-permutation-of-other/
public class CheckIfOtherArrayIsStackPermutation {
	
	public static void main(String[] args) {
		System.out.println(checkStackPermutation(new int[] {1,2,3}, new int[] {2, 1, 3}));
	}
	
	static boolean checkStackPermutation(int ip[], int op[]) {
		Stack<Integer> stack = new Stack<Integer>();
      	int i=0;
      	int j=0;
        while(i<ip.length){
          stack.push(ip[i]);
          i++;
          while(!stack.isEmpty() && stack.peek() == op[j]){
            stack.pop();
            j++;
          }
		}
      	if(stack.isEmpty() && i==ip.length) return true;
		return false;
	}
}
