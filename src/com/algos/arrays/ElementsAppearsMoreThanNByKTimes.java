package com.algos.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementsAppearsMoreThanNByKTimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(elementsRepetingNTimes1(new int[] {3, 1, 2, 2, 1, 2, 3, 3}, 4));
	}
	
	//O(n log(n)) Time || O(1) Space if we don't consider resultant list
	public static List<Integer> elementsRepetingNTimes1(int[] num, int k){
		int count = num.length/k;
		Arrays.sort(num);
		int numsCount = 1;
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1; i<num.length; i++) {
			int prev = num[i-1];
			int curr = num[i];
			if(curr == prev)
				numsCount++;
			else {
				if(numsCount > count)
					list.add(prev);
				numsCount=1;
			}
		}
		if(numsCount > count)
			list.add(num[num.length-2]);
		return list;
	}
	
	//O(n) ST
	public static List<Integer> elementsRepetingNTimes(int[] num, int k){
		int count = num.length/k;
		Map<Integer, Integer> numCount = new HashMap<Integer, Integer>();
		List<Integer> list = new ArrayList<Integer>();
		for(int n:  num){
			if(!numCount.containsKey(n))
				numCount.put(n, 0);
			numCount.put(n, numCount.get(n)+1);
		}
		for(int n: numCount.keySet()){
			if(numCount.get(n) > count)
				list .add(n);
		}
		return list;
	}

}
