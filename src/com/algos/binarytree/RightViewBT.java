package com.algos.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//O(n) ST
//https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1
public class RightViewBT {

	static class Node {
		Node left;
		Node right;
		int data;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	ArrayList<Integer> rightView(Node node) {
		if (node == null)
			return new ArrayList<Integer>();
		Queue<Node> queue = new LinkedList<Node>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		queue.add(node);

		while (!queue.isEmpty()) {
			int n = queue.size();
			for (int i = 1; i <= n; i++) {
				Node currNode = queue.poll();
				if (i == n)
					list.add(currNode.data);

				if (currNode.left != null)
					queue.add(currNode.left);
				if (currNode.right != null)
					queue.add(currNode.right);
			}
		}
		return list;
	}

}
