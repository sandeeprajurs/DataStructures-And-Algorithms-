package com.algos.graph;

public class FloydWarshellAlgo {

	public static void main(String[] args) {
		int[][] graph = new int[4][4];
//		graph[0] = new int[] {0, 1, 4, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
//		graph[1] = new int[] {Integer.MAX_VALUE, 0, 4, 2, 7, Integer.MAX_VALUE};
//		graph[2] = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 3, 4, Integer.MAX_VALUE};
//		graph[3] = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 4};
//		graph[4] = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3, 0, Integer.MAX_VALUE};
//		graph[5] = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 5, 0};
		
		graph[0] = new int[] {0, 3, Integer.MAX_VALUE, 5};
		graph[1] = new int[] {2, 0, Integer.MAX_VALUE, 8};
		graph[2] = new int[] {Integer.MAX_VALUE, 1, 0, Integer.MAX_VALUE};
		graph[3] = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, 2, 0};
		floydWarshellAlgo(graph);
	}
	
	
	static void floydWarshellAlgo(int graph[][]) {
		//copy the graph
		int[][] dist =  new int[graph.length][graph[0].length];
		
		for(int i=0; i<dist.length; i++)
			for(int j=0; j<dist[0].length; j++)
				dist[i][j] = graph[i][j];
		
		for(int k=0; k<dist.length; k++) { //for every kth value ie every node
			for(int i=0; i<dist.length; i++) {
				for(int j=0; j<dist[0].length; j++) {
					if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) 
						continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]); //formula
				}
			}
		}
		
		//if negative weight cycle diagnols will be negative ie 0-0 -> -ve or 3-3 -ve...
		for(int i=0; i<dist.length; i++) {
			if(dist[i][i] < 0) {
				System.out.println("Negative edge weight cycle is present");
				return;
			}
		}
		
		for(int i=0; i<dist.length; i++) {
			for(int j=0; j<dist[0].length; j++) {
				System.out.println("i ="+ i +" to j ="+j+" distance is "+dist[i][j]);
			}
		}

	}
	
}
