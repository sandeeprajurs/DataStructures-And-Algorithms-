package com.algos.binarytree;


public class BalancedBT {
	
	//https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
	//O(n) Time | O(h) Space
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
	
	static boolean isBalanced;
    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root)
    {
	  isBalanced = true;
	  isBalanced(root, 0);
	  return isBalanced;
    }
    
    int isBalanced(Node root, int height){
        if(root == null) return 0;
        int left = isBalanced(root.left, height);
        int right = isBalanced(root.right, height);
        if(Math.abs(left - right) > 1)
            isBalanced = false;
        return Math.max(left, right) + 1;
    }

}
