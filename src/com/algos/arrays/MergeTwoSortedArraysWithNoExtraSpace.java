package com.algos.arrays;

import java.util.Arrays;

public class MergeTwoSortedArraysWithNoExtraSpace {
	//Merge two array Without Extra Space
	public static void main(String[] args) {
		int[] arr1 = new int[] {1,4,7}; 
		int[] arr2 = new int[] {0,2,9}; 
		mergeArrays(arr1, arr2);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}
	//O(n*m (log(n+m))) Time || O(1) Space
	//where n is length of arr1 and m is length of arr2	
	public static void mergeArrays(int[] arr1, int[] arr2) {
		int i=arr1.length-1;
		int j=0;
		while(i>=0 && j<arr2.length) {
			if(arr1[i] > arr2[j]) {
				swap(i, j, arr1, arr2);
				i--;
				j++;
			}
			else
				break;
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
	}
	
	public static void swap(int i, int j, int[] arr1, int[] arr2) {
		int temp = arr1[i];
		arr1[i] = arr2[j];
		arr2[j] = temp;
	}

}
