package com.algos.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BellmanFordAlgorithm {

	public static void main(String[] args) {
//		int[][] edges = new int[9][3];
//		edges[0] = new int[]{0, 1, 4};
//		edges[1] = new int[]{0, 2, 5};
//		edges[2] = new int[]{0, 3, 6};
//		edges[3] = new int[]{1, 2, -3};
//		edges[4] = new int[]{2, 5, 4};
//		edges[5] = new int[]{1, 2, -3};
//		edges[6] = new int[]{3, 4, 2};
//		edges[7] = new int[]{4, 5, 2};
//		edges[8] = new int[]{5, 4, 1};
//		int[] vertices = new int[]{0,1,2,3,4,5};  
		
		int[][] edges = new int[4][3];
		edges[0] = new int[] {0, 1, 1};
		edges[1] = new int[] {1, 2, 3};
		edges[2] = new int[] {2, 3, 2};
		edges[3] = new int[] {3, 1, -6};
		int[] vertices = new int[]{0,1,2,3};  
		bellmanFordAlgorithm(edges, vertices, 0);
	}
	
	//O(V*E) Time || O(V) Space
	public static void bellmanFordAlgorithm(int[][] edges, int[] vertices, int src) {
		//vertex : ['distance', 'parent']
		Map<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
		for(int i=0; i<vertices.length; i++)
			map.put(vertices[i], new Integer[] {Integer.MAX_VALUE, Integer.MAX_VALUE});
		map.put(src, new Integer[] {0, 0});
		
		//vertix - 1 times
		int count = vertices.length;
		while(count > 0) {
			for(int i=0; i<edges.length; i++) {
				int u= edges[i][0];
				int v= edges[i][1];
				int weight = edges[i][2];
				int uDistance = map.get(u)[0];
				int vDistance = map.get(v)[0];
				if(uDistance+weight <= vDistance) {
					map.put(v, new Integer[] {uDistance+weight, u});
				}
			}
			count--;
		}
		
		System.out.println("Vertex------[Distance, Parent]");
		for(int i: map.keySet()) {
			System.out.println(i+"-----------"+Arrays.toString(map.get(i)));
		}
		
		System.out.println("Does graph has negative cycle");
		for(int i=0; i<edges.length; i++) {
			int u= edges[i][0];
			int v= edges[i][1];
			int weight = edges[i][2];
			int uDistance = map.get(u)[0];
			int vDistance = map.get(v)[0];
			if(uDistance+weight < vDistance) {
				System.out.println("Yes Graph has negative cycle");
				break;
			}
		}
		
	}

}
