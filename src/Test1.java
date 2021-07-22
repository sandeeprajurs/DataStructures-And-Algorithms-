import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class CircularQueue {
	int[] arr = new int[5];
	int front = -1;
	int rear = -1;
	int max = arr.length;

	public void push(int element) {
		if ((front == 0 && rear == max - 1) || (rear + 1) == front)
			System.out.println("Queue is filled");
		else if (front == -1) {
			rear = 0;
			front = 0;
		} else if (rear == max - 1) {
			rear = 0;
		} else {
			rear++;
		}
		arr[rear] = element;
	}

	public int pop() {
		if (front == -1 && rear == -1) {
			System.out.println("Queue is empty");
			return -1;
		} else {
			int x = arr[front];
			if (front + 1 == rear) {
				front = -1;
				rear = -1;
			} else if (front == max - 1) {
				front = 0;
			} else {
				front++;
			}
			return x;
		}
	}

	public void print() {
		if (front > rear) {
			for (int i = front; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
		}
		for (int i = 0; i <= rear; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}

public class Test1 {

	public static void main(String[] args) {
//		CircularQueue queue = new CircularQueue();
//		queue.push(1);
//		queue.push(2);
//		queue.push(3);
//		queue.push(4);
//		queue.push(5);
//		queue.pop();
//		queue.pop();
//		queue.pop();
//		queue.pop();
//		queue.pop();
//		queue.push(6);
//		queue.push(7);
//		queue.push(8);
//		queue.push(9);
//		queue.push(10);
//		queue.push(11);
//		queue.print();
//		queue.print();
//		queue.print();

//		int[] result = nextGreaterElement(new int[] { -8, -1, -1, -2, -4, -5, -6, 0, -9, -91, -2, 8 });
//		System.out.println(Arrays.toString(result));
		
		System.out.println(Arrays.toString(printFirstNegativeInteger(new long[]{12, -1, -7, 8, -15, 30, 16, 28}, 8, 3)));
	}

	public static int[] nextGreaterElement(int[] array) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		int[] result = new int[array.length];
		Arrays.fill(result, -1);
		int idx = 1;
		while (idx < array.length * 2) {
			int tempIdx = idx % array.length;
			while (!stack.isEmpty() && array[stack.peek()] < array[tempIdx]) {
				result[stack.pop()] = array[tempIdx];
			}

			if (!stack.isEmpty() && array[tempIdx] <= array[stack.peek()]) {
				stack.push(tempIdx);
			}

			if (stack.isEmpty()) {
				stack.push(tempIdx);
			}
			idx++;
		}
		return result;
	}

	public static long[] printFirstNegativeInteger(long A[], int N, int K) {
		Queue<Integer> queue = new LinkedList<Integer>();
		List<Long> list = new ArrayList<Long>();

		for (int i = 0; i < K; i++) {
			if (A[i] < 0)
				queue.add(i);
		}

		for (int i = K; i < N; i++) {
			if (queue.isEmpty())
				list.add(0L);
			else
				list.add(A[queue.peek()]);

			if (!queue.isEmpty() && queue.peek() < i - K + 1)
				queue.poll();

			if (A[i] < 0)
				queue.add(i);
		}

		if (queue.isEmpty())
			list.add(0L);
		else
			list.add(A[queue.peek()]);

		long[] result = new long[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;
	}
}
