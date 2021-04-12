package com.algos.bst;

//https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1
//O(h) Time | O(1) Space
public class LowestCommonAncestorInABST {
	
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int d) {
			data = d;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Node LCA(Node root, int n1, int n2)
	{   
	    if(n1 > n2){
	        int temp = n1;
	        n1 = n2;
	        n2 = temp;
	    }
	    Node node = root;
        while(node!=null){
            if(n1 <= node.data && n2 >= node.data)
                return node;
            else if(n1 > node.data)
                node = node.right;
            else if(n2 < node.data)
                node = node.left;
        }
        return null;
    }

}
