package graph.bfs;

import java.util.LinkedList;

public class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;
    Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            this.adjacencyList[i] = new LinkedList<>();
        }
    }

    public int getVertices() {
        return vertices;
    }

    public LinkedList<Integer>[] getAdjacencyList() {
        return adjacencyList;
    }

    void addEdge(int u, int v) {
        this.adjacencyList[u].add(v);
    }

    void printGraph() {
        System.out.println("printGraph");
        for (int i = 0; i < this.vertices; i++) {
            System.out.println(i + " | " + adjacencyList[i]);
        }
    }
}
