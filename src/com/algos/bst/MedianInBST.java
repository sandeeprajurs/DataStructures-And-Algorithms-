package com.algos.bst;

//https://www.geeksforgeeks.org/find-median-bst-time-o1-space/
public class MedianInBST {
	
	//O(n) Time | O(1) Space
	public static void main(String[] args) {
		Node node = new Node(50);
		node.left = new Node(30);
		node.left.left = new Node(20);
		node.left.right = new Node(40);
		node.right = new Node(70);
		node.right.left = new Node(60);
		node.right.right = new Node(80);
		System.out.println(getMedian(node));
	}
	
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int d) {
			data = d;
		}
	}
	
	public static int getMedian(Node root) {
		int count = getCount(root);
		Node[] nodes = inOrderTraversal(root, count/2);
		if(count % 2 == 0) {
			return (nodes[0].data + nodes[1].data)/2;
		}
		else {
			return  nodes[1].data;
		}
	}
	
	public static Node[] inOrderTraversal(Node root, int k) {
		int count = 0;
		Node current = root;
		Node prev = null;
		Node[] nodes = new Node[] {prev, current};
		if(root == null) return nodes;
		while(current != null) {
			if(count >= k) return new Node[] {prev, current};
			if(current.left == null) {
				count++;
				prev = current;
				current = current.right;
			}
			else {
				Node preDecessor = preDecessor(current);
				if(preDecessor.right == null) {
					preDecessor.right = current;
					prev = current;
					current = current.left;
				}
				else {
					count++;
					preDecessor.right = null;
					prev = current;
					current = current.right;
				}
			}
		}
		return nodes;
	}

	
	public static int getCount(Node root) {
		int count = 0;
		if(root == null) return count;
		Node current = root;
		
		while(current != null) {
			if(current.left == null) {
				count++;
				current = current.right;
			}
			else {
				Node preDecessor = preDecessor(current);
				if(preDecessor.right == null) {
					preDecessor.right = current;
					current = current.left;
				}
				else {
					count++;
					preDecessor.right = null;
					current = current.right;
				}
			}
		}
		return count;
	}

	private static Node preDecessor(Node current) {
		Node node = current.left;
		while(node.right != null && node.right != current) {
			node = node.right;
		}
		return node;
	}

}
















