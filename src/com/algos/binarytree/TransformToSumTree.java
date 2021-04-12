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

	}
	
	//O(n) Time | O(d) Space
	public static int transformToSumTree(Node node) {
		if(node == null) return 0;
		int oldVal = node.data;
		node.data = transformToSumTree(node.left) + transformToSumTree(node.right); 
		return oldVal + node.data;
	}

}
