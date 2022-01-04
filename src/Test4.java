
public class Test4 {
	
	public static void main(String[] args) {
//		System.out.println(hasSingleCycle(new int[] {1, -1, 1, -1}));
		String a = "-";
		System.out.println(a.charAt(0) - 'A');
	}

	public static boolean hasSingleCycle(int[] array) {
		boolean[] visited = new boolean[array.length];
		boolean cyclic = false;
		for (int i = 0; i < array.length; i++) {
			if(i + array[i] > array.length)
				cyclic = true;
			int index = (i + array[i]) % array.length;
			if(index < 0)
				index = array.length + index;
			System.out.println(index);
			if (visited[index])
				break;
			visited[index] = true;
		}

		for (int i = 0; i < array.length; i++) {
			if (visited[i] == false)
				return false;
		}
		return cyclic ? true : false;
	}
}
