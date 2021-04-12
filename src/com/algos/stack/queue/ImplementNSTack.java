package com.algos.stack.queue;

import java.util.Arrays;

//https://www.geeksforgeeks.org/efficiently-implement-k-stacks-single-array/
public class ImplementNSTack {
	
	public static void main(String[] args) {
		Kstack kstack = new Kstack(3, 5);
		kstack.push(1, 2);
		kstack.push(2, 2);
		
		kstack.push(3, 1);
		kstack.push(4, 0);
		
		kstack.pop(1);
		System.out.println(Arrays.toString(kstack.arr));
	}

	static class Kstack {
		int arr[];
		int top[];
		int next[];

		int n, k;
		int free;

		Kstack(int k1, int n1) {
			k = k1;
			n = n1;
			arr = new int[n];
			top = new int[k];
			next = new int[n];
			
			for (int i = 0; i < k; i++)
				top[i] = -1;

			free = 0;
			for (int i = 0; i < n - 1; i++)
				next[i] = i + 1;
			next[n - 1] = -1;
		}

		boolean isFull() {
			return (free == -1);
		}
		
		//O(1) ST
		void push(int item, int sn) {
			if (isFull()) {
				System.out.println("Stack Overflow");
				return;
			}

			int i = free;
			arr[i] = item;
			free = next[i];
			next[i] = top[sn];
			top[sn] = i;
		}

		//O(1) ST
		int pop(int sn) {
			if (isEmpty(sn)) {
				System.out.println("Stack Underflow");
				return Integer.MAX_VALUE;
			}

			int i = top[sn];
			top[sn] = next[i];
			next[i] = free;
			free = i;
			return arr[i];
		}

		boolean isEmpty(int sn) {
			return top[sn] == -1;
		}
	}
}
