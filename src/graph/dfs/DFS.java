package graph.dfs;

public class DFS {
    public static void main(String[] args) {
        System.out.println("main");

        Graph graph = createGraph();
        graph.printGraph();
    }

    public static void dfs() {

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
