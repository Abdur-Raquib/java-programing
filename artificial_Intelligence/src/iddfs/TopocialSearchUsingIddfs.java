package iddfs;

import java.util.*;

public class TopocialSearchUsingIddfs {
	
	public static ArrayList<Integer> topologicalSearch(int V, ArrayList<ArrayList<Integer>> adjList) {
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int v : adjList.get(i)) {
                inDegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        ArrayList<Integer> topologicalOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topologicalOrder.add(u);

            for (int v : adjList.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        if (topologicalOrder.size() != V) {
            return new ArrayList<>();
        }

        return topologicalOrder;
    }
	
	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
	}

	public static void main(String[] args) {
		int V = 6;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
		
		addEdge(adj,0,1);
		addEdge(adj,0,2);
		addEdge(adj,1,3);
		addEdge(adj,2,3);
		addEdge(adj,3,4);
		addEdge(adj,4,5);
		

		ArrayList<Integer> topologicalOrder = topologicalSearch(V, adj);
		if (topologicalOrder.isEmpty()) {
			System.out.println("Topological order does not exist!");
		} else {
			System.out.println("Topological order: " + topologicalOrder);
		}
	}
}
