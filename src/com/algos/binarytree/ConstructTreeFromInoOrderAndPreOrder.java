package com.algos.binarytree;

//https://practice.geeksforgeeks.org/problems/construct-tree-1/1#
//O(n) ST
public class ConstructTreeFromInoOrderAndPreOrder {

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

	static int preStart;

	public static Node buildTree(int inorder[], int preorder[], int n) {
		preStart = 0;
		return buildTree(0, n - 1, inorder, preorder);
	}

	public static Node buildTree(int inStart, int inEnd, int[] inorder, int[] preorder) {
		if (preStart > preorder.length - 1 || inStart > inEnd)
			return null;

		Node node = new Node(preorder[preStart]);
		int idx = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (node.data == inorder[i])
				idx = i;
		}
		preStart += 1;
		node.left = buildTree(inStart, idx - 1, inorder, preorder);
		node.right = buildTree(idx + 1, inEnd, inorder, preorder);
		return node;
	}

}
