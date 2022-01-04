package com.algos.binarytree;

//O(n) Time | O(h) Space
//https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1
public class TransformToSumTree {
	
	static class Node{
		Node left;
		Node right;
		int data;
		
		public Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node node1 = new Node(10);
		Node node2 = new Node(-2);
		Node node3 = new Node(6);
		Node node4 = new Node(8);
		Node node5 = new Node(-4);
		Node node6 = new Node(7);
		Node node7 = new Node(5);
		
		node1.left = node2;
		node1.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.left = node6;
		node3.right = node7;
		System.out.println(transformToSumTree(node1));
		
	}
	
	//O(n) Time | O(d) Space
	public static int transformToSumTree(Node node) {
		if(node == null) return 0;
		int oldVal = node.data;
		node.data = transformToSumTree(node.left) + transformToSumTree(node.right); 
		return oldVal + node.data;
	}

}
