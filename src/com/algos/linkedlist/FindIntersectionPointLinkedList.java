package com.algos.linkedlist;

//https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1#
public class FindIntersectionPointLinkedList {
	
	public static void main(String[] args) {
		Node n1 = new Node(4);
		Node n2 = new Node(1);
		Node n3 = new Node(8);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		
		Node n11 = new Node(5);
		Node n12 = new Node(6);
		Node n13 = new Node(1);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		n11.next = n12;
		n12.next = n13;
		n13.next = n3;
		
		System.out.println(intersectPoint(n1, n11));
	}
	
	//O(n) Time | O(1) Space
	public static int intersectPoint(Node head1, Node head2) {
		Node p1 = head1;
		Node p2 = head2;
		
		if(p1 == null || p2 == null)
			return -1;
		
		while(p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
			
			if(p1 == p2)
				return p1.data;
			if(p1 == null)
				p1 = head2;
			if(p2 == null)
				p2 = head1;
		}
		return p1.data;
	}

}
