package com.algos.strings;

public class StringValidShuffelOfTwoString {
	//https://www.programiz.com/java-programming/examples/check-valid-shuffle-of-strings
	public static void main(String[] args) {
		System.out.println(shiffelCheck("XY", "12", "X12Y"));
		char a =97;
		System.out.println(a);
	}
	
	//O(n) Time | O(1) Space
	public static boolean shiffelCheck(String str1, String str2, String result) {
		if ((str1 + str2).length() != result.length())
			return false;
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < str1.length() && j < str2.length()) {
			if (result.charAt(k) == str1.charAt(i)) {
				i++;
			} else if (result.charAt(k) == str2.charAt(j)) {
				j++;
			} else {
				return false;
			}
			k++;
		}
		while (i < str1.length()) {
			if (result.charAt(k) == str1.charAt(i)) {
				i++;
				k++;
			} else {
				return false;
			}
		}
		while (j < str2.length()) {
			if (result.charAt(k) == str2.charAt(j)) {
				j++;
				k++;
			} else {
				return false;
			}
		}
		return true;
	}

}
