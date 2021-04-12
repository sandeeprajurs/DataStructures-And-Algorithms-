package com.algos.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//O(n)ST
//https://www.geeksforgeeks.org/minimum-swap-required-convert-binary-tree-binary-search-tree/#:~:text=Given%20the%20array%20representation%20of,it%20into%20Binary%20Search%20Tree.&text=Swap%201%3A%20Swap%20node%208,node%209%20with%20node%2010.
public class MinSwapBtToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Node {
		Node left;
		Node right;
		int data;

		public Node(int value) {
			this.data = value;
		}
	}

	public static int swap;
	public static int i;

	public static int getMinSwap(Node node) {
		i = 0;
		swap = 0;
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> excludeList = new ArrayList<Integer>();
		inOrderTraversal(node, list);
		Collections.sort(list);

		convertBtToBst(node, list, excludeList);
		return swap;
	}

	public static void convertBtToBst(Node node, List<Integer> list, List<Integer> excludeList) {
		if (node == null)
			return;
		convertBtToBst(node.left, list, excludeList);
		if (node.data != list.get(i) && !excludeList.contains(node.data)) {
			excludeList.add(list.get(i));
			node.data = list.get(i);
			swap += 1;
		}
		i += 1;
		convertBtToBst(node.right, list, excludeList);
	}

	public static void inOrderTraversal(Node node, List<Integer> list) {
		if (node == null)
			return;
		inOrderTraversal(node.left, list);
		list.add(node.data);
		inOrderTraversal(node.right, list);
	}

}
