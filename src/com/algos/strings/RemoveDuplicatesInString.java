package com.algos.strings;
import java.util.*;

public class RemoveDuplicatesInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicates("sandeep"));
	}
	
	static String removeDuplicates(String str) {
        // code here
        Set<Character> s = new HashSet<Character>();
	    String newStr = "";
	    for(int i=0; i<str.length(); i++){
	        if(!s.contains(str.charAt(i))){
	            s.add(str.charAt(i));
	            newStr += str.charAt(i);
	        }
	    }
	    return newStr;
    }

}
