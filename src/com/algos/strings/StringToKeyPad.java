package com.algos.strings;

public class StringToKeyPad {
	//https://practice.geeksforgeeks.org/problems/convert-a-sentence-into-its-equivalent-mobile-numeric-keypad-sequence/0#
	//https://www.geeksforgeeks.org/convert-sentence-equivalent-mobile-numeric-keypad-sequence/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(keyPadSequence("GEEKSFORGEEKS"));
	}
	
	//O(n) ST
	public static String keyPadSequence(String str){
	    String[] numbers = {"2", "22", "222",
	                        "3", "33", "333",
	                        "4", "44", "444",
	                        "5", "55", "555",
	                        "6", "66", "666",
	                        "7", "77", "777", "7777",
	                        "8", "88", "888",
	                        "9", "99", "999", "9999"
	                        };
	   
	   String keyPadNum  = "";
	   for(int i=0; i<str.length(); i++){
	       if(str.charAt(i) == ' ')
	        keyPadNum += "0";
	       else
	        keyPadNum += numbers[str.charAt(i) - 'A'];
	   }
	   
	   return keyPadNum; 
	} 

}
