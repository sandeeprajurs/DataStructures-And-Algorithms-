package com.algos.linkedlist;

//https://practice.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1#
public class SeggregateEvenAndOdd1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//O(n) ST 
	Node divide(int N, Node head){
        Node evenStartingNode = null;
        Node evenEndNode = null;
        Node oddStartingNode = null;
        Node oddEndNode = null;
        Node node = head;
        
        while(node != null){
            int element = node.data;
            if(element % 2 == 0){
                if(evenStartingNode == null){
                    evenStartingNode = node;
                    evenEndNode = evenStartingNode;
                }
                else{
                    evenEndNode.next = node;
                    evenEndNode = evenEndNode.next;
                }
            }
            else{
                if(oddStartingNode == null){
                    oddStartingNode = node;
                    oddEndNode = oddStartingNode;
                }
                else{
                    oddEndNode.next = node;
                    oddEndNode = oddEndNode.next;
                }
            }
            node = node.next;
        }
        if(evenStartingNode == null || oddStartingNode == null)
            return head;
            
        evenEndNode.next = oddStartingNode;
        oddEndNode.next = null;
        return evenStartingNode;
    }

}
