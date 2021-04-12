package com.algos.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://practice.geeksforgeeks.org/problems/binary-tree-to-bst/1
//O(n) ST
public class BinaryTreeToBST {

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

	int count = 0;

	Node binaryTreeToBST(Node root) {
		List<Integer> array = new ArrayList<Integer>();
		inOrderTraversal(root, array);
		Collections.sort(array);
		count = 0;
		return constructBST(root, array);
	}

	Node constructBST(Node node, List<Integer> array) {
		if (node.left != null)
			constructBST(node.left, array);
		if (node != null) {
			node.data = array.get(count);
			count++;
		}
		if (node.right != null)
			constructBST(node.right, array);
		return node;
	}

	List<Integer> inOrderTraversal(Node node, List<Integer> array) {
		if (node.left != null)
			inOrderTraversal(node.left, array);
		array.add(node.data);
		if (node.right != null)
			inOrderTraversal(node.right, array);
		return array;
	}

}
