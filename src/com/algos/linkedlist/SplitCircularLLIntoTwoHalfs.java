package com.algos.linkedlist;

public class SplitCircularLLIntoTwoHalfs {
	//https://practice.geeksforgeeks.org/problems/split-a-circular-linked-list-into-two-halves/1#
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	//O(n) Time | O(1)Space
	void splitList(Node head, Node last, Node head1, Node head2)
    {
        Node slow = head.next;
        Node slowPrev = head;
        Node fast = head.next.next;
        Node fastPrev = head;
        while(fast != head && fast.next != head){
            slowPrev = slow;
            slow = slow.next;
            fastPrev  = fast;
            fast = fast.next.next;
        }
        
        Node secondHalfStartPoint = null;
        if(fast.next == head){
            secondHalfStartPoint = slow.next;
            slow.next = head;
            last.next = secondHalfStartPoint;
        }
        else if(fast == head){
            secondHalfStartPoint = slowPrev.next;
            slowPrev.next = head;
            last.next = secondHalfStartPoint;
        }
        head1 = head;
        head2 = secondHalfStartPoint;
    }

}
