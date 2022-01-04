package com.algos.strings;

public class RecursivelyPrintAllSentances {

	public static void main(String[] args) {
		String[][] arr = { { "you", "we", "" }, { "have", "are", "" }, { "sleep", "eat", "drink" } };
		print("", arr, 0);
	}

	public static void print(String str, String[][] arr, int row) {
		if (row == arr.length)
			System.out.println(str);
		else {
			for (int i = 0; i < arr[row].length; i++) {
				if(arr[row][i] == "")
					continue;
				print(str + arr[row][i] + " ", arr, row + 1);
			}
		}

	}

}
