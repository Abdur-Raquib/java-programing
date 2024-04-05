package fp;

public class GraphColoring {
    private int V; // Number of vertices
    private int[] colors; // Stores the assigned color for each vertex
    private int[][] graph; // Adjacency matrix representing the graph

    public GraphColoring(int[][] graph) {
        this.graph = graph;
        this.V = graph.length;
        this.colors = new int[V];
    }

    public boolean isSafe(int v, int c) {
        // Check if the color c is valid for vertex v
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && colors[i] == c) {
                return false;
            }
        }
        return true;
    }

    public boolean graphColor(int m, int v) {
        // Base case: If all vertices are colored
        if (v == V) {
            return true;
        }

        // Try different colors for vertex v
        for (int c = 1; c <= m; c++) {
            if (isSafe(v, c)) {
                colors[v] = c;

                // Recursive call for the next vertex
                if (graphColor(m, v + 1)) {
                    return true;
                }

                // Backtrack: If the assignment didn't lead to a solution, reset the color
                colors[v] = 0;
            }
        }

        // No valid color found for vertex v
        return false;
    }

    public void printSolution() {
        System.out.println("Vertex\tColor");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t" + colors[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
        		{0,0,1,1,0},
                {0,0,1,1,0},
                {1,1,0,0,1},
                {1,1,0,0,1},
                {0,0,1,1,0}
        };
        int m = 3;

        GraphColoring coloring = new GraphColoring(graph);
        if (coloring.graphColor(m, 0)) {
            coloring.printSolution();
        } else {
            System.out.println("No solution exists.");
        }
    }
}