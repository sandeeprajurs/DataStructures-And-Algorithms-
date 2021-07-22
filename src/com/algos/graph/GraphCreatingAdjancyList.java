package com.algos.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphCreatingAdjancyList {

	public static void main(String[] args) {
		Graph graph = new Graph(4);
		graph.addOneDirectionally(0, 1);
		graph.addOneDirectionally(1, 2);
		graph.addOneDirectionally(1, 3);
		graph.addOneDirectionally(2, 3);
		graph.addOneDirectionally(3, 1);
		System.out.println(graph.list);
	}
	
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
}
