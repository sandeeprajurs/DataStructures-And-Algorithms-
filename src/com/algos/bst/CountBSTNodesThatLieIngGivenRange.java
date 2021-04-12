package com.algos.bst;

//https://practice.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1
//O(n)Time | O(h) Space
public class CountBSTNodesThatLieIngGivenRange {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int d) {
			data = d;
		}
	}
	
	int getCount(Node root,int l, int h)
    {
        if(root == null)
            return 0;
        
        if(root.data >= l && root.data <= h){
            return 1 + getCount(root.left, l, h) + getCount(root.right, l, h);
        }
        else if(root.data < l){
            return getCount(root.right, l, h);
        }
        else{
            return getCount(root.left, l, h);
        }
    }

}
