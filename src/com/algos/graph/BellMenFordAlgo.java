package com.algos.graph;

import java.util.Arrays;

public class BellMenFordAlgo {

	static int[] values;

	public static void main(String[] args) {
		int[][][] edges = new int[3][1][2];
//		edges[0] = new int[][] { new int[] { 1, 1 }, {2, 4} };
//		edges[1] = new int[][] { new int[] { 2, -2 }, new int[] { 3, 2} };
//		edges[2] = new int[][] { new int[] { 3, 3 } };
//		edges[3] = new int[][] { new int[] { 4, 4 } };
//		edges[4] = new int[][] { new int[] { 1, -3 } };

		edges[0] = new int[][]{ new int[] { 1, 2 }};
		edges[1] = new int[][]{ new int[] { 2, 3 }};
		edges[2] = new int[][]{ new int[] { 0, -7 } };

//		edges[0] = new int[] { 0, 1, 1 };
//		edges[1] = new int[] { 0, 2, 4 };
//		edges[2] = new int[] { 1, 2, -2 };
//		edges[3] = new int[] { 1, 3, 2 };
//		edges[4] = new int[] { 2, 3, 3 };
//		edges[5] = new int[] { 3, 4, 4 };
//		edges[6] = new int[] { 4, 1, -3 };
		bellMenFord(edges, 5);
	}

	public static void bellMenFord(int[][][] edges, int vertex) {
		values = new int[vertex];
		Arrays.fill(values, Integer.MAX_VALUE);
		values[0] = 0;
		int count = vertex - 1;
		boolean flag = false;
		while (count >= 0) {
			flag = false;
			for (int u = 0; u < edges.length; u++) {
				int[][] adjNodes = edges[u];
				for (int i = 0; i < adjNodes.length; i++) {
					int v = adjNodes[i][0];
					int vDis = adjNodes[i][1];
					int minDis = values[u] + vDis;
					if (values[v] > minDis) {
						values[v] = minDis;
						flag = true;
					}
				}
			}

//			System.out.println(Arrays.toString(values));
			if (flag == false)
				break;
			count--;
		}

		if (flag == true) {
			for (int u = 0; u < edges.length; u++) {
				int[][] adjNodes = edges[u];
				for (int i = 0; i < adjNodes.length; i++) {
					int v = adjNodes[i][0];
					int vDis = adjNodes[i][1];
					int minDis = values[u] + vDis;
					if (values[v] > minDis) {
						System.out.println("Its a -ve edge cycle graph can find shortest path");
						return;
					}
				}
			}
		}
		System.out.println(Arrays.toString(values));
	}
}
