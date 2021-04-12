package com.algos.binarytree;

import java.util.ArrayList;
import java.util.Stack;


//O(n)
//https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1
public class ZIgZagTraversal {

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

	static ArrayList<Integer> zigZagTraversal(Node root) {
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		s1.push(root);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			while (!s1.isEmpty()) {
				Node currNode = s1.pop();
				if (currNode != null) {
					result.add(currNode.data);
					s2.push(currNode.left);
					s2.push(currNode.right);
				}

			}

			while (!s2.isEmpty()) {
				Node currNode = s2.pop();
				if (currNode != null) {
					result.add(currNode.data);
					s1.push(currNode.right);
					s1.push(currNode.left);
				}
			}
		}
		return result;
	}

}
