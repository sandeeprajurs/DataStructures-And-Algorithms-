package com.algos.binarysearch;

public class NextAlphabeticalElement {
	
	public static void main(String[] args) {
		char[] chars= new char[]{'a', 'd', 'e', 'f', 'g', 'i', 'j'};
		System.out.println(solve(chars, 'a'));
	}
	
	static char solve(char[] arr, char searchEle) {
		int start=0;
		int end = arr.length-1;
		int middle = 0;
		char candidate = '#';
		while(start <= end) {
			middle = (start + end)/2;
			
			if(searchEle == arr[middle])
				start = middle+1;
			
			else if(searchEle < arr[middle]) {
				candidate = arr[middle];
				end = middle-1;
			}
			else  if(searchEle > arr[middle])
				start= middle+1;
		}
		return candidate;
	}
}
