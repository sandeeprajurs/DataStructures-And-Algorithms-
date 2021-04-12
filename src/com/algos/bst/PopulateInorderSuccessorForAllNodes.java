package com.algos.bst;

//https://practice.geeksforgeeks.org/problems/populate-inorder-successor-for-all-nodes/1

//O(n)ST
public class PopulateInorderSuccessorForAllNodes {

	static class Node {
		int data;
		Node left, right, next;

		Node(int d) {
			data = d;
			left = right = next = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Node prev = null;

	public static void populateNext(Node tree) {
		if (tree.left != null)
			populateNext(tree.left);
		if (prev != null) {
			prev.next = tree;
		}
		prev = tree;
		if (tree.right != null)
			populateNext(tree.right);

	}

}
