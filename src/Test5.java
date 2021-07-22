import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test5 {
	static class Node{
		public Node(int i) {
			this.data = i;
		}

		int data;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] arr = new int[6][6];
//		arr[0] = new int[]{1, 0, 0, 0, 0, 0};
//		arr[1] = new int[]{0, 1, 0, 1, 1, 1};
//		arr[2] = new int[]{0, 0, 1, 0, 1, 0};
//		arr[3] = new int[]{1, 1, 0, 0, 1, 0};
//		arr[4] = new int[]{1, 0, 1, 1, 0, 0};
//		arr[5] = new int[]{1, 0, 0, 0, 0, 1};
//		System.out.println(Arrays.deepToString(removeIslands(arr)));
		Map<Integer, Node> map = new HashMap<Integer, Node>();
		map.put(0, new Node(1));
		Node node = map.get(0);
		node.data = 2;
		System.out.println(map.get(0).data);
	}

	public static int[][] removeIslands(int[][] matrix) {
		boolean[][] visisted = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (visisted[i][j])
					continue;
				traverse(i, j, matrix, false, visisted);
			}
		}
		return matrix;
	}

	public static boolean traverse(int i, int j, int[][] matrix, boolean isPresentInCorner, boolean[][] visisted) {
		if(i==1 && j==3)
			System.out.println("print");
		if (visisted[i][j])
			return isPresentInCorner;
		visisted[i][j] = true;
		if (matrix[i][j] == 0)
			return isPresentInCorner;
		if (i == 0 || i == matrix.length - 1 || j == 0 || j == matrix[i].length - 1)
			isPresentInCorner = true;
		List<Integer[]> neighbours = getNeighbours(matrix, i, j, visisted);
		for (Integer[] neighbour : neighbours) {
			boolean temp = traverse(neighbour[0], neighbour[1], matrix, isPresentInCorner, visisted);
			if (temp)
				isPresentInCorner = true;
		}
		if (isPresentInCorner == false)
			matrix[i][j] = 0;
		return isPresentInCorner;
	}

	public static List<Integer[]> getNeighbours(int[][] matrix, int i, int j, boolean[][] visisted) {
		List<Integer[]> neighbours = new ArrayList<Integer[]>();
		if (j > 0 && !visisted[i][j - 1])
			neighbours.add(new Integer[] { i, j - 1 });
		if (j < matrix[0].length - 1 && !visisted[i][j + 1])
			neighbours.add(new Integer[] { i, j + 1 });
		if (i > 0 && !visisted[i - 1][j])
			neighbours.add(new Integer[] { i - 1, j });
		if (i < matrix.length - 1 && !visisted[i + 1][j])
			neighbours.add(new Integer[] { i + 1, j });
		return neighbours;
	}

}
