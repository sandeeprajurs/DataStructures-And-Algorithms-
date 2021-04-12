package com.algos.linkedlist;

//https://practice.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1
public class ReverseDoublyLinkedList {
	
	static class Node {
		 int data;
		    Node next;
		    Node prev;
		    Node(int d) {data = d; next = null; }
	}

	public static void main(String[] args) {
		Node n1 = new Node(3);
		Node n2 = new Node(4);
		Node n3 = new Node(5);
		n1.next = n2;
		n2.prev = n1;
		n2.next = n3;
		n3.prev = n2;
		
		reverseDLL(n1);
	}
	
	//O(n) Time | O(1) Space
	public static Node reverseDLL(Node  head)
	{
	    Node curr = head;
	    Node prev = null;
	    while(curr != null){
	    	prev = curr.prev;
	    	curr.prev = curr.next;
	    	curr.next = prev;
	    	curr = curr.prev;
	    }
	    Node n = prev.prev;
	    while(n!=null) {
	    	System.out.print(n.data+" ");
	    	n=n.next;
	    }
	    
	    return prev.prev;
	}

}
