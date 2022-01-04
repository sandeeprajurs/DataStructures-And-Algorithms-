package com.algos.stack.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.print.attribute.HashAttributeSet;

public class AV_StockSpanProblem {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(80);
		list.add(60);
		list.add(70);
		list.add(60);
		list.add(75);
		list.add(85);
		solve(list);
	}
	
	public static void solve(List<Integer> list) {
		Stack<List<Integer>> stack = new Stack<List<Integer>>();
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<list.size(); i++) {
			if(stack.size() == 0) {
				result.add(-1);
			}
			else if(stack.size() >0 && stack.peek().get(0) > list.get(i)) {
				result.add(stack.peek().get(1));
			}
			else if(stack.size() >0 && stack.peek().get(0) <= list.get(i)) {
				while(stack.size() >0 && stack.peek().get(0) <= list.get(i)) {
					stack.pop();
				}
				
				if(stack.size() == 0) result.add(-1);
				else if(stack.peek().get(0) > list.get(i)) {
					result.add(stack.peek().get(1));
				}
			}
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(list.get(i));
			temp.add(i);
			stack.push(temp);
		}
		
		List<Integer> ans = new ArrayList<Integer>();
		for(int i=0; i<result.size(); i++) {
			ans.add(i - result.get(i));
		}
		System.out.println(ans);
	}
}


