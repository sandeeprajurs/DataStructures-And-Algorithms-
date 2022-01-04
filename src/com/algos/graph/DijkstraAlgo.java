package com.algos.graph;

import java.util.Arrays;

public class DijkstraAlgo {

	static int[] parent;
	static int[] value;
	static boolean[] processed;

	public static void main(String[] args) {
		int[][][] edges = new int[6][3][2];
		edges[0] = new int[][] { new int[] { 1, 7 } };
		edges[1] = new int[][] { new int[] { 2, 6 }, new int[] { 3, 20 }, new int[] { 4, 3 } };
		edges[2] = new int[][] { new int[] { 3, 14 } };
		edges[3] = new int[][] { new int[] { 4, 2 } };
		edges[4] = new int[][] {};
		edges[5] = new int[][] {};
		parent = new int[edges.length];
		value = new int[edges.length];
		processed = new boolean[edges.length];

		parent[0] = -1;
		Arrays.fill(value, Integer.MAX_VALUE);
		value[0] = 0;

		dijkstra(edges);
	}

	static void dijkstra(int[][][] edges) {
		for (int i = 0; i < edges.length; i++) {
			int[] vertexAndDistance = getSmallestValue();

			int currVertex = vertexAndDistance[0];
			int currDistance = vertexAndDistance[1];
			
			if(currDistance == Integer.MAX_VALUE)
				break;
			int[][] neighbours = edges[currVertex];
			processed[currVertex] = true;

			for (int j = 0; j < neighbours.length; j++) {
				int[] nodeDistance = neighbours[j];
				int adjNode = nodeDistance[0];
				int adjDistance = nodeDistance[1];
				if (processed[adjNode])
					continue;
				int minDis = adjDistance + currDistance;
				if (value[adjNode] >= minDis) {
					value[adjNode] = minDis;
					parent[adjNode] = currVertex;
				}
			}
		}
		System.out.println(Arrays.toString(value));
	}

	static int[] getSmallestValue() {
		int minDistance = Integer.MAX_VALUE;
		int vertex = -1;
		for (int i = 0; i < value.length; i++) {
			if (processed[i])
				continue;
			if (value[i] < minDistance) {
				minDistance = Math.min(minDistance, value[i]);
				vertex = i;
			}
		}
		return new int[] { vertex, minDistance };
	}
}
