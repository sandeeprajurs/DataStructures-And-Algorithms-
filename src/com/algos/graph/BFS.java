package com.algos.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BFS {

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

	// we track if node is visited or not
	static boolean visited[];
	static java.util.Queue<Integer> queue;

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
		visited = new boolean[graph.vertex];
		queue = new LinkedList<Integer>();
		bfs(0, graph.list);
	}

	private static void bfs(int j, List<List<Integer>> list) {
		queue.add(0);
		visited[0] = true;
		while (!queue.isEmpty()) {
			Integer currEle = queue.poll();
			System.out.println(currEle);
			for (int i = 0; i < list.get(currEle).size(); i++) {
				if (visited[list.get(currEle).get(i)] == false) {
					queue.add(list.get(currEle).get(i));
					visited[list.get(currEle).get(i)] = true;
				}
			}
		}
	}
}
