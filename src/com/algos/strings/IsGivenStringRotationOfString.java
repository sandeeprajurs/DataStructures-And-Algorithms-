package com.algos.strings;

public class IsGivenStringRotationOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isRoatation("abcd","dabc"));
	}
	
	//O(1) ST
	public static boolean isRoatation(String str1, String str2) {
		if((str1+str1).indexOf(str2) == -1)
			return false;
		return true;
	}

}
