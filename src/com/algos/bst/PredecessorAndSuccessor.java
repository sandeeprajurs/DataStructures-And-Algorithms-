package com.algos.bst;

//https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1
//O(h) Time | O(1) Space
public class PredecessorAndSuccessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Res
    {
        Node pre = null;
        Node succ = null;
    }
	
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int d) {
			data = d;
		}
	}
	
	 public static void findPreSuc(Node root, Res p, Res s, int key)
	    {
	       // add your code here
	       Node node = root;
	       predecessor(node, p, key);
	       sussessor(node, s, key);
	    }
	    
	    public static void predecessor(Node node, Res p, int key){
	        Node store = null;
	        while(node!=null){
	            if(key < node.data)
	                node = node.left;
	            else if(key > node.data){
	                store = node;
	                node = node.right;
	            }
	            else
	                break;
	        }
	        
	        if(node == null || node.left == null)
	            p.pre = store;
	        else{
	            p.pre = findMax(node.left);
	        }
	    }
	    
	    public static void sussessor(Node node, Res s, int key){
	        Node store = null;
	        while(node!=null){
	            if(key < node.data){
	                store = node;
	                node = node.left;
	            }
	            else if(key > node.data)
	                node = node.right;
	            else
	                break;
	        }
	        
	        if(node == null || node.right == null)
	            s.succ = store;
	        else{
	            s.succ = findMin(node.right);
	        }
	    }
	    
	    public static Node findMin(Node node){
	        if(node.left == null)
	            return node;
	        return findMin(node.left);
	    }
	    
	    public static Node findMax(Node node){
	        if(node.right == null)
	            return node;
	        return findMax(node.right);
	    }

}
