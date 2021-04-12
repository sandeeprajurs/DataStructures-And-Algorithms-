package com.algos.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/
//O(n) ST
public class DiagonalTraversalOfBT {

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
	
	public static List<Integer> diagonalTraversal(Node node) {
		Queue<Node> stack = new LinkedList<Node>();
		List<Integer> result = new ArrayList<Integer>();
		while (!stack.isEmpty() || node!= null) {
			if (node == null) {
				node = stack.poll();
			}

			while (node != null) {
				result.add(node.data);
				if (node.left != null)
					stack.add(node.left);
				node = node.right;
			}
		}
		return result;
	}

}
