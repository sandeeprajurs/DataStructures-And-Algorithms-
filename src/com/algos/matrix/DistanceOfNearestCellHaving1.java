package com.algos.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DistanceOfNearestCellHaving1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int[][] nearest(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n][m];
        Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
        
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                result[i][j] = Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1)
                    result[i][j] = 0;
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(i);
                    temp.add(j);
                    queue.add(temp);
            }
        }
        
        
        while(!queue.isEmpty()){
            List<Integer> temp = queue.poll();
            int x = temp.get(0);
            int y = temp.get(1);
            for(int i=0; i<4; i++){
                int node_x = x + dx[i];
                int node_y = y + dy[i];
                if(isValid(node_x, node_y, n, m) && result[node_x][node_y] > result[x][y] + 1){
                    result[node_x][node_y] = result[x][y] + 1;
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(node_x);
                    list.add(node_y);
                    queue.add(list);
                }
            }
        }
        return result;
    }
    
    public boolean isValid(int x, int y, int n, int m){
        if(x>=0 && x<n && y>=0 && y<m) return true;
        return false;
    }

}
