package com.algos.linkedlist;

public class DeleteNodeInCircularLinkedList {
	
	//https://www.geeksforgeeks.org/deletion-circular-linked-list/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node = new Node(10);
		Node node1 = new Node(8);
		Node node2 = new Node(7);
		Node node3 = new Node(5);
		Node node4 = new Node(2);
		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node;
		Node res = deleteNodeInCircularLL(node, 5);
		Node head = res;
		do {
			System.out.println(res.data);
			res = res.next;
		}
		while(res!=head);
	}
	
	//O(n) Time | O(1) Space
	public static Node deleteNodeInCircularLL(Node head, int key) {
		Node prev = new Node(0);
		Node curr = head;
		while(curr.data != key) {
			if(curr.next == head) return head;
			prev = curr;
			curr = curr.next;
		}
		
		if(curr == head && curr.next == head) {
			head = null;
			return head;
		}
		
		if(curr == head) {
			prev = head;
			while(prev.next != head) {
				prev = prev.next;
			}
			head = curr.next;
			prev.next = head;
		}
		else if(curr.next == head)
			prev.next = head;
		else
			prev.next = curr.next;
		
		return head;
	}

}
