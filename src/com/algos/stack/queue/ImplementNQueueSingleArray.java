package com.algos.stack.queue;

import java.util.Arrays;

//https://www.geeksforgeeks.org/efficiently-implement-k-queues-single-array/
public class ImplementNQueueSingleArray {

	public static void main(String[] args) {
		NQueue ks=  new NQueue(3, 5);
		ks.enqueue(1, 0);
		ks.enqueue(2, 0);
		
		ks.enqueue(3, 1);
		ks.enqueue(4, 1);
		
		ks.enqueue(5,  2);
		
		ks.dequeue(1);
		ks.dequeue(0);
		System.out.println(ks);
	}
	
	static class NQueue{
		int[] arr;
		int[] front;
		int[] rear;
		int[] next;
		int free = 0;
		
		public NQueue(int k, int n) {
			arr = new int[n];
			front = new int[k];
			rear = new int[k];
			next = new int[n];
			
			Arrays.fill(front, -1);
			Arrays.fill(rear, -1);
			
			for(int i =0; i<n-1; i++) {
				next[i] = i+1;
			}
			next[n-1] = -1;
		}
		
		//O(1)ST
		public void enqueue(int val, int queue) {
			if(isFull()) {
				System.out.println("Queue is full");
				return;
			}
			int nextFree = next[free];
			arr[free] = val;
			if(isEmpty(queue)) {
				front[queue] = rear[queue] = free;
			}
			else {
				next[rear[queue]] = free;
				rear[queue] = free;
			}
			next[free] = -1;
			free = nextFree;
		}
		
		//O(1)ST
		public int dequeue(int queue) {
			if(isEmpty(queue)) {
				return Integer.MAX_VALUE;
			}
			int i = front[queue];
			front[queue] = next[i];
			next[i] = free;
			free = i;
			return arr[i];
		}
		
		public boolean isEmpty(int queue) {
			return front[queue] == -1;
		}
		
		public boolean isFull() {
			return free == -1;
		}
	}

}
