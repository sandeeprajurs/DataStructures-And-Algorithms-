import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {
	public static void main(String[] args) {
//		BSTCustom bst = new BSTCustom(50);
//		bst.insert(8);
//		bst.insert(5);
//		bst.insert(9);
//		bst.insert(2);
//		bst.insert(7);
//		bst.insert(1);
//		bst.remove(50);
//		bst.remove(55);
//		System.out.println(bst.contains(55));
//		List<Integer> list = new ArrayList<Integer>();
//		postOrderTraversal(bst, list);
//		System.out.println(list);
//		Test t = new Test();
//		t.tempRoot = bst;
//	    System.out.println(t.isBSTDeadEnd(bst));

//	    int[] arr = {4,5,1,2,0,6};
//	    Arrays.sort(arr);
//	    reverseArray(arr);
//	    System.out.println(Arrays.toString(arr));
		Test test = new Test();
		int num = test.validStartingCity(new int[] { 5, 25, 15, 10, 15 }, new int[] { 1, 2, 1, 0, 3 }, 10);
		System.out.println(num);
		List<Job> list = new ArrayList<Test.Job>();
		list.add(new Job(1));
		list.add(new Job(2));
		Job job = Collections.max(list, Comparator.comparing(o -> o.profit));
		System.out.println(job.profit);
	}
	
	static class Job {
		int profit;
		public Job(int i) {
			profit = i;
		}
		
		public int getProfit() {
			return profit;
		}
	}

	public static void reverseArray(int[] arr) {
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}

	public static void inOrderTraversal(BSTCustom bst, List<Integer> arr) {
		if (bst.left != null)
			inOrderTraversal(bst.left, arr);
		arr.add(bst.value);
		if (bst.right != null)
			inOrderTraversal(bst.right, arr);
	}

	public static void preOrderTraversal(BSTCustom bst, List<Integer> arr) {
		arr.add(bst.value);
		if (bst.left != null)
			preOrderTraversal(bst.left, arr);
		if (bst.right != null)
			preOrderTraversal(bst.right, arr);
	}

	public static void postOrderTraversal(BSTCustom bst, List<Integer> arr) {
		if (bst.left != null)
			postOrderTraversal(bst.left, arr);
		if (bst.right != null)
			postOrderTraversal(bst.right, arr);
		arr.add(bst.value);
	}

	BSTCustom tempRoot;

	public boolean isBSTDeadEnd(BSTCustom root) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null) {
			if ((search(root.value - 1, tempRoot) && search(root.value + 1, tempRoot)))
				return true;
			else
				return false;
		}
		return isBSTDeadEnd(root.left) || isBSTDeadEnd(root.right);
	}

	public boolean search(int val, BSTCustom tempRoot) {
		if (val == 0)
			return true;
		if (val < tempRoot.value) {
			if (tempRoot.left != null)
				return search(val, tempRoot.left);
			else
				return false;
		} else if (val > tempRoot.value) {
			if (tempRoot.right != null)
				return search(val, tempRoot.right);
			else
				return false;
		} else {
			return true;
		}
	}

	public int validStartingCity(int[] distances, int[] fuel, int mpg) {
		int front = 0;
		int rear = 0;
		int i = 0;
		int canTravel = 0;
		while (i < distances.length * 2) {
			if ((rear - front) == distances.length)
				break;

			int idx = i % distances.length;
//			canTravel += (mpg * fuel[idx]);

			if ((mpg * fuel[idx]) + canTravel >= distances[idx]) {
				rear = (rear + 1) % distances.length;
				canTravel = (canTravel + (mpg * fuel[idx])) - distances[idx];
				
			} else {
				rear = (rear + 1) % distances.length;
				front = rear;
				canTravel = 0;
			}
			i++;
		}
		return front;
	}
}
