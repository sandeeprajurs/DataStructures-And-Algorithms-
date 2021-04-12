package com.algos.linkedlist;

import com.algos.linkedlist.RotateDoublyLLByN.Node;

//https://www.geeksforgeeks.org/reverse-doubly-linked-list-groups-given-size/
public class ReverseDoublyLLByGroupsOfGivenSize {

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
		Node n=reverse(node1, 4);
		while(n!=null) {
	  		System.out.print(n.data+" ");
	  		n = n.next;
	  	}
	}
	
	//O(n) Time | O(1) Space
	public static Node reverse(Node head, int k) {
		Node prev = null;
		Node curr = head;
		curr.prev = null;
		int count = 0;
		while(curr != null && count < k) {
			prev = curr.prev;
			curr.prev = curr.next;
			curr.next = prev;
			curr = curr.prev;
			count++;
		}
		
		if(curr != null)
			head.next = reverse(curr, k);
		return prev.prev;
	}

}
