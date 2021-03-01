package com.algos.strings;

import java.util.*;

//This have 2 problems
public class SplitStringToEqual0sAnd1s {
	//https://www.geeksforgeeks.org/split-the-binary-string-into-substrings-with-equal-number-of-0s-and-1s/
	//https://practice.geeksforgeeks.org/problems/count-subarrays-with-equal-number-of-1s-and-0s-1587115620/1#
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getCount("0111100010"));
		System.out.println(getSubArraysCount(new int[] {1,0,0,1,0,1,1}));
	}
	
	//O(n) Time | O(1) Space
	//Varient 1-> if equal pairs of 0 and 1s are present return count else return -1
	public static int getCount(String str){
		int count0 = 0;
		int count1 = 0;
		int count = 0;
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) == '0')
				count0++;
			else if(str.charAt(i) == '1')
				count1++;
			if(count0 == count1)
				count++;
	}
	if(count0  != count1)
		return -1;
	return count;
	}
	
	//O(n) ST
	//get all the sub arrays with equal zeros and ones
	public static int getSubArraysCount(int[] arr){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		int count = 0;
		int currCount = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 0)
				currCount--;
			else if(arr[i] == 1)
				currCount++;
			
			if(!map.containsKey(currCount))
				map.put(currCount, 1);
			else {
				count += map.get(currCount);
				map.put(currCount, map.get(currCount)+1);
			}
		}
		return count;
	}
}
