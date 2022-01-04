package com.algos.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.algos.graph.CycleInDirectedGraph.Graph;

//similar to directed graph cycle difference is we trace parent
public class CycleInUndirectedGraph {
	
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

			// for bidirectinal purpose
			public void addEdge(int a, int b) {
				list.get(a).add(b);
				list.get(b).add(a);
			}
		}
	
	public static void main(String[] args) {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(0, 3);
		System.out.println(graph.list);
		System.out.println(DFSCheckCycleIsPresent(graph.list));
	}
	
	static boolean[] visited;
	public static boolean DFSCheckCycleIsPresent(List<List<Integer>> list) {
		visited = new boolean[list.size()];
		for(int i=0; i<list.size(); i++) {
			boolean cyclic = detectCycle(i, -1, list, false);
			if(cyclic)
				return true;
		}
		return false;
	}
	
	public static boolean detectCycle(int node, int parent, List<List<Integer>> list, boolean cyclic) {
		visited[node] = true;
		List<Integer> neighbours = list.get(node);	
		for(int i=0; i<neighbours.size(); i++) {
			int neighbour = neighbours.get(i);
			if(visited[neighbour] && neighbour != parent)
				return true;
			else if(visited[neighbour])
				continue;
			cyclic = detectCycle(neighbour, node, list, cyclic);
		}
		visited[node] = false;
		return cyclic;
	}
}
