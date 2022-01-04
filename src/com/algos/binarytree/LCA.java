package com.algos.binarytree;

import com.algos.binarytree.DuplicateSubTreeInBT.Node;

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
		Node node1 = new Node(3);
		Node node2 = new Node(6);
		Node node3 = new Node(8);
		Node node4 = new Node(2);
		Node node5 = new Node(11);
		Node node6 = new Node(9);
		Node node7 = new Node(5);
		Node node8 = new Node(13);
		Node node9 = new Node(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node5.left = node6;
		node5.right = node7;
		
		node3.right = node8;
		node8.left = node9;
		Node node = lca(node1, 9, 7);
		System.out.println(node);
	}
	
	static Node lca(Node root, int n1,int n2)
	{
		if(root == null) return null;;
		
		if(root.data == n1 || root.data == n2)
		    return root;
		
		Node l =lca(root.left, n1, n2);
		Node r =lca(root.right, n1, n2);
	    
	    if(l!= null && r!= null) return root;
	    
	    return l!=null? l: r;
	    
	}

}
