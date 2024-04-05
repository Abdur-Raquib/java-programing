package iddfs;

import java.util.*;

class Graph {

	private int V;
	private LinkedList<Integer>[] adj;

	Graph(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i)
            adj[i] = new LinkedList<>();
    }

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	boolean DLS(int v, boolean[] visited, int depthLimit, List<Integer> result) {
		if (depthLimit == 0) {
			result.add(v);
			return true;
		}

		visited[v] = true;
		boolean found = false;

		for (int neighbor : adj[v]) {
			if (!visited[neighbor])
				found = DLS(neighbor, visited, depthLimit - 1, result);
			if (found)
				result.add(v);
		}

		visited[v] = false;
		return found;
	}

	// Function to perform Iterative Deepening Depth-First Search (IDDFS)
	List<Integer> topologicalSort() {
		List<Integer> result = new ArrayList<>();

		for (int depthLimit = 0; depthLimit < V; depthLimit++) {
			boolean[] visited = new boolean[V];
			boolean found = false;

			for (int i = 0; i < V; i++) {
				if (!visited[i])
					found = DLS(i, visited, depthLimit, result);
				if (found)
					break;
			}

			if (found)
				return result;
		}

		return new ArrayList<>(); // Return an empty list if no topological order exists
	}
}

public class TopologicalSearch {
	public static void main(String[] args) {
		int V = 7;
		Graph graph = new Graph(V);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);

		List<Integer> topologicalOrder = graph.topologicalSort();
		if (topologicalOrder.isEmpty()) {
			System.out.println("No topological order exists. The graph contains a cycle.");
		} else {
			System.out.println("Topological Order:");
			for (int vertex : topologicalOrder) {
				System.out.print(vertex + " ");
			}
			System.out.println();
		}
	}

}
