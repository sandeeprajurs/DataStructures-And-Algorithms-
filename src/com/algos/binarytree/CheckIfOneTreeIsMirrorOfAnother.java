package com.algos.binarytree;

//https://practice.geeksforgeeks.org/problems/check-mirror-in-n-ary-tree/0
//O(n)Time | O(h) Space
public class CheckIfOneTreeIsMirrorOfAnother {

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
	
	boolean areMirror(Node a, Node b)
	{
		if(a== null && b==null) return true;
      	if(a== null || b==null) return false;
      	
      	if(a.data != b.data)
          return false;
      	return areMirror(a.left, b.right) && areMirror(a.right, b.left);
	}

}
