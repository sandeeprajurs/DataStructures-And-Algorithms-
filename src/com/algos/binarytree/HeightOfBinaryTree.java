package com.algos.binarytree;

//https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1#
//O(n) Time | O(h) height
public class HeightOfBinaryTree {

	public static void main(String[] args) {

	}

	static class Node {
		Node left;
		Node right;
		int value;

		public Node(int value) {
			this.value = value;
		}
	}

	int height(Node node) {
		return getHeight(node, 1);
	}

	int getHeight(Node node, int height) {
		if (node == null)
			return 0;
		int left = getHeight(node.left, height);
		int right = getHeight(node.right, height);
		height = Math.max(left, right) + 1;
		return height;
	}

}
