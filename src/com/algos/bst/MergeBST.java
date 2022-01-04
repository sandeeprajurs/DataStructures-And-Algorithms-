package com.algos.bst;

import java.util.ArrayList;
import java.util.List;

public class MergeBST {
	//https://www.geeksforgeeks.org/merge-two-balanced-binary-search-trees/
	//O(m+n) ST
	public static void main(String[] args) {
		TreeNode tree1 = new TreeNode(100);
		tree1.left = new TreeNode(50);
		tree1.right = new TreeNode(300);
		tree1.left.left = new TreeNode(20);
		tree1.left.right = new TreeNode(70);
		
		TreeNode tree2 = new TreeNode(80);
        tree2.left = new TreeNode(40);
        tree2.right = new TreeNode(120);
        
        mergeTrees(tree1, tree2);
	}
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	static class TreeInfo {
		int idx;

		public TreeInfo(int idx) {
			this.idx = idx;
		}
	}

	public static void mergeTrees(TreeNode root1, TreeNode root2) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		inOrder(root1, list1);
		inOrder(root2, list2);
		List<Integer> list = merge(list1, list2);
		constructBST(list, Integer.MIN_VALUE, Integer.MAX_VALUE, new TreeInfo(0));
		//inorder traversal of merged trees
		System.out.println(list);
	}

	public static TreeNode constructBST(List<Integer> list, int min, int max, TreeInfo treeInfo) {
		if (treeInfo.idx == list.size())
			return null;
		int rootVal = list.get(treeInfo.idx);
		if (rootVal < min || rootVal >= max)
			return null;
		treeInfo.idx += 1;
		TreeNode left = constructBST(list, min, rootVal, treeInfo);
		TreeNode right = constructBST(list, rootVal, max, treeInfo);
		TreeNode bst = new TreeNode(rootVal);
		bst.left = left;
		bst.right = right;
		return bst;
	}

	public static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
		int i = 0;
		int j = 0;
		List<Integer> list = new ArrayList<Integer>();
		while (i < list1.size() && j < list2.size()) {
			if (list1.get(i) < list2.get(j)) {
				list.add(list1.get(i));
				i++;
			} else if (list2.get(j) < list1.get(i)) {
				list.add(list2.get(j));
				j++;
			}
		}
		while (i < list1.size()) {
			list.add(list1.get(i));
			i++;
		}
		while (j < list2.size()) {
			list.add(list2.get(j));
			j++;
		}
		return list;
	}

	public static void inOrder(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		inOrder(root.left, list);
		list.add(root.val);
		inOrder(root.right, list);
	}

}
