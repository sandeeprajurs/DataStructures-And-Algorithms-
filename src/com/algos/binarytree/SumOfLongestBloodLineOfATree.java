package com.algos.binarytree;

//O(n) Time | O(h) Height
//https://practice.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1
public class SumOfLongestBloodLineOfATree {

	public static void main(String[] args) {

	}
	
	static class Node {
		Node left;
		Node right;
		int data;

		public Node(int value) {
			this.data = value;
		}
	}
	
	public int sumOfLongRootToLeafPath(Node root)
    {
        int[] maxPathSum = findMaxSumBranch(root);
        return maxPathSum[0];
    }
    
    public int[] findMaxSumBranch(Node node){
        if(node == null) return new int[]{0, 0};
        int[] left = findMaxSumBranch(node.left);
        int[] right = findMaxSumBranch(node.right);
        int leftSum = left[0];
        int rightSum = right[0];
        int leftNodes = left[1];
        int rightNodes = right[1];
        int maxSum = 0;
        if(leftSum <= rightSum){
            if(leftNodes > rightNodes)
                maxSum = leftSum;
            else
                maxSum = rightSum;
        }
        else if(rightSum <= leftSum){
            if(rightNodes > leftNodes)
                maxSum = rightSum;
            else
                maxSum = leftSum;
        }
        int maxNode = Math.max(leftNodes, rightNodes);
        int value = node.data;
        int maxPathSum = Math.max(maxSum+value, value);
        return new int[]{maxPathSum, maxNode+1};
    } 

}
