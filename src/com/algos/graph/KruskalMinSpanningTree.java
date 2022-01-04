package com.algos.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//O(n log n) Time | O(n) Space
public class KruskalMinSpanningTree {

	static class Node {
		int data;
		int rank;
		Node parent;

		public Node(int data) {
			this.data = data;
			this.rank = 1;
		}
	}

	static class Edge {
		Node src;
		Node dest;
		int weight;
		
		public Edge(Node src, Node dest, int weight) {
			this.src = src;
			this.dest =  dest;
			this.weight = weight;
		}
	}

	static int sum = 0;
	static Edge[] edges;
	static List<Edge> resulEdges = new ArrayList<Edge>();
	static Map<Integer, Node> map = new HashMap<Integer, Node>();
	
	public static void makeSet(int data) {
		Node node = new Node(data);
		node.parent = node;
		map.put(data, node);
	}

	public static void union(int index) {
		Node src = edges[index].src;
		Node dest = edges[index].dest;
		Node srcParent = findSet(src.data);
		Node destParent = findSet(dest.data);
		
		if (srcParent.data == destParent.data)
			return;

		if (srcParent.rank >= destParent.rank) {
			srcParent.rank = srcParent.rank == destParent.rank ? srcParent.rank + 1 : srcParent.rank;
			destParent.parent = srcParent;			
		} else {
			srcParent.parent = destParent;
		}
		map.put(src.data, src);
		map.put(dest.data, dest);
		sum += edges[index].weight;
		resulEdges.add(edges[index]);
	}

	public static Node findSet(int data) {
		Node node = map.get(data);
		int parent = node.parent.data;
		if (parent == node.data)
			return node;
		node.parent = findSet(node.parent.data);
		return node.parent;
	}

	public static void KruskalMST() {
		Arrays.sort(edges, (e1, e2) -> e1.weight - e2.weight);
		for(int i=0; i<edges.length; i++) {
			System.out.println(edges[i].src.data+"-------"+edges[i].dest.data+" :----"+edges[i].weight);
		}
		for (int i = 0; i < edges.length; i++) {
			union(i);
		}
	}

	public static void main(String[] args) {
//		makeSet(0);
//		makeSet(1);
//		makeSet(2);
//		makeSet(3);
//		makeSet(4);
//
//		Edge edge1 = new Edge(map.get(0), map.get(1), 10);
//		Edge edge2 = new Edge(map.get(0), map.get(2), 6);
//		Edge edge3 = new Edge(map.get(0), map.get(3), 5);
//		Edge edge4 = new Edge(map.get(1), map.get(3), 15);
//		Edge edge5 = new Edge(map.get(2), map.get(3), 4);
//		edges = new Edge[] {edge1, edge2, edge3, edge4, edge5};
		
		makeSet(0);
		makeSet(1);
		makeSet(2);
		makeSet(3);
		makeSet(4);
		makeSet(5);
		makeSet(6);
		makeSet(7);
		makeSet(8);
		Edge edge1 = new Edge(map.get(7), map.get(6), 1);
		Edge edge2 = new Edge(map.get(3), map.get(5), 14);
		Edge edge3 = new Edge(map.get(1), map.get(7), 11);
		Edge edge4 = new Edge(map.get(0), map.get(1), 4);
		Edge edge5 = new Edge(map.get(2), map.get(5), 4);
		Edge edge6 = new Edge(map.get(8), map.get(6), 6);
		Edge edge7 = new Edge(map.get(2), map.get(3), 7);
		Edge edge8 = new Edge(map.get(7), map.get(8), 7);
		Edge edge9 = new Edge(map.get(0), map.get(7), 8);
		Edge edge10 = new Edge(map.get(1), map.get(2), 8);
		Edge edge11 = new Edge(map.get(3), map.get(4), 9);
		Edge edge12 = new Edge(map.get(5), map.get(4), 10);
		Edge edge13 = new Edge(map.get(6), map.get(5), 2);
		Edge edge14 = new Edge(map.get(8), map.get(2), 2);
		edges = new Edge[] {edge1, edge2, edge3, edge4, edge5, edge6, edge7, edge8, edge9, edge10, edge11, edge12, edge13, edge14};
		KruskalMST();
		System.out.println("Edges");
		for(int i=0; i<resulEdges.size();i++) {
			int src = resulEdges.get(i).src.data;
			int dest = resulEdges.get(i).dest.data;
			int weight = resulEdges.get(i).weight;
			System.out.println(src+" ---- "+dest+" Weight: "+weight);
		}
		System.out.println("minimum spanning tree");
		System.out.println(sum);
	}

}
