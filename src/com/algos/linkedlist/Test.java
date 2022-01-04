package com.algos.linkedlist;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		moveZeroes(new int[] {0,1,0,3,12});
	}
	public static void moveZeroes(int[] nums) {
        int i=0;
        int j=0;
        while(j<nums.length){
            if(i == j ){
                j++;
                continue;
            }
            if(nums[i]!=0){
                i++;
                continue;
            }
            if(nums[j] == 0){
                j++;
                continue;
            }
                
            if(nums[i]==0 && nums[j]!=0){
                swap(i, j, nums);
                i++;
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    
    public static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp; 
    }
}
