package com.algos.linkedlist;

import com.algos.linkedlist.ReverseDoublyLinkedList.Node;

//https://www.geeksforgeeks.org/find-pairs-given-sum-doubly-linked-list/
public class TwoSum {
	
	static class Node {
		 int data;
		    Node next;
		    Node prev;
		    Node(int d) {data = d; next = null; }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1= new Node(1);
		Node n2= new Node(2);
		Node n3= new Node(4);
		Node n4= new Node(5);
		Node n5= new Node(6);
		Node n6= new Node(8);
		Node n7= new Node(9);
		n1.next = n2;
		n2.prev = n1;
		n2.next = n3;
		n3.prev = n2;
		n3.next = n4;
		n4.prev = n3;
		n4.next = n5;
		n5.prev = n4;
		n5.next = n6;
		n6.prev = n5;
		n6.next = n7;
		n7.prev = n6;
		pairSum(n1, 7);
	}
	
	//O(n) Time | O(1) Space
	static void pairSum( Node head, int x) 
	{ 
		Node end = head;
	  	while(end.next!=null){
	  		end = end.next;
	    }
	  	Node start = head;
	  	boolean found = false;
	  	while(start != end){
	      	int potentialSUm = start.data + end.data;
	    	if(potentialSUm > x)
	          end = end.prev;
	        else if(potentialSUm < x)
	          start = start.next;
	        else{
	          found = true;
	          System.out.println( "(" + start.data + ", "+ end.data + ")" ); 
	          start = start.next;
	          end = end.prev;
	        }
	    }
	  	if(found == false)
	  		System.out.println("No pair found"); 
	} 

}
