package com.algos.linkedlist;

//https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleElementOfLinkedList {
	public static void main(String[] args) {

	}

	// O(n) Time | O(1) Space
	public Node middleNode(Node head) {
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
