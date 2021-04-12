package com.algos.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//O(n) ST
public class IterativePostOrderTraversal {
	
	static class Node {
		Node left;
		Node right;
		int data;

		public Node(int value) {
			this.data = value;
		}
	}
	
	public static void main(String[] args) {
		Node node = new Node(50);
		node.left = new Node(30);
		node.left.left = new Node(20);
		node.left.right = new Node(40);
		node.right = new Node(70);
		node.right.left = new Node(60);
		node.right.right = new Node(80);
		List<Integer> result = new ArrayList<Integer>();
		System.out.println(iterativePostOrderTraversal(node, result));
	}

	private static List<Integer> iterativePostOrderTraversal(Node node, List<Integer> result) {
		Stack<Node> stack = new Stack<Node>();
		stack.add(node);
		while(!stack.isEmpty()) {
			Node temp = stack.pop();
			result.add(temp.data);
			if(temp.left != null)
				stack.push(temp.left);
			if(temp.right != null)
				stack.push(temp.right);
		}
		
		Collections.reverse(result);
		return result;
	}

}
