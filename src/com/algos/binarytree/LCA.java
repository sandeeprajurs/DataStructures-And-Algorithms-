package com.algos.binarytree;


//https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1
//O(n) Time | O(h) Space
public class LCA {
	
	static class Node {
		Node left;
		Node right;
		int data;

		public Node(int value) {
			this.data = value;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Node lca(Node root, int n1,int n2)
	{
		if(root.data > n1 && root.data > n2)
            return lca(root.left, n1, n2);
        else if(root.data < n1 && root.data < n2)
            return lca(root.right, n1, n2);
        return root;
	}

}
