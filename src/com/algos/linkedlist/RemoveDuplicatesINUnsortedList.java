package com.algos.linkedlist;

import java.util.HashSet;
import java.util.Set;

//https://practice.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1#
public class RemoveDuplicatesINUnsortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	//O(N) ST
	public Node removeDuplicates(Node head) 
    {   
        if(head.next == null) return head;
        Set<Integer> count = new HashSet<Integer>();
    
        Node prev = null;
        Node curr = head;
        while(curr != null){
            if(count.contains(curr.data)){
                prev.next = curr.next;
                curr = prev.next;
            }
            else{
                count.add(curr.data);
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

}