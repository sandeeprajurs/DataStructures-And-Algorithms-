package com.algos.arrays;

public class MedianofTwoSortedArrays {
	//https://leetcode.com/problems/median-of-two-sorted-arrays/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMedian(new int[] {1,3,5}, new int[] {2,6,9}));
	}
	
	//Time O(log (m+n)) | O(1) Space 
	public static double getMedian(int[] nums1, int[] nums2) {
		if(nums1.length > nums2.length) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
		}
		
		int low = 0;
		int high = nums1.length;
		int combinedLength = nums1.length + nums2.length;
		while(low <=high) {
			int partX = (low + high)/2;
			int partY = (combinedLength+1)/2 - partX;
			
			int leftX = getLeftValue(nums1, partX);
			int rightX = getRightValue(nums1, partX);
			int leftY = getLeftValue(nums2, partY);
			int rightY = getRightValue(nums2, partY);
			
			if(leftX <= rightY && leftY <= rightX) {
				if(combinedLength%2 == 0)
					return (Math.max(leftX, leftY) + Math.min(rightX, rightY))/2.0;
				else
					Math.max(leftX, leftY);
			}
			
			if(leftX > rightY) {
				high = partX - 1;
			}
			else {
				low = partX + 1;
			}
		}
		return -1;
	}

	private static int getLeftValue(int[] nums, int partition) {
		if(partition == 0)
			return Integer.MIN_VALUE;
		return nums[partition-1];
	}
	
	private static int getRightValue(int[] nums, int partition) {
		if(partition == nums.length)
			return Integer.MAX_VALUE;
		return nums[partition];
	}

}
