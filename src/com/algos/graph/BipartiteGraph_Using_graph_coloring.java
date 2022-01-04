package com.algos.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraph_Using_graph_coloring {

	static class Graph {
		int vertex;
		List<List<Integer>> list;

		public Graph(int vertex) {
			this.vertex = vertex;
			list = new ArrayList<List<Integer>>();
			for (int i = 0; i < vertex; i++)
				list.add(i, new ArrayList<Integer>());
		}

		public void addEdge(int a, int b) {
			list.get(a).add(b);
			list.get(b).add(a);
		}

	}

	// same as dfs but hgere we track color
	// 1 and 0 is used for coloring the graph with formula currNodeColor = color-1
	static int[] color;

	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(3, 2);
		System.out.println(graph.list);
		color = new int[graph.list.size()];
		System.out.println(isBipartite(graph.list));
	}

	public static boolean isBipartite(List<List<Integer>> list) {
		
		for(int i=0; i<list.size(); i++) {
			Arrays.fill(color, -1);
			color[i] = 1;
//			boolean isBiPartite = dfs(i, 1, list, false);
			boolean isBiPartite = bfs(list, i);
			if (isBiPartite == false)
				return false;
		}
		return true;
	}

	//using dfs
	private static boolean dfs(int node, int currColor, List<List<Integer>> list, boolean isCyclic) {
		List<Integer> neighbours = list.get(node);
		for (int i = 0; i < neighbours.size(); i++) {
			if (color[neighbours.get(i)] == currColor) return false;
			if (color[neighbours.get(i)] != -1) continue;
			color[neighbours.get(i)] = 1 - currColor;
			isCyclic = dfs(neighbours.get(i), color[neighbours.get(i)], list, isCyclic);
		}
		return isCyclic;
	}
	
	//using bfs
	private static boolean bfs(List<List<Integer>> list, int start) {
		Queue<Integer> queue= new LinkedList<Integer>();
		queue.add(start);
		while(!queue.isEmpty()) {
			int node = queue.poll();
			int currentColor = color[node];
			List<Integer> neighbours = list.get(node);
			for(int i=0; i<neighbours.size(); i++) {
				if(color[neighbours.get(i)] == currentColor) return false;
				if(color[neighbours.get(i)] != -1) continue;
				color[neighbours.get(i)] = 1-currentColor;
				queue.add(neighbours.get(i));
			}
		}
		return true;
	}
}
