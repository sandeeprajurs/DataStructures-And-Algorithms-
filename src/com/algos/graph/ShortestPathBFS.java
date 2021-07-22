package com.algos.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//O(V+E) ST
//https://www.geeksforgeeks.org/shortest-path-unweighted-graph/
public class ShortestPathBFS {
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
		Graph graph = new Graph(8);
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(3, 4);
		graph.addEdge(3, 7);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		graph.addEdge(4, 7);
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		printShortestDistance(2, 6, graph, 8);
	}
	
	public static void printShortestDistance(int src, int dest, Graph graph, int vertexLen) {
		//Previos nodes from where distance was computed from source
		int[] predessor = new int[vertexLen];
		//Distance of all the nodes from source
		int[] distance = new int[vertexLen];
		for(int i=0; i<distance.length; i++)
			distance[i] = -1;
		//for source assign distance as 0
		distance[src] = 0;
		//for source there will no predessor vertex
		predessor[src] = -1;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(src);
		findShortestPath(graph, predessor, distance, queue);
		System.out.println(Arrays.toString(distance));
		System.out.println("Shortest distance from Source: "+src+" to destination vertex: "+dest+" is "+distance[dest]);
		int curr = dest;
		List<Integer> path = new ArrayList<Integer>();
		path.add(dest);
		while(predessor[curr] != -1) {
			path.add(predessor[curr]);
			curr = predessor[curr];
		}
		Collections.reverse(path);
		System.out.println("Shortest Path");
		System.out.println(path);
	}
	
	public static void findShortestPath(Graph graph, int[] predessor, int[] distance, Queue<Integer> queue) {
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size > 0) {
				int node = queue.poll();
				List<Integer> adjacentNodes = graph.list.get(node);
				for(int i=0; i<adjacentNodes.size(); i++) {
					int adjNode = adjacentNodes.get(i);
					if(distance[adjNode] == -1 || distance[adjNode] > distance[node]+1) {
						distance[adjNode] =  distance[node]+1;
						predessor[adjNode] = node;
						queue.add(adjNode);
					}
				}
				size--;
			}
		}
	}

}
