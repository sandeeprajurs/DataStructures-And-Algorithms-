package com.algos.stack.queue;


public class Queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueImpl queue = new QueueImpl();
		queue.enque(1);
		queue.enque(2);
		queue.enque(3);
		queue.enque(4);
		System.out.println(queue.deque());
		System.out.println(queue.deque());
		System.out.println(queue);
	}
	
	static class QueueImpl{
		DoublyLinkedList dll =new DoublyLinkedList();
		public void enque(int n) {
			Node node = new Node(n);
			dll.push(node);
		}
		
		public int deque() {
			Node node = dll.deleteNode();
			if(node != null)
				return node.val;
			else
				return -1;
		}
		
		public boolean isEmpty() {
			if(dll.head != null)
				return false;
			else
				return true;
		}
	}
	
	static class Node{
		int val;
		Node prev;
		Node next;
		
		public Node(int val) {
			this.val = val;
		}
	}
	
	static class DoublyLinkedList {
		public Node head;
		public Node tail;
		
		public void push(Node node) {
			if(head == null) {
				this.head = node;
				this.tail = node;
			}
			else {
				insertNode(node);
			}
		}
		
		public void insertNode(Node node) {
			node.prev = tail;
			node.next = tail.next;
			tail.next = node;
			tail = node;
		}
		
		
		public Node deleteNode() {
			if(head == null)
				return null;
			if(head.next == null) {
				head = null;
				tail = null;
				return null;
			}
			Node temp = head;
			head = head.next;
			return temp;
		}
	}

}
