package com.algos.stack.queue;
//O(1) Time | O(n) Space
public class StackMiddleElement {
	
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(new Node(1));
		s.push(new Node(2));
		s.push(new Node(3));
		s.push(new Node(4));
		s.push(new Node(5));
		s.push(new Node(6));
		s.push(new Node(7));
		s.push(new Node(8));
		s.pop();
		s.pop();
		s.deleteMiddle();
		s.deleteMiddle();
		s.push(new Node(9));
		System.out.println(s.getMiddleEle().val);
	}
	
	static class Stack{
		DoublyLinkedList dll = new DoublyLinkedList();
		
		public void push(Node node) {
			dll.push(node);
		}
		
		public Node pop() {
			return dll.deleteNode();
		}
		
		public void deleteMiddle() {
			dll.deleteMiddle();
		}
		
		public Node getMiddleEle() {
			return dll.middle;
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
		public Node middle;
		int length;
		
		public void push(Node node) {
			if(head == null) {
				this.head = node;
				this.tail = node;
				this.middle = node;
				length++;
			}
			else {
				insertNode(node);
			}
		}
		
		public void insertNode(Node node) {
			length++;
			node.prev = tail;
			node.next = tail.next;
			tail.next = node;
			tail = node;
			if(length % 2 != 0)
				middle = middle.next;
		}
		
		public void deleteMiddle() {
			length--;
			if(middle == head) {
				head = null;
				tail = null;
				middle = null;
				return;
			}
			if(middle == tail) {
				middle = head;
				tail = head;
				return;
			}
			Node prev = middle.prev;
			Node next = middle.next;
			prev.next = next;
			next.prev = prev;
			if(length % 2 != 0)
				middle = next;
			else
				middle = prev;
		}
		
		public Node deleteNode() {
			length--;
			Node temp = tail;
			Node currNode = tail.prev;
			currNode.next = null;
			tail = currNode;
			if(length % 2 == 0)
				middle = middle.prev;
			return temp;
		}
	}


}
