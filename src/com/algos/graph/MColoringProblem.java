package com.algos.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MColoringProblem {

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
//			list.get(b).add(a);
		}
	}

	static int[] nodeColors;
	static int[] colors;
	public static void main(String[] args) {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 3);
		graph.addEdge(1, 0);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 1);
		graph.addEdge(3, 0);
		graph.addEdge(3, 1);
		System.out.println(graph.list);

		colors = new int[] {1,2,3};
		nodeColors = new int[graph.list.size()];
		System.out.println(solve(0, graph.list));
		System.out.println(Arrays.toString(nodeColors));
	}
	
	static boolean solve(int node, List<List<Integer>> list){
		if(list.size() == node) return true;
		
		for(int i=0; i<colors.length; i++) {
			if(isSafe(node, list, colors[i])) {
				nodeColors[node] = colors[i];
				if(solve(node+1, list)) return true;
				nodeColors[node] = -1;
			}
		}
		return false;
	}
	
	static boolean isSafe(int node, List<List<Integer>> list, int color) {
		List<Integer> adjNodes = list.get(node);
		for(int i=0; i<adjNodes.size(); i++) {
			int adjNode = adjNodes.get(i);
			if(nodeColors[adjNode] == color) return false;
		}
		return true;
	}
}
