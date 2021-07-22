package com.algos.binarytree;

import com.algos.binarytree.TopViewOfBT.Node;

//O(n) Time | O(h) Height
//https://practice.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1
public class SumOfLongestBloodLineOfATree {

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(7);
		Node n3 = new Node(6);
		Node n4 = new Node(10);
		Node n5 = new Node(2);
		Node n6 = new Node(9);
		Node n7 = new Node(3);
		Node n8 = new Node(8);
		Node n9 = new Node(5);
		Node n10 = new Node(4);

		n1.right = n2;

		n2.left = n3;
		n2.right = n4;

		n3.left = n5;
		n4.left = n6;

		n5.right = n7;
		n6.left = n8;

		n7.right = n9;

		n9.left = n10;
		SumOfLongestBloodLineOfATree slt = new SumOfLongestBloodLineOfATree();
		slt.sumOfLongRootToLeafPath(n1);
		System.out.println(slt.currSum);

	}

	static class Node {
		Node left;
		Node right;
		int data;

		public Node(int value) {
			this.data = value;
		}
	}

	int currSum;
	int currHeight;
	public int sumOfLongRootToLeafPath(Node root) {
		maxSumBranch(root, root.data, 0);
		return currSum;
	}

	public void maxSumBranch(Node node, int sum, int height) {
		if (currHeight <= height && currSum < sum) {
			currSum = sum;
			currHeight = height;
		}

		if (node.left != null)
			maxSumBranch(node.left, sum + node.left.data, height + 1);
		if (node.right != null)
			maxSumBranch(node.right, sum + node.right.data, height + 1);
	}

//	public int sumOfLongRootToLeafPath(Node root) {
//		int[] maxPathSum = findMaxSumBranch(root);
//		return maxPathSum[0];
//	}

//    public int[] findMaxSumBranch(Node node){
//        if(node == null) return new int[]{0, 0};
//        int[] left = findMaxSumBranch(node.left);
//        int[] right = findMaxSumBranch(node.right);
//        int leftSum = left[0];
//        int rightSum = right[0];
//        int leftNodes = left[1];
//        int rightNodes = right[1];
//        int maxSum = 0;
//        if(leftSum <= rightSum){
//            if(leftNodes > rightNodes)
//                maxSum = leftSum;
//            else
//                maxSum = rightSum;
//        }
//        else if(rightSum <= leftSum){
//            if(rightNodes > leftNodes)
//                maxSum = rightSum;
//            else
//                maxSum = leftSum;
//        }
//        int maxNode = Math.max(leftNodes, rightNodes);
//        int value = node.data;
//        int maxPathSum = Math.max(maxSum+value, value);
//        return new int[]{maxPathSum, maxNode+1};
//    } 

}
