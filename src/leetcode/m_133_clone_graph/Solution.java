package leetcode.m_133_clone_graph;

//https://leetcode.com/problems/clone-graph/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    @Override
    public String toString() {
        return "" + val;
    }
}


class Solution {
    public static Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>();
        return cloneGraph(node, visited);
    }

    public static Node cloneGraph(Node node, Map<Node, Node> visited) {
        if (node == null) {
            return null;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val);

        visited.put(node, cloneNode);

        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor, visited));
        }

        return cloneNode;
    }

    public static void main(String[] args) {
        int[][] adjList = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        Node[] nodes = new Node[adjList.length];
        for (int i = 0; i < adjList.length; i++) {
            nodes[i] = new Node(i + 1);
        }

        for (int i = 0; i < adjList.length; i++) {
            nodes[i].neighbors.add(nodes[adjList[i][0] - 1]);
            nodes[i].neighbors.add(nodes[adjList[i][1] - 1]);
        }

        for (int i = 0; i < adjList.length; i++) {
            System.out.println(nodes[i].val + " " + nodes[i].neighbors);
        }

        System.out.println(cloneGraph(nodes[0]));
    }
}
