package com.algos.bst;

//https://practice.geeksforgeeks.org/problems/brothers-from-different-root/1
//O(nlogn) Time | O(n) Space
public class BrothersFromDifferentRoots {

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

	public static int countPairs(Node root1, Node root2, int x) {
		if (root1 == null)
			return 0;
		boolean found = search(root2, x - root1.data);
		int l = countPairs(root1.left, root2, x);
		int r = countPairs(root1.right, root2, x);
		if (found)
			return l + r + 1;
		return l + r;
	}

	public static boolean search(Node node, int key) {
		if (node == null)
			return false;
		if (key > node.data) {
			return search(node.right, key);
		} else if (key < node.data) {
			return search(node.left, key);
		} else if (key == node.data) {
			return true;
		}
		return false;
	}

}
