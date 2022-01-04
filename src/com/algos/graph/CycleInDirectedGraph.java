package com.algos.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CycleInDirectedGraph {
	//---------Graph Creation-----------------------------------------------------
	static class Graph {
		int vertex;
		List<List<Integer>> list;

		public Graph(int vertex) {
			this.vertex = vertex;
			list = new ArrayList<List<Integer>>();
			for (int i = 0; i < vertex; i++)
				list.add(i, new ArrayList<Integer>());
		}

		// for unidirectinal purpose
		public void addEdge(int a, int b) {
			list.get(a).add(b);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(2, 1);
		graph.addEdge(4, 0);
		graph.addEdge(4, 2);
		graph.addEdge(3, 4);
		graph.addEdge(2, 3);
		
//		graph.addEdge(0, 3);
//		graph.addEdge(0, 2);
//		graph.addEdge(3, 1);
//		graph.addEdge(4, 1);
//		graph.addEdge(4, 2);
//		graph.addEdge(5, 2);
//		graph.addEdge(5, 0);
		System.out.println(graph.list);
		System.out.println(DFSCheckCycleIsPresent(graph.list));
	}
	
	//---------Detect Cycles in Graph-----------------------------------------------------
	static boolean[] visited;
	public static boolean DFSCheckCycleIsPresent(List<List<Integer>> list) {
		visited = new boolean[list.size()];
		for(int i=0; i<list.size(); i++) {
			boolean cyclic = detectCycle(i, list, false);
			if(cyclic)
				return true;
		}
		return false;
	}
	
	public static boolean detectCycle(int node, List<List<Integer>> list, boolean cyclic) {
		visited[node] = true;
		List<Integer> neighbours = list.get(node);	
		for(int i=0; i<neighbours.size(); i++) {
			int neighbour = neighbours.get(i);
			if(visited[neighbour])
				return true;
			cyclic = detectCycle(neighbour, list, cyclic);
		}
		visited[node] = false;
		return cyclic;
	}

}
