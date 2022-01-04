package com.algos.stack.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queues {
	
	public static void main(String[] args) {
		StackUsing2Queues queue = new StackUsing2Queues();
		queue.push(1);
		queue.push(2);
		System.out.println(queue.pop());
		System.out.println(queue);
	}

	Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    //Function to push an element into stack using two queues.
    void push(int a)
    {
	    q1.add(a);
	    while(q1.size() > 1){
	        q2.add(q1.poll());
	    }
	    
	    while(!q2.isEmpty()){
	        q1.add(q2.poll());
	    }
    }
    
    //Function to pop an element from stack using two queues. 
    int pop()
    {
        if(q1.size() > 0)
	        return q1.poll();
	    return -1;
    }
}
