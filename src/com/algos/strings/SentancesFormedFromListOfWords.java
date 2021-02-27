package com.algos.strings;

import java.util.*;

public class SentancesFormedFromListOfWords {
	//Recursively print all sentences that can be formed from list of word lists
	//https://www.geeksforgeeks.org/recursively-print-all-sentences-that-can-be-formed-from-list-of-word-lists/
	static List<String> list = new ArrayList<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] words=  {{"you", "we", ""},
			                {"have", "are", ""},
			                {"sleep", "eat", "drink"}};
		getAllWords(words, 0, "");
		System.out.println(list);
	}
	
	//O(Rows*Columns) Time || O(n) Space
	public static void getAllWords(String[][] strArr, int i, String str) {
		if (i == strArr.length) {
			list.add(str);
			str = "";
			return;
		}

		for (int j = 0; j < strArr[i].length; j++) {
			if(strArr[i][j] == "")
				continue;
			String currString = "";
			if(str.length() == 0)
				currString = strArr[i][j];
			else
				currString= str + " " + strArr[i][j];
			getAllWords(strArr, i + 1, currString);
		}

	}

}
