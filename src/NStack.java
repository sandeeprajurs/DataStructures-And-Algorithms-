import java.util.Arrays;

public class NStack {
	
	static int[] arr;
	static int[] top;
	static int[] next;
	static int free;
	
	public static void main(String[] args) {
		int stacks = 2;
		int size = 5;
		arr = new int[size];
		top = new int[stacks];
		next = new int[size];
		Arrays.fill(top, -1);
		for(int i=0; i<next.length; i++) {
			next[i] = i+1;
		}
		next[next.length - 1] = -1;
		
		push(25,1);
		push(26,0);
		push(27,1);
		push(28,0);
		push(29,1);
		System.out.println("pop element --- "+pop(1));
		push(30,0);
		System.out.println("pop element --- "+pop(0));
		push(35, 1);
//		System.out.println("pop element --- "+pop(1));
		System.out.println("array "+Arrays.toString(arr));
		System.out.println("top "+Arrays.toString(top));
		System.out.println("next "+Arrays.toString(next));
		System.out.println("free "+free);
	}
	
	public static void push(int element, int stack) {
		if(free == -1) {
			System.out.println("stack is full");
			return;
		}
		arr[free] = element;
		int temp = free;
		free = next[temp];
		next[temp] = top[stack];
		top[stack] = temp;
	}
	
	public static int pop(int stack) {
		if(top[stack] == -1) {
			System.out.println("stack is empty");
			return Integer.MAX_VALUE;
		}
		int nextElement = top[stack];
		top[stack] = next[nextElement];
		next[nextElement] = free;
		free = nextElement;
		return arr[nextElement];
	}
	
	
}
