package com.algos.linkedlist;

import com.algos.linkedlist.TwoSum.Node;

//https://www.geeksforgeeks.org/count-triplets-sorted-doubly-linked-list-whose-sum-equal-given-value-x/
public class ThreeNumSum {
	
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
		System.out.println(countTriplets(n1, 17));
	}
	
	//O(n^2) Time | O(1) Space
	static int countTriplets(Node head, int x)
	{
		Node endNode = head;
	  	while(endNode.next != null){
	  		endNode = endNode.next;
	    }
	  	
	  	Node prev = head;
	  	Node start = prev.next;
	  	Node end = endNode;
	  	int count = 0;
	  	while(prev!= null && prev.next != null){
	  		while(prev!=null && start != end && end.next != start){
	    		int potentialSum =  prev.data + (start.data + end.data);
	          	if(potentialSum < x){
	              start = start.next;
	            }
	          	else if(potentialSum > x){
	              end = end.prev;
	            }
	          	else{
	              	count++;
	              	System.out.println(prev.data+"---------"+start.data +"---------"+end.data);
	             	start = start.next;
	      			end =  end.prev; 
	            }
	    	} 
	      	prev = prev.next;
	      	start = prev.next;
	      	end = endNode;
	    }
	  	return count;
	}

}
