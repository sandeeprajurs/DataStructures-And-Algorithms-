package com.algos.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//O(V+E) ST
public class CloneGraph {

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		node1.neighbors.add(node2);
		node1.neighbors.add(node4);
		node2.neighbors.add(node1);
		node2.neighbors.add(node3);
		node3.neighbors.add(node2);
		node3.neighbors.add(node4);
		node4.neighbors.add(node1);
		node4.neighbors.add(node3);
		Node clonedGraph = cloneNode(node1);
		System.out.println(clonedGraph);
	}
	
	static class Node {
	    public int val;
	    public List<Node> neighbors;
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
	
	public static Node cloneNode(Node node) {
		Map<Node, Node> visited = new HashMap<Node, Node>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		visited.put(node, new Node(node.val));
		while(!queue.isEmpty()) {
			Node originalNode = queue.poll();
			Node clonedNode = visited.get(originalNode);
			List<Node> neighbors = originalNode.neighbors;
			for(int i=0; i<neighbors.size(); i++) {
				Node originalNeighbor = neighbors.get(i);
				Node clonedNeighbour = visited.get(originalNeighbor);
				if(clonedNeighbour == null) {
					clonedNeighbour = new Node(originalNeighbor.val);
					visited.put(originalNeighbor, clonedNeighbour);
					queue.add(originalNeighbor);
				}
				clonedNode.neighbors.add(clonedNeighbour);
			}
		}
		return visited.get(node);
	}
}
