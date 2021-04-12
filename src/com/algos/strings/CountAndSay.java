package com.algos.strings;

public class CountAndSay {
	//https://leetcode.com/problems/count-and-say/
	//O(n^2) Time | O(n) Space
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(4));
	}
	
	public static String countAndSay(int n) {
		String num="1";
		if(n == 1) return num;
		while(n > 1) {
			int i=0;
			int j=0;
			String tempStr = "";
			while(j<num.length()) {
				if(num.charAt(i) == num.charAt(j))
					j++;
				else {
					tempStr += (j-i)+Character.toString(num.charAt(i));
					i=j;
				}
			}
			tempStr += (j-i)+Character.toString(num.charAt(i));
			num = tempStr;
			n--;
		}
		return num;
	}

}
