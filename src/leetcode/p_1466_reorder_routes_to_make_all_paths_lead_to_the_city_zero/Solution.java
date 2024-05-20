package leetcode.p_1466_reorder_routes_to_make_all_paths_lead_to_the_city_zero;

//https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/

import java.util.HashMap;
import java.util.LinkedList;

class Edge {
    int node;
    boolean isOriginalEdge;

    public Edge(int node, boolean isOriginalEdge) {
        this.node = node;
        this.isOriginalEdge = isOriginalEdge;
    }
}

class Solution {
    public static int minReorder(int n, int[][] connections) {
        HashMap<Integer, LinkedList<Edge>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new LinkedList<>());
        }
        for (int[] connection : connections) {
            graph.get(connection[0]).add(new Edge(connection[1], true));
            graph.get(connection[1]).add(new Edge(connection[0], false));
        }
        boolean[] isVisited = new boolean[n];

        return dfs(graph, isVisited, 0);
    }

    private static int dfs(HashMap<Integer, LinkedList<Edge>> graph, boolean[] visited, int currentNode) {
        visited[currentNode] = true;
        int reorderRoutesCount = 0;

        LinkedList<Edge> edges = graph.get(currentNode);

        for (Edge edge : edges) {
            if (!visited[edge.node]) {
                if (edge.isOriginalEdge) {
                    reorderRoutesCount++;
                }
                reorderRoutesCount += dfs(graph, visited, edge.node);
            }
        }
        return reorderRoutesCount;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(minReorder(n, connections));
    }
}
