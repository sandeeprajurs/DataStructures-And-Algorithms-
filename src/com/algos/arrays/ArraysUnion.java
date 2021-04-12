package com.algos.arrays;

import java.util.HashSet;
import java.util.Set;

public class ArraysUnion {
	//Unions of 2 arrays (sorted and unsorted)
	//Intersection of 2 arrays
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(arrayIntersection2(new int[] {85, 25, 1, 32, 54, 6}, new int[] {85, 2}));
	}
	
	
	//O(n) T || O(1) S
	//dosent work with duplicates
	public static int arrayIntersection2(int[] nums1, int[] nums2) {
		int i = 0;
		int j = 0;
		int count = 0;
		while(i<nums1.length && j<nums2.length) {
			if(nums1[i] == nums2[j]) {
				count++;
				i++;
				j++;
			}
			else {
				i++;
				count++;
			}
		}
		while(i<nums1.length) {
			i++;
			count++;
		}
		while(j<nums2.length) {
			j++;
			count++;
		}
		return count;
	}
	
	//O(n) ST //When this is unsorted array
	public static int arrayUnion1(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num:nums1)
            set.add(num);
         for(int num:nums2)
            set.add(num);
        return set.size();
    }

}
