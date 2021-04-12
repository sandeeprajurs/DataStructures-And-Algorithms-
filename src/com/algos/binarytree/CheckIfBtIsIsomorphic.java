package com.algos.binarytree;

//https://practice.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1
//O(n) Time | O(h) Space
public class CheckIfBtIsIsomorphic {

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

	boolean isIsomorphic(Node n1, Node n2) {
		if (n1 == null && n2 == null)
			return true;
		if (n1 == null || n2 == null)
			return false;
		if (n1.data != n2.data)
			return false;

		return isIsomorphic(n1.left, n2.left) && isIsomorphic(n1.right, n2.right)
				|| isIsomorphic(n1.left, n2.right) && isIsomorphic(n1.right, n2.left);
	}

}
