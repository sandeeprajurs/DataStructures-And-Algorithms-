package com.algos.stack.queue;

//https://www.geeksforgeeks.org/circular-queue-set-1-introduction-array-implementation/
//O(1) ST
public class ImplementCircularQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularQueue cq= new CircularQueue(5);
		cq.enQueue(1);
		cq.enQueue(2);
		cq.enQueue(3);
		cq.enQueue(4);
		cq.enQueue(5);
		cq.deQueue();
		cq.enQueue(6);
		cq.enQueue(7);
		System.out.println(cq);
	}
	
	static class CircularQueue{
		
		int[] arr;
		int front = -1;
		int rear = -1;
		public CircularQueue(int num){
			arr = new int[num];
		}
		
		public void enQueue(int num) {
			if(isFull()) {
				System.out.println("Queue is Full");
				return;
			}
			if(front == -1) front = 0;
			rear = (rear + 1) % arr.length;
			arr[rear] = num;
		}
		
		public void deQueue() {
			if(isEmpty()) {
				System.out.println("Queue is Empty");
				return;
			}
			front = (front+1) % arr.length;
		}
		
		public boolean isEmpty() {
			return front == -1;
		}
		
		public boolean isFull() {
			if((front == 0 && rear == arr.length-1) || (rear+1 == front)) return true;
			return false;
		}
	
	}
}
