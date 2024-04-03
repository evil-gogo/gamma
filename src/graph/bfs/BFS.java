package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        System.out.println("!!! BFS Demo !!!");

        Graph graph = createGraph();
        graph.printGraph();

        bfs(graph, 0);
    }

    private static void bfs(Graph graph, int startVertex) {
        System.out.println("bfs");
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[graph.getVertices()];
        visited[startVertex] = true;

        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");
            for (int neighbor : graph.getAdjacencyList()[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    private static Graph createGraph() {
        System.out.println("createGraph");
        int vertices = 5;

        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        return graph;
    }
}
