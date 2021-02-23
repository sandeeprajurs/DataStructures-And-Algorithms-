package com.algos.arrays;

import java.util.HashSet;
import java.util.Set;

public class ArraysUnion {
	//Unions of 2 arrays (sorted and unsorted)
	//Intersection of 2 arrays
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(arrayUnion2(new int[] {1,2,3,4}, new int[] {3,4}));
		System.out.println(arrayUnion2(new int[] {85,25,1,32,54,6}, new int[] {85,2}));
		
		System.out.println(arrayIntersection1(new int[] {1,2,3,4}, new int[] {3,4}));
		System.out.println(arrayIntersection2(new int[] {1,2,3,4}, new int[] {3,4}));
	}
	
	//O(n) ST
	public static int arrayIntersection1(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<Integer>();
		int count = 0;
		for(int num:nums1)
			 set.add(num);
		for(int num:nums2) {
			if(set.contains(num))
				count++;
		}
		return count;
	}
	
	//O(n) T || O(1) S
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
			}
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
	
	//O(n) Time || O(1) Space
	//This approach wont work if array contains duplicate
	public static int arrayUnion2(int[] nums1, int[] nums2) {
		int i=0;
		int j =0;
		int count=0;
		while(i<nums1.length && j<nums2.length) {
			if(nums1[i] < nums2[j]) {
				count++;
				i++;
			}
			else if(nums2[j] < nums1[i]) {
				count++;
				j++;
			}
			else if(nums1[i] == nums2[j]) {
				i++;
				j++;
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

}
