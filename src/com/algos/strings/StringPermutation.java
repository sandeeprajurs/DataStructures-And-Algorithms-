package com.algos.strings;

import java.util.Set;
import java.util.TreeSet;

//All permutations of a string
public class StringPermutation {
	public static void main(String[] args) {
		getPermutation(0, "ABC".split(""));
		System.out.println(allPermutations);
	}

	static Set<String> allPermutations = new TreeSet<String>();
	public static void getPermutation(int i, String[] arr){
		if(i == arr.length-1)
			allPermutations.add(String.join("", arr));
		else{
			for(int j=i; j<arr.length; j++){
				swap(i, j, arr);
				getPermutation(i+1, arr);
				swap(i, j, arr);
			}
		}
	}
	
	private static void swap(int i, int j, String[] array) {
		String temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
}
