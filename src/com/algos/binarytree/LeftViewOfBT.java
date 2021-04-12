package com.algos.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


//O(n) ST
//https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
public class LeftViewOfBT {
	
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
	
	ArrayList<Integer> leftView(Node root)
    {   
        if(root == null) return new ArrayList<Integer>(); 
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int n = queue.size();
            
            for(int i=1; i<=n; i++){
                Node currNode = queue.poll();
                
                if(i == 1){
                    result.add(currNode.data);
                }
                
                if(currNode.left != null)
                    queue.add(currNode.left);
                    
                if(currNode.right != null)
                    queue.add(currNode.right);
            }
        }
        return result;
    }

}
