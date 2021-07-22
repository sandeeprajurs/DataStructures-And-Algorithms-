package com.algos.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.algos.graph.MinimumTimeTakenForEachJobToComplete.Graph;

public class BipartiteAlgoGraphColoring {

	// ----------------Graph Creation=--------------------------------
	static class Graph {
		Map<Integer, ArrayList<Integer>> graphMap;

		public Graph(List<Integer> vertex) {
			graphMap = new HashMap<Integer, ArrayList<Integer>>();
			for (int i = 0; i < vertex.size(); i++) {
				graphMap.put(vertex.get(i), new ArrayList<Integer>());
			}
		}

		// for unidirectinal purpose
		public void addEdge(int a, int b) {
			if (!graphMap.containsKey(a))
				graphMap.put(a, new ArrayList<Integer>());
			if (!graphMap.containsKey(b))
				graphMap.put(b, new ArrayList<Integer>());
			graphMap.get(a).add(b);
			graphMap.get(b).add(a);
		}
	}
	// ---------------------------------------------------------------------

	public static void main(String[] args) {
//		List<Integer> vertices = Arrays.asList(1,2,3,4,5);
//		Graph graph = new Graph(vertices);
//		graph.addEdge(1, 2);
//		graph.addEdge(2, 3);
//		graph.addEdge(2, 4);
//		graph.addEdge(4, 5);
//		graph.addEdge(3, 5);
		
		List<Integer> vertices = Arrays.asList(1,2,3,4,5);
		Graph graph = new Graph(vertices);
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 3);
		graph.addEdge(3, 1);
		System.out.println(bipartiteAlgo(graph, 1));
	}
	
	//O(E+V) Time || O(V) Space
	public static boolean bipartiteAlgo(Graph graph, int src) {
		//colors will be 0 and 1
		Map<Integer, Integer> color = new HashMap<Integer, Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(src);
		color.put(src, 0);
		
		while(!queue.isEmpty()) {
			int currNode = queue.poll();
			int currColor = color.get(currNode);
			List<Integer> adjNodes = graph.graphMap.get(currNode);
			for(int i=0; i<adjNodes.size(); i++) {
				int node = adjNodes.get(i);
				if(!color.containsKey(node)) {
					color.put(node, getColor(currColor));
					queue.add(node);
				}
				else if(color.get(node) != getColor(currColor)){
					return false;
				}
			}
		}
		return true;
	}
	
	public static int getColor(int currColor) {
		return 1-currColor;
	}

}
