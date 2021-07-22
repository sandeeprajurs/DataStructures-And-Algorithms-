package com.algos.graph;

import java.util.HashMap;
import java.util.Map;

//O(m alpha(n)) || O(n) space n- n elements
public class DisJointSet {
	
	static class Node{
		int rank;
		int data;
		Node parent;
		public Node(int data) {
			this.data = data;
			this.rank = 1;
		}
	}
	
	Map<Integer, Node> map = new HashMap<Integer, Node>();
	
	public void makeSet(int data) {
		Node node = new Node(data);
		node.parent = node;
		map.put(data, node);
	}
	
	public void union(int a, int b) {
		Node aNode = map.get(a);
		Node bNode = map.get(b);
		Node aParent = findSet(aNode);
		Node bParent = findSet(bNode);
		
		if(aParent.data == bParent.data)
			return;
		
		if(aParent.rank >= bParent.rank) {
			aParent.rank = aParent.rank == bParent.rank ? aParent.rank+1 : bParent.rank; 
			bParent.parent = aParent;
		}
		else {
			aParent.parent = bParent;
		}
	}
	
	public Node findSet(Node node) {
		Node parent = node.parent;
		if(parent == node)
			return parent;
		node.parent = findSet(node.parent);
		return node.parent;
	}
	
	public static void main(String[] args) {
		DisJointSet disJointSet = new DisJointSet();
		disJointSet.makeSet(1);
		disJointSet.makeSet(2);
		disJointSet.makeSet(3);
		disJointSet.makeSet(4);
		disJointSet.makeSet(5);
		disJointSet.makeSet(6);
		disJointSet.makeSet(7);
		
		disJointSet.union(1, 2);
		disJointSet.union(2, 3);
		disJointSet.union(4, 5);
		disJointSet.union(6, 7);
		disJointSet.union(5, 6);
		disJointSet.union(3, 7);
		
		System.out.println(disJointSet.findSet(disJointSet.map.get(1)).data);
		System.out.println(disJointSet.findSet(disJointSet.map.get(2)).data);
		System.out.println(disJointSet.findSet(disJointSet.map.get(3)).data);
		System.out.println(disJointSet.findSet(disJointSet.map.get(4)).data);
		System.out.println(disJointSet.findSet(disJointSet.map.get(5)).data);
		System.out.println(disJointSet.findSet(disJointSet.map.get(6)).data);
		System.out.println(disJointSet.findSet(disJointSet.map.get(7)).data);
	}
}
