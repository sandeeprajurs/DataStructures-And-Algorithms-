package com.algos.binarytree;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
//O(n) ST
public class BoundryTraversalOfBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class Node {
		Node left;
		Node right;
		int data;

		public Node(int value) {
			this.data = value;
		}
	}

	public void getAllLeftNodes(Node node, ArrayList<Integer> result) {
		if (node == null)
			return;
		if (node.left != null) {
			result.add(node.data);
			getAllLeftNodes(node.left, result);
		} else if (node.right != null) {
			result.add(node.data);
			getAllLeftNodes(node.right, result);
		}
	}

	public void getAllLeafNodes(Node node, ArrayList<Integer> result) {
		if (node == null)
			return;
		getAllLeafNodes(node.left, result);
		if (node.left == null && node.right == null)
			result.add(node.data);
		getAllLeafNodes(node.right, result);
	}

	public void getAllRightNodes(Node node, ArrayList<Integer> result) {
		if (node == null)
			return;
		if (node.right != null) {
			getAllRightNodes(node.right, result);
			result.add(node.data);
		} else if (node.left != null) {
			getAllRightNodes(node.left, result);
			result.add(node.data);
		}
	}

	ArrayList<Integer> printBoundary(Node node) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(node.data);
		getAllLeftNodes(node.left, result);
		getAllLeafNodes(node, result);
		getAllRightNodes(node.right, result);
		return result;
	}

}
