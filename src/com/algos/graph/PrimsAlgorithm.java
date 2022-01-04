package com.algos.graph;

import java.util.Arrays;

public class PrimsAlgorithm {
	
	static int[] values;
	static boolean[] processed;
	static int[] parent;
	
	public static void main(String[] args) {
		int[][][] edges = new int[6][3][2];
		edges[0] = new int[][] { new int[] { 1, 4 }, new int[] { 2, 6 } };
		edges[1] = new int[][] { new int[] { 0, 4 }, new int[] { 2, 6 }, new int[] { 3, 3 }, new int[] { 4, 4 } };
		edges[2] = new int[][] { new int[] { 0, 6 }, new int[] { 1, 6 }, new int[] { 3, 1 } };
		edges[3] = new int[][] { new int[] { 2, 1 }, new int[] { 1, 3 }, new int[] { 4, 2 }, new int[] { 5, 3 } };
		edges[4] = new int[][] { new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 5, 7 }};
		edges[5] = new int[][] { new int[] { 4, 7 }, new int[] { 3, 3 }};
		parent = new int[edges.length];
		values = new int[edges.length];
		processed = new boolean[edges.length];
		primsAlgo(edges);
	}
	
	static void primsAlgo(int[][][] edges) {
		
		Arrays.fill(values, Integer.MAX_VALUE);
		values[0] = 0;
		parent[0] = -1;
		
		for(int i=0;i<edges.length;i++) {
			int[] temp = getMinValue();
			int u = temp[0];
//			int uDistance = temp[1];
			int[][] adjNodes = edges[u];
			processed[u] = true;
			for(int j=0; j<adjNodes.length; j++) {
				int v = adjNodes[j][0];
				int vDistance = adjNodes[j][1];
				
				if(processed[v]) continue;
				
				if(vDistance < values[v]) {
					values[v] = vDistance;
					parent[v] = u;
				}
			}
		}
		System.out.println(Arrays.toString(values));
		System.out.println(Arrays.toString(parent));
	}
	
	static int[] getMinValue() {
		int minDis = Integer.MAX_VALUE;
		int index = -1;
		for(int i=0; i<values.length; i++) {
			if(processed[i])
				continue;
			if(values[i] < minDis) {
				minDis = values[i];
				index = i;
			}
		}
		return new int[] {index, minDis};
		
	}
}
