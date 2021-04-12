package com.algos.arrays;

import java.util.*;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[4][2];
		arr[0] = new int[] {1,3};
		arr[1] = new int[] {2,6};
		arr[2] = new int[] {8,10};
		arr[3] = new int[] {15,18};
		System.out.println(Arrays.deepToString(merge(arr)));
	}
	
	//O(n log n) Time | O(n)Space
	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
		List<int[]> list = new ArrayList<int[]>();
		list.add(intervals[0]);
		for(int i=1; i<intervals.length; i++) {
			int prevStart = list.get(list.size()-1)[0];
			int prevEnd = list.get(list.size()-1)[1];
			int currStart = intervals[i][0]; 
			int currEnd = intervals[i][1];
			if(prevEnd >= currStart) {
				list.set(list.size()-1, new int[]{prevStart, Math.max(prevEnd, currEnd)});
			}
			else
				list.add(intervals[i]);
		}
		return list.toArray(new int[list.size()-1][]);
	}

}
