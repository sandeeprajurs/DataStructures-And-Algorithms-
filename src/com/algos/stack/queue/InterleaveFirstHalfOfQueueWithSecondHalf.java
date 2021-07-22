package com.algos.stack.queue;
import java.util.Queue;
import java.util.Stack;

//O(n) ST
//https://www.geeksforgeeks.org/interleave-first-half-queue-second-half/
public class InterleaveFirstHalfOfQueueWithSecondHalf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new java.util.LinkedList<>();
	    q.add(11);
	    q.add(12);
	    q.add(13);
	    q.add(14);
	    q.add(15);
	    q.add(16);
	    q.add(17);
	    q.add(18);
	    q.add(19);
	    q.add(20);
	    interLeaveQueue(q);
	    int length = q.size();
	    for (int i = 0; i < length; i++) 
	    {
	        System.out.print(q.peek() + " ");
	        q.poll();
	    }
	}
	
	static void interLeaveQueue(Queue<Integer> q) {
		Stack<Integer> s = new Stack<>();
		int length = q.size()/2;
		for(int i=0; i<length; i++) {
			s.add(q.poll());
		}
		reverse(s);
		
		while(!s.isEmpty()) {
			q.add(s.pop());
			q.add(q.poll());
		}
	}
	
	static void reverse(Stack<Integer> st)
	{
		if(st.isEmpty())
          return;
      	int x = st.pop();
      	reverse(st);
      	insertAtBottom(st, x);
	}
	
	static void insertAtBottom(Stack<Integer> st, int num){
    	if(st.isEmpty()){
        	st.push(num);
        }
      	else{
      		int x = st.pop();
          	insertAtBottom(st, num);
          	st.push(x);
        }
    }
}
