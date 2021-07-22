package com.algos.arrays;

import java.util.Arrays;

public class NextPermutation {
	
	//O(n) Time | O(1) Space
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,4,8,10,7,6,4,3,1};
		nextPermutation(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	 public static void nextPermutation(int[] nums) {
	        int maxNumIdx = -1;
	        int minNumIdx = -1;
	        for(int i=nums.length-1; i>0; i--){
	            if(nums[i] > nums[i-1]){
	                maxNumIdx = i;
	                minNumIdx = i-1;
	                break;
	            }
	        }
	        
	        if(maxNumIdx!= -1){
	            for(int i=maxNumIdx+1; i<nums.length; i++){
	                if(nums[i] > nums[minNumIdx] && nums[i] <= nums[maxNumIdx]){
	                    maxNumIdx = i;
	                }
	            }
	            swap(maxNumIdx, minNumIdx, nums);
	        }
	        
	        int j = minNumIdx+1;
	        int k = nums.length-1;
	        while(j<nums.length && j<k){
	            swap(j,k, nums);
	            j++;
	            k--;
	        }
	    }
	    
	    public static void swap(int i, int j, int[] arr){
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }

}
