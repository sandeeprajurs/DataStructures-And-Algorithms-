package com.algos.linkedlist;

public class SeggregateEvenAndOdd2 {
	
	//https://leetcode.com/problems/odd-even-linked-list/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	//O(n) Time | O(1) Space
	 public Node oddEvenList(Node head) {
		 if(head == null) return head;
		 
		 Node odd = head;
		 Node even = head.next;
		 Node evenHead = even;
		 
		 while(even != null && even.next != null) {
			 odd.next = even.next;
			 odd = odd.next;
			 even.next = odd.next;
			 even = even.next;
		 }
		 
		 odd.next = evenHead;
		 return head;
	 }

}
