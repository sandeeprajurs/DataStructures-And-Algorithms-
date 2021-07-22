package com.algos.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//O(V+E) ST
public class MinimumTimeTakenForEachJobToComplete {

	// ----------------Graph Creation=--------------------------------
	static class Graph {
		Map<Integer, ArrayList<Integer>> graphMap;

		public Graph(List<Integer> vertex) {
			graphMap = new HashMap<Integer, ArrayList<Integer>>();
			for(int i=0; i<vertex.size(); i++) {
				graphMap.put(vertex.get(i), new ArrayList<Integer>());
			}
		}

		// for unidirectinal purpose
		public void addOneDirectionally(int a, int b) {
			if(!graphMap.containsKey(a))
				graphMap.put(a, new ArrayList<Integer>());
			graphMap.get(a).add(b);
		}
	}
	// ---------------------------------------------------------------------
	
	
	public static void main(String[] args) {
//		List<Integer> jobs = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//		Graph graph = new Graph(jobs);
//		graph.addOneDirectionally(1, 3);
//		graph.addOneDirectionally(1, 4);
//		graph.addOneDirectionally(1, 5);
//		graph.addOneDirectionally(2, 3);
//		graph.addOneDirectionally(2, 9);
//		graph.addOneDirectionally(2, 8);
//		graph.addOneDirectionally(3, 6);
//		graph.addOneDirectionally(4, 6);
//		graph.addOneDirectionally(4, 8);
//		graph.addOneDirectionally(5, 8);
//		graph.addOneDirectionally(6, 7);
//		graph.addOneDirectionally(7, 8);
//		graph.addOneDirectionally(8, 10);
		
		List<Integer> jobs = Arrays.asList(1,2,3,4,5,6,7);
		Graph graph = new Graph(jobs);
		graph.addOneDirectionally(1, 2);
		graph.addOneDirectionally(2, 3);
		graph.addOneDirectionally(2, 4);
		graph.addOneDirectionally(2, 5);
		graph.addOneDirectionally(3, 6);
		graph.addOneDirectionally(4, 6);
		graph.addOneDirectionally(5, 7);
		findMinTimeTakenForEachJob(jobs, graph);
	}
	
	public static void findMinTimeTakenForEachJob(List<Integer> jobs, Graph graph) {
		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		Map<Integer, Integer> distance = new HashMap<Integer, Integer>();
		for(int i=0; i<jobs.size(); i++) {
			distance.put(jobs.get(i), 0);
			visited.put(jobs.get(i), false);
		}
		
		for(int i=0; i<jobs.size(); i++) {
			int currNode = jobs.get(i);
			if(visited.get(currNode) == false)
				findMinTimeForEachJobUtil(currNode, distance, visited, graph, distance.get(currNode)+1);
		}
		System.out.println(distance);
	}
	
	public static void findMinTimeForEachJobUtil(int job, Map<Integer, Integer> distance, Map<Integer, Boolean> visited, Graph graph, int prevdist) {
		visited.put(job, true);
		if(distance.get(job) < prevdist)
			distance.put(job, prevdist);
		ArrayList<Integer> neighbors = graph.graphMap.get(job);
		for(int i=0; i<neighbors.size(); i++) {
			int neighbor = neighbors.get(i);
			if(visited.get(neighbor) == false)
				findMinTimeForEachJobUtil(neighbor, distance, visited, graph, distance.get(job)+1);
		}
	}

}
