package com.algos.graph;

import java.util.ArrayList;
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
		public void addOneDirectionally(int a, int b) {
			list.get(a).add(b);
		}

		// for bidirectinal purpose
		public void addEdge(int a, int b) {
			list.get(a).add(b);
			list.get(b).add(a);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph(4);
		graph.addOneDirectionally(0, 1);
		graph.addOneDirectionally(1, 2);
		graph.addOneDirectionally(1, 3);
		graph.addOneDirectionally(2, 3);
		graph.addOneDirectionally(3, 1);
		System.out.println(graph.list);
		System.out.println(DFSCheckCycleIsPresent(graph.list));
	}
	
	//---------Detect Cycles in Graph-----------------------------------------------------
	public static boolean DFSCheckCycleIsPresent(List<List<Integer>> list) {
		boolean[] visited = new boolean[list.size()];
		int[] stack = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			if(visited[i] == false) {
				boolean cyclic = detectCycle(i, list, visited, stack, false);
				if(cyclic)
					return true;
			}
		}
		return false;
	}
	
	public static boolean detectCycle(int node, List<List<Integer>> list, boolean[] visited, int[] stack, boolean cyclic) {
		visited[node] = true;
		stack[node] = 1;
		List<Integer> neighbours = list.get(node);	
		for(int i=0; i<neighbours.size(); i++) {
			int neighbour = neighbours.get(i);
			if(stack[neighbour] == 1)
				return true;
			if(visited[neighbour])
				continue;
			cyclic = detectCycle(neighbour, list, visited, stack, cyclic);
		}
		stack[node] = 0;
		return cyclic;
	}

}
