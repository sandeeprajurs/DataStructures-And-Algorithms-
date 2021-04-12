package com.algos.linkedlist;

//https://practice.geeksforgeeks.org/problems/intersection-of-two-sorted-linked-lists/1
public class IntersectionOfTwoSortedLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// O(n+m) ST
	public static Node findIntersection(Node head1, Node head2) {
		Node head = null;
		Node tail = null;
		Node ll1 = head1;
		Node ll2 = head2;
		while (ll1 != null && ll2 != null) {
			if (ll1.data > ll2.data) {
				ll2 = ll2.next;
			} else if (ll1.data < ll2.data) {
				ll1 = ll1.next;
			} else {
				if (head == null) {
					head = new Node(ll1.data);
					tail = head;
				} else {
					tail.next = new Node(ll1.data);
					tail = tail.next;
				}
				ll1 = ll1.next;
				ll2 = ll2.next;
			}
		}
		return head;
	}

}
