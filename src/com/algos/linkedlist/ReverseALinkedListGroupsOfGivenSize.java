package com.algos.linkedlist;

//https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1#
public class ReverseALinkedListGroupsOfGivenSize {
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(2);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		Node res=reverse(n1, 4);
		//print result
		while(res != null) {
			System.out.print(" "+res.data);
			res = res.next;
		}
	}
	
	//O(n)ST
	public static Node reverse(Node node, int k) {
		Node prev = null;
		Node curr = node;
		Node temp = null;
		int count = 0;
		while(curr != null && count<k) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		
		if(curr!=null) {
			node.next = reverse(temp, k);
		}
		return prev;
	}
}
