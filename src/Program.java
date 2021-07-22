import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class Program {
	public static void main(String[] args) {
		List<Integer> jobs = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		Graph graph = new Graph(jobs);
		graph.addEdge(3, 1);
		graph.addEdge(8, 1);
		graph.addEdge(8, 7);
		graph.addEdge(5, 7);
		graph.addEdge(5, 2);
		graph.addEdge(1, 4);
		graph.addEdge(6, 7);
		graph.addEdge(1, 2);
		graph.addEdge(7, 6);
		System.out.println(graph.graphMap);
		System.out.println(topologicalSort(jobs, graph));
	}

	public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
		Graph graph = new Graph(jobs);
		for (int i = 0; i < deps.size(); i++)
			graph.addEdge(deps.get(i)[0], deps.get(i)[1]);

		return topologicalSort(jobs, graph);
	}

	public static boolean topologicalSortUtil(int vertex, Stack<Integer> stack, Graph graph, Map<Integer, Boolean> visited,
		Map<Integer, Boolean> inStack, boolean cyclic) {
		visited.put(vertex, true);
		inStack.put(vertex, true);
		List<Integer> adjacentElements = graph.graphMap.get(vertex);
		for (int i = 0; i < adjacentElements.size(); i++) {
			int node = adjacentElements.get(i);
			if (inStack.get(node))
				return true;
			if (visited.get(node) == false)
				cyclic = topologicalSortUtil(node, stack, graph, visited, inStack, cyclic);
		}
		inStack.put(vertex, false);
		stack.push(vertex);
		return cyclic;
	}

	public static List<Integer> topologicalSort(List<Integer> vertex, Graph graph) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		Map<Integer, Boolean> inStack = new HashMap<Integer, Boolean>();
		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		for (int i = 0; i < vertex.size(); i++) {
			visited.put(vertex.get(i), false);
			inStack.put(vertex.get(i), false);
		}
		boolean cyclic = false;
		for (int i = 0; i < vertex.size(); i++) {
			if (visited.get(vertex.get(i)) == false) {
				cyclic = topologicalSortUtil(vertex.get(i), stack, graph, visited, inStack, cyclic);
				if (cyclic)
					return result;
			}
		}
		while (!stack.isEmpty())
			result.add(stack.pop());
		return result;
	}

	static class Graph {
		List<Integer> vertex;
		Map<Integer, List<Integer>> graphMap;

		public Graph(List<Integer> vertex) {
			graphMap = new HashMap<Integer, List<Integer>>();
			for (int i = 0; i < vertex.size(); i++)
				graphMap.put(vertex.get(i), new ArrayList<Integer>());
		}

		public void addEdge(int x, int y) {
			graphMap.get(x).add(y);
		}
	}
}