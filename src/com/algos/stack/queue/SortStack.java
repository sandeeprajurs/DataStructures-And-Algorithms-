package com.algos.stack.queue;

import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/sort-a-stack/1
//O(n) ST
public class SortStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Stack<Integer> sort(Stack<Integer> s)
	{
//      Iterative Approach
// 		Stack<Integer> tempStack = new Stack<Integer>();
// 		while(!s.isEmpty()){
// 		    int x = s.pop();
// 		    while(!tempStack.isEmpty() && x < tempStack.peek()){
// 		        int num = tempStack.pop();
// 		        s.push(num);
// 		    }
// 		    tempStack.push(x);
// 		}
// 		return tempStack;

        Stack<Integer> tempStack = new Stack<Integer>();
        sortElements(s, tempStack);
        return tempStack;
	}
	
	//Recursive Approach
	public void sortElements(Stack<Integer> s, Stack<Integer> tempStack){
	    if(s.isEmpty()) return;
        int x = s.pop();
        insertToTempStack(s, tempStack, x);
        sortElements(s, tempStack);
	}
	
	public void insertToTempStack(Stack<Integer> s, Stack<Integer> tempStack, int x){
	    if(tempStack.isEmpty() || x >= tempStack.peek()){
	        tempStack.push(x);
	        return;
	    }
	    int num = tempStack.pop();
	    s.push(num);
	    insertToTempStack(s, tempStack, x);
	    
	}

}
