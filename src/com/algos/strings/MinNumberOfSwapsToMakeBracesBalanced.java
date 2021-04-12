package com.algos.strings;

public class MinNumberOfSwapsToMakeBracesBalanced {
	
	//https://practice.geeksforgeeks.org/problems/minimum-swaps-for-bracket-balancing2704/1#
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minSwapBracket("[]][][");
	}
	
	//O(n) Time | O(1) Space
	public static void minSwapBracket(String str){
	    long leftBrac=0;
	    long rightBrace=0;
	    long inBalance = 0;
	    long swap = 0;
	    for(int i=0; i<str.length(); i++){
	        if(str.charAt(i) == '['){
	           leftBrac++;
	           
	           if(inBalance > 0){
	               swap += inBalance;
	               inBalance--;
	           }
	        }
	        else if(str.charAt(i) == ']' ) {
	            rightBrace++;
	            inBalance = rightBrace - leftBrac;
	        }
	    }
	    System.out.println(swap);
	}

}
