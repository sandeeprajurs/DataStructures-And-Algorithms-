package com.algos.stack.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class AV_MaxAreaOfRectInBinaryMatrix {
	
	public static void main(String[] args) {
		int[][] matrix = new int[4][4];
		matrix[0] = new int[] {0,1,1,0};
		matrix[1] = new int[] {1,1,1,1};
		matrix[2] = new int[] {1,1,1,1};
		matrix[3] = new int[] {1,1,0,0};
		
		int max = 0;
		for(int i=0; i<matrix.length; i++) {
			int curMax = getMAH(i+1, matrix);
			max = Math.max(max, curMax);
		}
		System.out.println(max);
	}
	
	public static int getMAH( int n, int[][] matrix) {
		int[] arr = new int[matrix[0].length];
		for(int i=0; i<n; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(matrix[i][j] != 0)
					arr[j] = arr[j] + matrix[i][j];
				else
					arr[j] = 0;
			}
		}
		
		List<Integer> right = new ArrayList<Integer>();
		List<Integer> left = new ArrayList<Integer>();
		NSR(arr, right);
		NSl(arr, left);
//		System.out.println(right);
//		System.out.println(left);
		
		List<Integer> width = new ArrayList<Integer>();
		for(int i=0; i<arr.length; i++) {
			width.add(right.get(i) - left.get(i) - 1);
		}
		
		int max = Integer.MIN_VALUE;
		List<Integer> area = new ArrayList<Integer>();
		for(int i=0; i<arr.length; i++) {
			area.add(width.get(i) * arr[i]);
			max = max <= area.get(i) ? area.get(i) : max;
		}
		return max;
	}
	
	//Nearest Smallest element to Right
	public static void NSR(int[] list, List<Integer> result) {
		Stack<List<Integer>> stack = new Stack<List<Integer>>();
		for(int i=list.length-1; i>=0; i--) {
			if(stack.size() == 0) {
				result.add(list.length);
			}
			else if(stack.size() >0 && stack.peek().get(0) < list[i]) {
				result.add(stack.peek().get(1));
			}
			else if(stack.size() >0 && stack.peek().get(0) >= list[i]) {
				while(stack.size() >0 && stack.peek().get(0) >= list[i]) {
					stack.pop();
				}
				
				if(stack.size() == 0) result.add(list.length);
				else if(stack.peek().get(0) < list[i]) {
					result.add(stack.peek().get(1));
				}
			}
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(list[i]);
			temp.add(i);
			stack.push(temp);
		}
		Collections.reverse(result);
	}
	
	//Nearest Smallest element To Left
	public static void NSl(int[] list, List<Integer> result) {
		Stack<List<Integer>> stack = new Stack<List<Integer>>();
		for(int i=0; i<list.length; i++) {
			if(stack.size() == 0) {
				result.add(-1);
			}
			else if(stack.size() >0 && stack.peek().get(0) < list[i]) {
				result.add(stack.peek().get(1));
			}
			else if(stack.size() >0 && stack.peek().get(0) >= list[i]) {
				while(stack.size() >0 && stack.peek().get(0) >= list[i]) {
					stack.pop();
				}
				
				if(stack.size() == 0) result.add(-1);
				else if(stack.peek().get(0) < list[i]) {
					result.add(stack.peek().get(1));
				}
			}
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(list[i]);
			temp.add(i);
			stack.push(temp);
		}
	}
	
}
