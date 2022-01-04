package com.algos.recursion;

import java.util.ArrayList;
import java.util.List;

//Same logic for stack but use push, pop and peek
public class Sort_Array_Stack_UsingRecursion {
	
	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(2);
		arrayList.add(7);
		arrayList.add(6);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(5);
		arrayList.add(0);
		System.out.println(arrayList);
		sort(arrayList);
		System.out.println(arrayList);
	}
	
	static void sort(List<Integer> arr) {
		if(arr.size() == 1) return;
		
		int temp = arr.remove(arr.size()-1);
		sort(arr);
		insert(arr, temp);
	}

	private static void insert(List<Integer> arr, int temp) {
		if(arr.size() == 0 || arr.get(arr.size()-1) <= temp) {
			arr.add(temp);
			return;
		};
		
		int value = arr.remove(arr.size()-1);
		insert(arr, temp);
		arr.add(value);
		return;
	}
}
