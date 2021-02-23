package com.algos.arrays;

import java.util.Arrays;

public class CountInversions {
//Concept link
//https://www.youtube.com/watch?v=k9RQh21KrH8&ab_channel=GeeksforGeeks
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		long[] arr= new long[] {468,335, 1, 170, 225, 479, 359, 463, 465, 206, 146, 282, 328, 462, 492, 496, 443, 328, 437, 392, 105, 403, 154, 293, 383, 422, 217, 219, 396, 448, 227, 272, 39, 370, 413, 168, 300, 36, 395, 204, 312, 323};
		long[] arr= new long[] {2, 4, 1, 3, 5};
		long[] aux = arr.clone();
		System.out.println(mergeSort(arr, 0, arr.length-1, aux));
		System.out.println(Arrays.toString(arr));
	}
	
	 public static long mergeSort(long[] mainArr, int start, int end, long[] auxArr){
	    	long inv_count = 0;
	        if(start == end)
	            return inv_count;
	        int mid = (start + end)/2;
	        inv_count = mergeSort(auxArr, start, mid, mainArr);
	        inv_count += mergeSort(auxArr, mid+1, end, mainArr);
	        inv_count +=doMerge(mainArr, start, mid, end, auxArr);
	        return inv_count;
	    }
	    
	    public static long doMerge(long[] mainArr, int start, int mid, int end, long[] auxArr){
	        int i = start;
	        int k = start;
	        int j = mid + 1;
	        int count = 0;
	        while(i<=mid && j<=end){
	            if(auxArr[i] <= auxArr[j]){
	                mainArr[k] = auxArr[i];
	                i++;    
	            }
	            else{
	                mainArr[k] = auxArr[j];
	                j++;
	                count = count+ ((mid+1) - i);
	            }
	            k++;
	        }
	        while(i<=mid){
	            mainArr[k] = auxArr[i];
	            i++;
	            k++;
	        }
	        while(j<=end){
	            mainArr[k] = auxArr[j];
	            j++;
	            k++;
	        }
	        return count;
	    }

}
