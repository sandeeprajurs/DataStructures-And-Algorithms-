package com.algos.linkedlist;

public class RotateDoublyLLByN {
	//https://www.geeksforgeeks.org/rotate-doubly-linked-list-n-nodes/
	static class Node{
		 String data;
		 Node next;
		 Node prev;
		 Node(String d) {data = d; next = null; prev = null;}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node1 = new Node("a");
		Node node2 = new Node("b");
		Node node3 = new Node("c");
		Node node4 = new Node("d");
		Node node5 = new Node("e");
		Node node6 = new Node("f");
		Node node7 = new Node("g");
		Node node8 = new Node("h");
		
		node1.prev = null;
		node1.next = node2;
		node2.prev = node1;
		node2.next = node3;
		node3.prev = node2;
		node3.next = node4;
		node4.prev = node3;
		node4.next = node5;
		node5.prev = node4;
		node5.next = node6;
		node6.prev = node5;
		node6.next = node7;
		node7.prev = node6;
		node7.next = node8;
		node8.prev = node7;
		rotate(node1, 4);
	}
	
	//O(n) Time | O(1) Space
	static void rotate(Node head, int N) {
		Node end = head;
	  	while(end.next != null){
	    	end = end.next;
	    }
	  	Node node = head;
	  	int count = 1;
	  	while(node!=null && count < N){
	    	node = node.next;
	      	count++;
	    }
	  	
		Node start = node.next;
	  	node.next = null;
	  	start.prev = null;
	  	end.next = head;
	  	head = start;
	  	
	  	Node n = head;
	  	while(n!=null) {
	  		System.out.print(n.data+" ");
	  		n = n.next;
	  	}
	}
}
