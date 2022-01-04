package com.algos.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TarjansAlgoSCC {

	static int[] low;
	static int[] disc; 
	static boolean[] inStack;  //is used to avoid cross edge
	static Stack<Integer> stack = new Stack<Integer>();
	static int time = 0;
	static List<List<Integer>> resultSCC = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		int[][] edges = new int[5][2];
//		edges[0] = new int[] { 1 };
//		edges[1] = new int[] { 2, 3 };
//		edges[2] = new int[] {};
//		edges[3] = new int[] { 4 };
//		edges[4] = new int[] { 0, 5, 6 };
//		edges[5] = new int[] { 2, 6 };
//		edges[6] = new int[] { 5 };
		
		edges[0] = new int[] { 2, 3 };
		edges[1] = new int[] { 0 };
		edges[2] = new int[] { 1};
		edges[3] = new int[] { 4 };
		edges[4] = new int[] {  };
		low = new int[edges.length];
		disc = new int[edges.length];
		inStack = new boolean[edges.length];
		Arrays.fill(disc, Integer.MAX_VALUE);
		Arrays.fill(low, Integer.MAX_VALUE);
		for (int i = 0; i < edges.length; i++) {
			if (disc[i] == Integer.MAX_VALUE) {
				dfs(i, edges);
				System.out.println(resultSCC);
			}
		}
	}

	public static void dfs(int node, int[][] edges) {
		//update time in disc, low and increment time
		disc[node] = time;
		low[node] = time;
		time++;
		//add node to stack and inStack mark true
		stack.push(node);
		inStack[node] = true;
		
		//get adj nodes for curNode
		int[] adjNodes = edges[node];
		for (int j = 0; j < adjNodes.length; j++) {
			int currNode = adjNodes[j];
			//
			if (disc[currNode] == Integer.MAX_VALUE) {
				//if node not visited we visit it and when coming back we do normal low[u] calculaltion..i.e
				//low[u] = min(low[u], low[v])
				dfs(currNode, edges);
				low[node] = Math.min(low[node], low[currNode]);
			} else if (inStack[currNode]) {
				//back edge condition (backedgs nodes will be present in stack)
				//low[u] = min(low[u], disc[v])
				low[node] = Math.min(low[node], disc[currNode]);
			}
			//cross edge nodes will not be present in stack as we ignore when we get cross edge-- ignored
		}
		if (disc[node] == low[node]) {
			//while backtracking if disc[u] == low[u] then thats head
			List<Integer> temp = new ArrayList<Integer>();
			//pop untill you find u
			while (!stack.isEmpty()) {
				int tempNode = stack.pop();
				inStack[tempNode] = false;
				temp.add(tempNode);
				if (tempNode == node)
					break;
			}
			resultSCC.add(temp);
		}
	}
}
