package com.algos.binarytree;
import java.util.ArrayList;
import java.util.List;

//O(n) Time | O(1) Space
//Morris Inorder Traversal
public class IterativeInOrderTraversal {
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
		System.out.println(iterativeInOrderTraversal(node, result));
	}

	public static List<Integer> iterativeInOrderTraversal(Node node, List<Integer> result) {
		while(node != null) {
			if(node.left == null) {
				result.add(node.data);
				node = node.right;
			}
			else {
				Node preDecessor = getPredecessor(node);
				if(preDecessor.right == null) {
					preDecessor.right = node;
					node = node.left;
				}
				else {
					preDecessor.right = null;
					result.add(node.data);
					node = node.right;
				}
			}
		}
		return result;
	}


	public static Node getPredecessor(Node current) {
		Node node = current.left;
		while(node.right != null && node.right != current) {
			node = node.right;
		}
		return node;
	}

}
