package com.algos.arrays;

import java.util.ArrayList;

//Common elements
public class CommonElementsInThreeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(commonElements(new int[]{1, 5, 10, 20, 40, 80}, new int[]{6, 7, 20, 80, 100}, new int[]{3, 4, 15, 20, 30, 70, 80, 120}));
	}
	
	//O(n) ST
	public static ArrayList<Integer> commonElements(int arr1[], int arr2[], int arr3[]) 
    {
		int i=0;
    	int j=0;
    	int k=0;
    	int last = Integer.MIN_VALUE;
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	while(i<arr1.length && j<arr2.length && k<arr3.length){
    	    if(arr1[i] == arr2[j] && arr1[i] == arr3[k] && arr1[i] != last){
			    list.add(arr1[i]);
		        last = arr1[i];
    			i++;
    			j++;
    			k++;
            }
    		else if(Math.min(arr1[i], Math.min(arr2[j], arr3[k])) == arr1[i])
    			i++;
    		else if(Math.min(arr1[i], Math.min(arr2[j], arr3[k])) == arr2[j])
    			j++;
    		else
    			k++;
    		
        }
        return list;
    }

}
