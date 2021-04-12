package com.algos.linkedlist;

//https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
public class SortLinkedList012 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//O(N) Time | O(1) Space
    static Node segregate(Node head)
    {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        
        Node node = head;
        while(node != null){
            if(node.data == 0)
                count0 += 1;
            else if(node.data == 1)
                count1 += 1;
            else
                count2 += 1;
            node = node.next;
        }
        
        node = head;
        while(node != null){
            if(count0 > 0){
                node.data = 0;
                count0--;
            }
            else if(count1 > 0){
                node.data = 1;
                count1--;
            }
            else{
                node.data = 2;
                count2--;
            }
            node = node.next;
        }
        return head;
    }

}
