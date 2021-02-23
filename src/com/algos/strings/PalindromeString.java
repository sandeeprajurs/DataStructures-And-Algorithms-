package com.algos.strings;

public class PalindromeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPlaindrome("abba"));
	}
	
	//O(n) Time | O(1)Space
	public static boolean isPlaindrome(String s) {
        // code here
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

}
