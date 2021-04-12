package com.algos.stack.queue;

import java.util.*;

//O(n) ST
//https://www.geeksforgeeks.org/check-if-all-levels-of-two-trees-are-anagrams-or-not/
public class CheckAllLevelOfTreeAreAnagrams {

	public static void main(String[] args) {
		Node root1 = new Node(1);
		root1.left = new Node(3);
		root1.right = new Node(2);
		root1.right.left = new Node(5);
		root1.right.right = new Node(4);
//		root1.right.right.left = new Node(6);
		root1.right.right.right = new Node(7);

		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.left.left = new Node(4);
		root2.left.right = new Node(5);
		
//		root2.left.left.left = new Node(7);
		root2.left.left.right = new Node(6);

		System.out.println(areAnagrams(root1, root2) ? "Yes" : "No");
	}

	static class Node {
		Node left, right;
		int data;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public static boolean areAnagrams(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;

		java.util.Queue<Node> q1 = new LinkedList<Node>();
		java.util.Queue<Node> q2 = new LinkedList<Node>();
		q1.add(root1);
		q2.add(root2);

		ArrayList<Integer> curr_level1 = new ArrayList<>();
		ArrayList<Integer> curr_level2 = new ArrayList<>();

		while (!q1.isEmpty() || !q2.isEmpty()) {
			if(!q1.isEmpty()) {
				Node node1 = q1.poll();
				if (node1.left != null)
					q1.add(node1.left);
				if (node1.right != null)
					q1.add(node1.right);
				curr_level1.add(node1.data);
			}
			else
				return false;
			
			if(!q2.isEmpty()) {
				Node node2 = q2.poll();
				if (node2.left != null)
					q2.add(node2.left);
				if (node2.right != null)
					q2.add(node2.right);
				curr_level2.add(node2.data);
			}
			else
				return false;
		}
				
		if(curr_level1.size() != curr_level2.size())
			return false;

		Collections.sort(curr_level1);
		Collections.sort(curr_level2);

		if (!curr_level1.equals(curr_level2))
			return false;
		return true;
	}
}
