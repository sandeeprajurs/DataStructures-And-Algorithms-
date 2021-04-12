package com.algos.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://practice.geeksforgeeks.org/problems/reverse-level-order-traversal/1
//O(n) ST
public class ReverseLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class Node {
		Node left;
		Node right;
		int data;

		public Node(int data) {
			this.data = data;
		}
	}

	public ArrayList<Integer> reverseLevelOrder(Node node) {
		List<Node> stack = new ArrayList<Node>();
		ArrayList<Integer> result = new ArrayList<Integer>();

		stack.add(node);
		while (stack.size() != 0) {
			Node currNode = stack.get(0);
			if (currNode.right != null)
				stack.add(currNode.right);
			if (currNode.left != null)
				stack.add(currNode.left);
			result.add(currNode.data);
			stack.remove(0);
		}
		Collections.reverse(result);
		return result;
	}

}
