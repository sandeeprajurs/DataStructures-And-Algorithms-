package com.algos.stack.queue;

import java.util.LinkedList;
import java.util.Queue;

//https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1
//O(n)ST
public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(FirstNonRepeating("ftvbwnimpvvbfvtot"));
	}
	
	 public static String FirstNonRepeating(String A) {
		 int[] repeated = new int[256];
		 Queue<Character> queue = new LinkedList<Character>();
		 StringBuilder str = new StringBuilder();
		 for(int i=0; i<A.length(); i++) {
			 char c = A.charAt(i);
			 queue.add(c);
			 repeated[c] += 1;
			 while(!queue.isEmpty() && repeated[queue.peek()] > 1){
				 queue.poll();
			 }
			 
			 if(queue.isEmpty()) {
				 str.append("#");
			 }
			 else {
				 str.append(queue.peek());
			 }
		 }
		 return str.toString();
	 }

}
