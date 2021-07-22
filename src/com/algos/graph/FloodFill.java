package com.algos.graph;

public class FloodFill {
	
	//https://leetcode.com/problems/flood-fill/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int oldColor = image[sr][sc];
        boolean[][] visisted = new boolean[image.length][image[0].length];
        reColor(sr, sc, image, newColor, oldColor, visisted);
        return image;
    }
    
    public void reColor(int i, int j, int[][] image, int newColor, int oldColor, boolean[][] visisted){
        image[i][j] = newColor;
        visisted[i][j] = true;
        if (isValid(i + 1, j, image) && image[i + 1][j] == oldColor && visisted[i+1][j] == false) {
			//image[i+1][j] = newColor;
			reColor(i + 1, j, image, newColor, oldColor, visisted);
		}
        if (isValid(i - 1, j, image) && image[i - 1][j] == oldColor && visisted[i-1][j] == false) {
			//image[i-1][j] = newColor;
			reColor(i - 1, j, image, newColor, oldColor, visisted);
		}
        if (isValid(i, j+1, image) && image[i][j+1] == oldColor && visisted[i][j+1] == false) {
			//image[i][j+1] = newColor;
			reColor(i, j+1, image, newColor, oldColor, visisted);
		}
        if (isValid(i, j-1, image) && image[i][j-1] == oldColor && visisted[i][j-1] == false) {
			//image[i][j-1] = newColor;
			reColor(i, j-1, image, newColor, oldColor, visisted);
		}
    }
    
    public static boolean isValid(int i, int j, int[][] grid) {
		if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length -1)
			return false;
		return true;
	}

}
