package com.algos.graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {
	
	static class Graph{
		int vertex;
		List<List<Integer>> list;
		
		public Graph(int vertex) {
			this.vertex = vertex;
			list= new ArrayList<List<Integer>>();
			for(int i=0; i<vertex; i++)
				list.add(i, new ArrayList<Integer>());
		}
		
		public void addEdge(int a, int b) {
			list.get(a).add(b);
		}

	}
	
	//we track if node is visited or not
	static boolean visited[];
	public static void main(String[] args) {
		Graph graph = new Graph(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 1);
		graph.addEdge(4, 2);
		graph.addEdge(4, 5);
		System.out.println(graph.list);
		visited = new boolean[graph.vertex];
		dfs(0, graph.list);
	}
	
	// s
	// 0 :[1,2]
	// 1 : [3]
	//`2 : []
	// 3 : [4, 5]
	// -----
	// ---
	public static void dfs(int s, List<List<Integer>> list) {        
		visited[s] = true;														
		System.out.println(s);
		//run for ith list in the list
		List<Integer> neighbours = list.get(s);	
		for(int i=0; i<neighbours.size(); i++) {
			if(visited[neighbours.get(i)] == false)
				dfs(neighbours.get(i), list);
		}
	}
}
