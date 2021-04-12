package com.algos.linkedlist;

//https://practice.geeksforgeeks.org/problems/circular-linked-list/1
public class CheckIfItIsACircularLinkedList {
	
	//O(N) Time | O(1) Space
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	boolean isCircular(Node head)
    {
        Node startPoint = head;
	    Node node = head.next;
	    while(node!= null){
	        if(node == startPoint) return true;
	        node = node.next;
	    }
	    return false;
    }

}
