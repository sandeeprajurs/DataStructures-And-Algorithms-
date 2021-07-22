package com.algos.stack.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/check-if-all-levels-of-two-trees-are-anagrams-or-not/
public class AnagramsOrNot {

	static class Node {
		Node left, right;
		int data;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {
	}

	static boolean areAnagrams(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;

		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();
		q1.add(root1);
		q2.add(root2);
		while (true) {
			int n1 = q1.size();
			int n2 = q2.size();

			if (n1 != n2)
				return false;

			if (n1 == 0)
				break;
			ArrayList<Integer> curr_level1 = new ArrayList<>();
			ArrayList<Integer> curr_level2 = new ArrayList<>();

			while (n1 > 0) {
				Node node1 = q1.poll();
				Node node2 = q2.poll();

				if (node1.left != null)
					q1.add(node1.left);
				if (node1.right != null)
					q1.add(node1.right);
				n1--;

				if (node2.left != null)
					q2.add(node2.left);
				if (node2.right != null)
					q2.add(node2.right);

				curr_level1.add(node1.data);
				curr_level2.add(node2.data);
			}
			Collections.sort(curr_level1);
			Collections.sort(curr_level2);

			if (!curr_level1.equals(curr_level2))
				return false;
		}
		return true;
	}
}
