package com.algos.linkedlist;

public class GetNthNodeFromLast {
	//https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1#
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//O(n) Time | O(1) Space
	 int getNthFromLast(Node head, int n)
	    {
	    	int length = getLength(head);
	    	int N = (length - n)+1;
	    	if(N < 0)
	    	    return -1;
	    	return getElementAtN(head, N);
	    }
	    
	    int getElementAtN(Node head, int n){
	        Node node = null;
	        Node nextNode = head;
	        int count = 0;
	        while(nextNode!= null){
	            if(count == n) break;
	            node = nextNode;
	            nextNode = nextNode.next;
	            count++;
	        }
	        if(node == null) return -1;
	        return node.data;
	    }
	    
	    int getLength(Node head){
	        Node node = head;
	        int count=0;
	        while(node!= null){
	            node = node.next;
	            count++;
	        }
	        return count;
	    }

}
