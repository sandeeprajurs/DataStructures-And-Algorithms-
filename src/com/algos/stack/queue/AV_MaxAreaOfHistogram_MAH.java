package com.algos.stack.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//in 0th index element stored and in 1th inext Elements Index stored
public class AV_MaxAreaOfHistogram_MAH {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(6,2,5,4,5,1,6);
		List<Integer> right = new ArrayList<Integer>();
		List<Integer> left = new ArrayList<Integer>();
		
		NSR(list, right);
		NSl(list, left);
		System.out.println(right);
		System.out.println(left);
		List<Integer> width = new ArrayList<Integer>();
		for(int i=0; i<list.size(); i++) {
			width.add(right.get(i) - left.get(i) - 1);
		}
		
		int max = Integer.MIN_VALUE;
		List<Integer> area = new ArrayList<Integer>();
		for(int i=0; i<list.size(); i++) {
			area.add(width.get(i) * list.get(i));
			max = max <= area.get(i) ? area.get(i) : max;
		}
		System.out.println(area);
		System.out.println(max);
	}
	
	//Nearest Smallest element to Right
	public static void NSR(List<Integer> list, List<Integer> result) {
		Stack<List<Integer>> stack = new Stack<List<Integer>>();
		for(int i=list.size()-1; i>=0; i--) {
			if(stack.size() == 0) {
				result.add(list.size());
			}
			else if(stack.size() >0 && stack.peek().get(0) < list.get(i)) {
				result.add(stack.peek().get(1));
			}
			else if(stack.size() >0 && stack.peek().get(0) >= list.get(i)) {
				while(stack.size() >0 && stack.peek().get(0) >= list.get(i)) {
					stack.pop();
				}
				
				if(stack.size() == 0) result.add(list.size());
				else if(stack.peek().get(0) < list.get(i)) {
					result.add(stack.peek().get(1));
				}
			}
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(list.get(i));
			temp.add(i);
			stack.push(temp);
		}
		Collections.reverse(result);
	}
	
	//Nearest Smallest element To Left
	public static void NSl(List<Integer> list, List<Integer> result) {
		Stack<List<Integer>> stack = new Stack<List<Integer>>();
		for(int i=0; i<list.size(); i++) {
			if(stack.size() == 0) {
				result.add(-1);
			}
			else if(stack.size() >0 && stack.peek().get(0) < list.get(i)) {
				result.add(stack.peek().get(1));
			}
			else if(stack.size() >0 && stack.peek().get(0) >= list.get(i)) {
				while(stack.size() >0 && stack.peek().get(0) >= list.get(i)) {
					stack.pop();
				}
				
				if(stack.size() == 0) result.add(-1);
				else if(stack.peek().get(0) < list.get(i)) {
					result.add(stack.peek().get(1));
				}
			}
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(list.get(i));
			temp.add(i);
			stack.push(temp);
		}
	}
}
