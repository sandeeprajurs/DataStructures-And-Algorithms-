package com.algos.bst;

//https://practice.geeksforgeeks.org/problems/minimum-element-in-bst/1
public class FindMinValueInBST {
	
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
	
	//O(h) ST
	int minValue(Node node)
    {
        if(node.left != null)
             return minValue(node.left);
        else
            return node.data;
            
    }

}
