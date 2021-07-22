package com.algos.linkedlist;

//https://practice.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1
public class DeleteNodeWhichHaveGreaterValueInRight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	//O(n) Time | O(1) Space
	Node compute(Node head) {
		// your code here
		Node revNode = reverse(head);
		Node prev = revNode;
		Node node = prev.next;
		int max = prev.data;
		while (node != null) {
			if (node.data < max) {
				prev.next = node.next;
				node = prev.next;
			} else {
				max = node.data;
				prev = node;
				node = node.next;
			}
		}
		return reverse(revNode);
	}

	Node reverse(Node head) {
		Node prev = null;
		Node curr = head;
		while (curr != null) {
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}

}
