package com.algos.linkedlist;

public class RemoveLoopFromLinkedList {
	
	//https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1#
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 //O(N) Time | O(1) Space
	public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        Node slowprev = head;
        Node slow = head.next;
        Node fast = head.next.next;
        while(slow != fast){
            if(fast == null || fast.next == null) return;
            slowprev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = head;
        while(slow != fast){
            slowprev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        
       slowprev.next = null;
       
    }

}
