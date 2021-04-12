package com.algos.linkedlist;

import java.util.ArrayList;
import java.util.List;

//https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1#
public class FirstNonRepeatingCharsInStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	//O(n) Time | O(n) Space
	public String FirstNonRepeating(String A)
    {
        // code here
        boolean[] repeated = new boolean[256];
        
        List<Character> queue = new ArrayList<Character>();
        StringBuilder result = new StringBuilder();
        char firstNonRepChar = ' ';
        for(int i=0; i<A.length(); i++){
            char ch = A.charAt(i);
            if(!repeated[ch]){
                repeated[ch] = true;
                queue.add(ch);
                firstNonRepChar = queue.get(0);
                result.append(firstNonRepChar);
            }
            else{
                queue.remove((Character) ch);
                if(firstNonRepChar == ch){
                    if(queue.size() > 0)
                        firstNonRepChar = queue.get(0);
                    else
                        firstNonRepChar = '#';
                }
                result.append(firstNonRepChar);
            }
        }
        return result.toString();
    }

}
