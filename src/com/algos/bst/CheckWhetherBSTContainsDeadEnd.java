package com.algos.bst;

//https://practice.geeksforgeeks.org/problems/check-whether-bst-contains-dead-end/1
//O(n) ST
public class CheckWhetherBSTContainsDeadEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int d) {
			data = d;
		}
	}

	public static boolean isDeadEnd(Node root) {
		return isDeadEnd(root, 1, Integer.MAX_VALUE);
	}

	public static boolean isDeadEnd(Node node, int min, int max) {
		if (node == null)
			return false;
		if (min == max)
			return true;
		return isDeadEnd(node.left, min, node.data - 1) || isDeadEnd(node.right, node.data + 1, max);
	}

}
