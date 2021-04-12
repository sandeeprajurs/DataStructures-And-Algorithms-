package com.algos.binarytree;


//O(n) Time | O(h) Space
//https://www.geeksforgeeks.org/find-largest-subtree-sum-tree/
public class LargestSubTreeSum {

	public static void main(String[] args) {
		Node node = new Node(1);
		node.left = new Node(-2);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		
		node.right = new Node(3);
		node.right.left = new Node(-6);
		node.right.right = new Node(2);
		System.out.println(findLargestSubtreeSum(node)[1]);
	}
	
	static class Node {
		Node left;
		Node right;
		int data;

		public Node(int value) {
			this.data = value;
		}
	}
	
	public static int[] findLargestSubtreeSum(Node node){
		if(node == null) return new int[]{0, 0};
		int[] left = findLargestSubtreeSum(node.left);
		int[] right = findLargestSubtreeSum(node.right);
	  	int subTreeSum =  left[0] + right[0] + node.data;
		int maxSumSubTree  = Math.max(subTreeSum, Math.max(left[1], right[1]));
		return new int[]{subTreeSum, maxSumSubTree};
	}

}
