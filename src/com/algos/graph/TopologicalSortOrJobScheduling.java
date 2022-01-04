package com.algos.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TopologicalSortOrJobScheduling {
	
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
		}

	}
	
	static Stack<Integer> stack;
	static boolean[] visisted;
	public static void main(String[] args) {
		Graph graph = new Graph(6);
		graph.addEdge(0, 3);
		graph.addEdge(0, 2);
		graph.addEdge(3, 1);
		graph.addEdge(4, 1);
		graph.addEdge(4, 2);
		graph.addEdge(5, 2);
		graph.addEdge(5, 0);
		
//		graph.addEdge(0, 1);
//		graph.addEdge(0, 2);
//		graph.addEdge(2, 1);
//		graph.addEdge(3, 1);
//		graph.addEdge(3, 2);
		
//		graph.addEdge(5, 2);
//		graph.addEdge(5, 0);
//		graph.addEdge(4, 0);
//		graph.addEdge(4, 1);
//		graph.addEdge(2, 3);
//		graph.addEdge(3, 1);
		
//		graph.addEdge(0, 2);
//		graph.addEdge(2, 3);
//		graph.addEdge(3, 1);
//		graph.addEdge(1, 0);
		
		stack = new Stack<Integer>();
		visisted = new boolean[graph.list.size()];
		
		for(int i=0; i<graph.list.size(); i++) {
			Arrays.fill(visisted, false);
			boolean isCyclic = isCyclic(i, graph.list, false);
			if(isCyclic) {
				System.out.println("Its not a DAG so cant do topological sort");
				return;
			}
		}
		
		stack.clear();
		Arrays.fill(visisted, false);
		for(int i=0; i<graph.list.size(); i++) {
			if(visisted[i] == false) {
				dfs(i, graph.list);
			}
		}
		Collections.reverse(stack);
		System.out.println(stack);
	}
	
	public static boolean isCyclic(int node, List<List<Integer>> list, boolean cyclic) {
		visisted[node] = true;
		List<Integer> neighbours= list.get(node);
		for(int i=0; i<neighbours.size(); i++) {
			if(visisted[neighbours.get(i)])
				return true;
			cyclic = isCyclic(neighbours.get(i), list, cyclic);
		}
		visisted[node] = false;
		return cyclic;
	}
	
	
	public static void dfs(int node, List<List<Integer>> list) {
		visisted[node] = true;
		List<Integer> neighbours= list.get(node);
		for(int i=0; i<neighbours.size(); i++) {
			if(visisted[neighbours.get(i)] == false)
				dfs(neighbours.get(i), list);
		}
		stack.push(node);
	}
	
	
}
