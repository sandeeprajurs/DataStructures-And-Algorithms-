package com.algos.linkedlist;

//https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1#
public class FlattenLinkedList {
	
	static class Node {
		int data;
		Node next;
		Node bottom;
		
		Node(int data){
			this.data = data;
		}
	}
	
	//O(n) Time | O(1) Space
	public static Node merge(Node a, Node b) {
		if(a == null) return b;
		if(b == null) return a;
		
		Node result;
		if(a.data < b.data) {
			result = a;
			result.bottom = merge(a.bottom, b);
		}
		else {
			result = b;
			result.bottom = merge(a, b.bottom);
		}
		return result;
	}
	
	public static Node flattenLinkedList(Node root) {
		if(root == null || root.next == null)
			return root;
		root.next = flattenLinkedList(root.next);
		root = merge(root, root.next);
		return root;
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(5);
		Node n2 = new Node(7);
		Node n3 = new Node(8);
		Node n4 = new Node(30);
		Node n5 = new Node(10);
		Node n6 = new Node(19);
		Node n7 = new Node(22);
		Node n8 = new Node(50);
		Node n9 = new Node(28);
		
		n1.next = n5;
		n5.next = n6;
		n6.next = n9;
		
		n1.bottom = n2;
		n2.bottom = n3;
		n3.bottom = n4;
		
		n6.bottom = n7;
		n7.bottom = n8;
		
		Node node = flattenLinkedList(n1);
		while(node != null) {
			System.out.println(node.data);
			node = node.bottom;
		}
	}
}
