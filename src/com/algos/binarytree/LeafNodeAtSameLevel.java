package com.algos.binarytree;

//https://practice.geeksforgeeks.org/problems/leaf-at-same-level/1
//O(n) Time | O(h) Space
public class LeafNodeAtSameLevel {

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
	
	boolean isAtSameLevel;
    int prevLeafNodeHeight;
    boolean check(Node root)
    {
	    isAtSameLevel = true;
	    prevLeafNodeHeight = -1;
	    checkLeafNodeAtSameLevel(root, 0);
	    return isAtSameLevel;
    }
    
    void checkLeafNodeAtSameLevel(Node node, int h){
        if(isAtSameLevel == false) return; 
        if(node == null) return;
          
        if(node.left == null && node.right == null){
            if(prevLeafNodeHeight == -1){
                prevLeafNodeHeight = h;
                return;
            }
            else{
                if(prevLeafNodeHeight != h){
                    isAtSameLevel = false;
                    return;
                }       
            }
        }
        
        checkLeafNodeAtSameLevel(node.left, h+1);
        checkLeafNodeAtSameLevel(node.right, h+1);
    }

}
