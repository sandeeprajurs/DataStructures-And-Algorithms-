package com.algos.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.algos.binarytree.IterativeInOrderTraversal.Node;

//O(n) ST
//https://www.techiedelight.com/preorder-tree-traversal-iterative-recursive/
public class IterativePreOrderTraversal {

	public static void main(String[] args) {
		Node node = new Node(1);
		node.left = new Node(2);
		node.left.left = new Node(4);
		node.right = new Node(3);
		node.right.right = new Node(6);
		node.right.left = new Node(5);
		node.right.left.left = new Node(7);
		node.right.left.right = new Node(8);
		List<Integer> result = new ArrayList<Integer>();
		System.out.println(iterativePreOrderTraversal(node, result));
	}

	public static List<Integer> iterativePreOrderTraversal(Node node, List<Integer> result) {

		Stack<Node> stack = new Stack<Node>();
		stack.push(node);
		Node currNode = node;
		while (!stack.isEmpty()) {
			if (currNode != null) {
				result.add(currNode.data);
				if (currNode.right != null) {
					stack.push(currNode.right);
				}
				currNode = currNode.left;
			} else
				currNode = stack.pop();
		}
		return result;
	}
}
