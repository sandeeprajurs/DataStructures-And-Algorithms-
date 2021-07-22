package com.algos.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// O(V+E) ST
public class TopologicalSort {
	//----------------Graph Creation=--------------------------------
	static class Graph{
		int vertex;
		List<List<Integer>> list;
		
		public Graph(int vertex) {
			this.vertex = vertex;
			list= new ArrayList<List<Integer>>();
			for(int i=0; i<vertex; i++)
				list.add(i, new ArrayList<Integer>());
		}
		
		//for unidirectinal purpose
		public void addOneDirectionally(int a, int b) {
			list.get(a).add(b);
		}
		
		//for bidirectinal purpose
		public void addEdge(int a, int b) {
			list.get(a).add(b);
			list.get(b).add(a);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph(6);
		graph.addOneDirectionally(4, 0);
		graph.addOneDirectionally(5, 0);
		graph.addOneDirectionally(5, 2);
		graph.addOneDirectionally(4, 1);
		graph.addOneDirectionally(3, 1);
		graph.addOneDirectionally(2, 3);
		System.out.println(graph.list);
		System.out.println("--------Topological Sort---------");
		topologicalSort(6, graph);
	}
	
	public static void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack, Graph graph) {
		visited[v] = true;
		List<Integer> adjacentElements = graph.list.get(v);
		for(int i=0; i<adjacentElements.size(); i++) {
			int node = adjacentElements.get(i);
			if(visited[node] == false)
				topologicalSortUtil(node, visited, stack, graph);
		}
		stack.push(v);
	}
	
	public static void topologicalSort(int vertix, Graph graph) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] = new boolean[vertix];
		for (int i = 0; i < vertix; i++) {
			if(visited[i] == false)
				topologicalSortUtil(i, visited, stack, graph);
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
	
	

}
