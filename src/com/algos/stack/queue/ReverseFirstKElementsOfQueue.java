package com.algos.stack.queue;
import java.util.Queue;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1
//O(n) ST
public class ReverseFirstKElementsOfQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Queue<Integer> modifyQueue(Queue<Integer> q, int k)
    {
      Stack<Integer> stack = new Stack<Integer>();
      int count = 0;
      while(count < k){
          int num = q.poll();
          stack.push(num);
          count++;
      }
      
      while(!stack.isEmpty()){
          q.add(stack.pop());
      }
      
      while(count < q.size()){
          int num = q.poll();
          q.add(num);
          count++;
      }
      return q;
    }

}
