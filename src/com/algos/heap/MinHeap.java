package com.algos.heap;

import java.util.ArrayList;
import java.util.List;

//get parent-> floor((i-1)/2)
//get child -> (2*i+1) and (2*i+2)
//firstParentNode(from bottom) -> (heap.size()-2)/2
public class MinHeap {

	List<Integer> heap = new ArrayList<Integer>();
	
	public MinHeap(List<Integer> heap) {
		this.heap = heap;
	}
	
	public void buildHeap() {
		int firstParentIndex = ((heap.size()-2)/2);
		for(int i=firstParentIndex; i>=0; i--) {
			siftDown(i);
		}
	}
	
	public void siftUp(int currentIndex) {
		int parentIndex = (currentIndex-1)/2;
		while(currentIndex > 0) {
			if(heap.get(parentIndex) > heap.get(currentIndex))
				swap(parentIndex, currentIndex);
			currentIndex = parentIndex;
			parentIndex = (currentIndex-1)/2;
		}
	}
	
	public void siftDown(int currentIndex) {
		int childIdx1 = (2*currentIndex) + 1;
		int toBeSwapped = 0;
		while(childIdx1 < heap.size()) {
			int childIdx2 = (2*currentIndex) + 2;
			if(childIdx2 < heap.size() && heap.get(childIdx2) < heap.get(childIdx1)) {
				toBeSwapped = childIdx2;
			}
			else {
				toBeSwapped = childIdx1;
			}
			if(heap.get(toBeSwapped) < heap.get(currentIndex))
				swap(toBeSwapped, currentIndex);
			currentIndex = toBeSwapped;
			childIdx1 = (2*currentIndex) + 1;
		}
	}
	
	public int peek() {
		return heap.get(0);
	}
	
	public void insert(int num) {
		heap.add(num);
		siftUp(heap.size()-1);
	}
	
	public int remove() {
		int temp = heap.get(0);
		swap(0, heap.size()-1);
		heap.remove(heap.size()-1);
		siftDown(0);
		return temp;
	}
	
	public void swap(int idx1, int idx2){
		int num1 = heap.get(idx1);
		int num2 = heap.get(idx2);
		heap.set(idx1, num2);
		heap.set(idx2, num1);
	}
	
	public static void main(String[] args) {
		List<Integer> heap = new ArrayList<Integer>();
		heap.add(48);
		heap.add(12);
		heap.add(24);
		heap.add(7);
		heap.add(8);
		heap.add(-5);
		heap.add(24);
		heap.add(391);
		heap.add(24);
		heap.add(56);
		heap.add(2);
		heap.add(6);
		heap.add(8);
		heap.add(41);
		MinHeap minheap = new MinHeap(heap);
		minheap.buildHeap();
		minheap.insert(76);
		System.out.println(minheap.peek());
		System.out.println(minheap.remove());
		System.out.println(minheap.peek());
		System.out.println(minheap.remove());
		System.out.println(minheap.peek());
		minheap.insert(87);
		System.out.println(minheap.heap);
	}
}
