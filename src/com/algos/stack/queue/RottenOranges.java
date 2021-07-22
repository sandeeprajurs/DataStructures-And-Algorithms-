package com.algos.stack.queue;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	int i;
	int j;
	int iteration;

	public Node(int i, int j, int iteration) {
		this.i = i;
		this.j = j;
		this.iteration = iteration;
	}
}

public class RottenOranges {
	
	public static void main(String[] args) {
		RottenOranges ro = new RottenOranges();
		int[][] grid =  {{1},{1}, {1}, {1}};
		System.out.println(ro.rottenOranges(grid));
	}

	public int rottenOranges(int[][] grid){
		Queue<Node> q = new LinkedList<Node>();
		int result = addAllOrangesToQueue(grid, q);
		int times = 0;
		if(result == -1)
			return -1;
		while(!q.isEmpty()) {
			Node node = q.poll();
			int i = node.i;
			int j = node.j;
			int iteration = node.iteration; 
			if(i-1>=0 && grid[i-1][j] == 1) {
				grid[i-1][j] = 2;
				q.add(new Node(i-1, j, iteration+1));
				times = iteration+1 > times ? iteration+1 : times;
			}
			if(i+1<grid.length && grid[i+1][j] == 1) {
				grid[i+1][j] = 2;
				q.add(new Node(i+1, j, iteration+1));
				times = iteration+1 > times ? iteration+1 : times;
			}
			if(j-1>=0 && grid[i][j-1] == 1) {
				grid[i][j-1] = 2;
				q.add(new Node(i, j-1, iteration+1));
				times = iteration+1 > times ? iteration+1 : times;
			}
			if(j+1<grid[0].length && grid[i][j+1] == 1) {
				grid[i][j+1] = 2;
				q.add(new Node(i, j+1, iteration+1));
				times = iteration+1 > times ? iteration+1 : times;
			}
		}
		return times == 0 ? -1 : times;
	}

	public int addAllOrangesToQueue(int[][] grid, Queue<Node> q) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 2) {
					q.add(new Node(i, j, 0));
				} else if(grid[i][j] == 1){
					boolean hasOranges = false;
					if (i - 1 >= 0 && (grid[i - 1][j] == 1 || grid[i - 1][j] == 2))
						hasOranges = true;
					else if (j - 1 >= 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] == 2))
						hasOranges = true;
					else if (i + 1 < grid.length && (grid[i + 1][j] == 1 || grid[i + 1][j] == 2))
						hasOranges = true;
					else if (j + 1 < grid[0].length && (grid[i][j + 1] == 1 || grid[i][j + 1] == 2))
						hasOranges = true;
					if (!hasOranges)
						return -1;
				}
			}
		}
		return 1;
	}
}
