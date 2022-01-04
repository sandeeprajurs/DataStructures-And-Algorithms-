package com.algos.binarytree;


//https://practice.geeksforgeeks.org/problems/sum-tree/1
//O(n) Time | O(h) Space
public class SumTree {
	
	public static void main(String[] args) {
		Node node = new Node(10);
		node.left = new Node(20);
		node.left.left = new Node(10);
		node.left.right = new Node(10);
		node.right = new Node(30);
		System.out.println(isSumTree(node));
	}
	
	static class Node {
		Node left;
		Node right;
		int data;

		public Node(int value) {
			this.data = value;
		}
	}
	
	static class TreeInfo{
        boolean valid;
        int sum;
        
        public TreeInfo(boolean valid, int sum){
            this.valid = valid;
            this.sum = sum;
        }
    }
	
	static boolean isSumTree(Node root)
	{
	    if(root.left == null && root.right == null) return true;
        return getTreeInfo(root).valid;
	}
	
	
	static TreeInfo getTreeInfo(Node root) {
		if(root == null) return new TreeInfo(true, 0);
		if(root.left == null && root.right == null) return new TreeInfo(true, root.data);
		TreeInfo left = getTreeInfo(root.left);
		TreeInfo right = getTreeInfo(root.right);
		boolean sumTree = left.valid && right.valid && left.sum + right.sum == root.data;
		if(sumTree)
			return new TreeInfo(true, root.data + root.data);
		else
			return new TreeInfo(false, root.data);
	}
}
