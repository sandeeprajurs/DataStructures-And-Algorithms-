package com.algos.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

//insert O(log(n)) Time| Space O(n)
//get median O(1) Time
public class ContinousMedian {

	MinMaxHeap lowers = new MinMaxHeap(MinMaxHeap::MAX_HEAP_FUNC, new ArrayList<Integer>());
	MinMaxHeap greaters = new MinMaxHeap(MinMaxHeap::MIN_HEAP_FUNC, new ArrayList<Integer>());
	double median;
	
	public void inser(int num) {
		if(lowers.length == 0 || lowers.peek() > num)
			lowers.insert(num);
		else {
			greaters.insert(num);
		}
		reBalanceHeap();
		updateMedian();
	}
	
	public double getMedian() {
		return median;
	}
	
	public void reBalanceHeap() {
		if(lowers.length - greaters.length == 2)
			greaters.insert(lowers.remove());
		else if(greaters.length - lowers.length == 2)
			lowers.insert(greaters.remove());
	}
	
	public void updateMedian() {
		if(lowers.length == greaters.length)
			median = ((double) lowers.peek() + (double) greaters.peek()) / 2;
		else if(lowers.length > greaters.length)
			median = lowers.peek();
		else if(greaters.length > lowers.length)
			median = greaters.peek();
	}

	public static void main(String[] args) {
		ContinousMedian continiousMedian = new ContinousMedian();
//		continiousMedian.inser(5);
//		continiousMedian.inser(10);
//		System.out.println(continiousMedian.getMedian());
//		continiousMedian.inser(100);
//		continiousMedian.inser(200);
//		continiousMedian.inser(6);
//		continiousMedian.inser(13);
//		continiousMedian.inser(14);
		continiousMedian.inser(90);
		continiousMedian.inser(100);
		continiousMedian.inser(78);
		continiousMedian.inser(89);
		continiousMedian.inser(67);
//		continiousMedian.inser(12);
//		continiousMedian.inser(14);
//		continiousMedian.inser(16);
//		continiousMedian.inser(18);
//		continiousMedian.inser(20);
		System.out.println(continiousMedian.getMedian());
	}
}

class MinMaxHeap {

	List<Integer> heap;
	BiFunction<Integer, Integer, Boolean> comparisonFunc;
	int length;

	public MinMaxHeap(BiFunction<Integer, Integer, Boolean> func, List<Integer> heap) {
		comparisonFunc = func;
		this.heap = heap;
		length = heap.size();
	}

	public void siftUp(int currentIndex) {
		int parentIndex = (currentIndex - 1) / 2;
		while (currentIndex > 0) {
			if (comparisonFunc.apply(heap.get(currentIndex), heap.get(parentIndex)))
				swap(parentIndex, currentIndex);
			currentIndex = parentIndex;
			parentIndex = (currentIndex - 1) / 2;
		}
	}

	public void siftDown(int currentIndex) {
		int childIdx1 = (2 * currentIndex) + 1;
		int toBeSwapped = 0;
		while (childIdx1 < heap.size()) {
			int childIdx2 = (2 * currentIndex) + 2;
			if (childIdx2 < heap.size() && comparisonFunc.apply(heap.get(childIdx2), heap.get(childIdx1))) {
				toBeSwapped = childIdx2;
			} else {
				toBeSwapped = childIdx1;
			}
			if (comparisonFunc.apply(heap.get(toBeSwapped), heap.get(currentIndex)))
				swap(toBeSwapped, currentIndex);
			currentIndex = toBeSwapped;
			childIdx1 = (2 * currentIndex) + 1;
		}
	}

	public int peek() {
		return heap.get(0);
	}

	public void insert(int num) {
		heap.add(num);
		siftUp(heap.size() - 1);
		length++;
	}

	public int remove() {
		int temp = heap.get(0);
		swap(0, heap.size() - 1);
		heap.remove(heap.size() - 1);
		siftDown(0);
		length--;
		return temp;
	}

	public void swap(int idx1, int idx2) {
		int num1 = heap.get(idx1);
		int num2 = heap.get(idx2);
		heap.set(idx1, num2);
		heap.set(idx2, num1);
	}
	
	public static Boolean MAX_HEAP_FUNC(Integer a, Integer b){
		return a > b;
	} 
	
	public static Boolean MIN_HEAP_FUNC(Integer a, Integer b){
		return a < b;
	} 
}
