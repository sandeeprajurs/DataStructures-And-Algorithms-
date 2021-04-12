package com.algos.binarytree;

//https://www.geeksforgeeks.org/kth-ancestor-node-binary-tree-set-2/
//O(n) Time | O(h) space
public class KthAncestorInBT {

	public static void main(String[] args) {
		Node node = new Node(1);
		node.left = new Node(2);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.right = new Node(3);
		kThAncestor(node, 4);
		System.out.println(ancestor);
	}
	
	static class Node {
		Node left;
		Node right;
		int data;

		public Node(int value) {
			this.data = value;
		}
	}
	
	//k denotes to find 2nd ancestor
	static int k = 2;
	static int ancestor = -1;

	public static Node kThAncestor(Node node, int val) {
		if(node == null) return null;
		if(node.data == val || kThAncestor(node.left, val) != null || kThAncestor(node.right, val) != null) {
			if(k > 0)
				k--;
			else {
				ancestor = node.data;
				return null;
			}
			return node;
		}
		return null;
	}

}
