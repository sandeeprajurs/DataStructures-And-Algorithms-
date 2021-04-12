package com.algos.binarytree;

import java.util.ArrayList;
import java.util.List;

//https://practice.geeksforgeeks.org/problems/level-order-traversal/1
//O(n) ST
public class LevelOrderTraversal_BFS {
	
	static class Node{
		Node left;
		Node right;
		int data;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static ArrayList <Integer> levelOrder(Node node) 
    {
        List<Node> stack = new ArrayList<Node>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        stack.add(node);
        while(stack.size() != 0){
            Node currNode = stack.get(0);
            if(currNode.left != null)
                stack.add(currNode.left);
            if(currNode.right != null)
                stack.add(currNode.right);
            result.add(stack.get(0).data);
            stack.remove(0);
        }
        return result;
    }

}
