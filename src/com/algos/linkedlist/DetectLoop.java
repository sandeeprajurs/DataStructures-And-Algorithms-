package com.algos.linkedlist;

public class DetectLoop {
	
	//https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//O(n) Time | O(1) Space
	public static boolean detectLoop(Node head){
        // Add code here
        Node slow = head.next;
        Node fast = head.next.next;
        while(slow != fast){
            if(fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
