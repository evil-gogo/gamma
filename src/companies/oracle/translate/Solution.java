package companies.oracle.translate;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        String[] translateInput = {"English", "Chinese"};
        String[][] graph = {{"English", "French"}, {"French", "Chinese"}, {"Hindi", "Chinese"}, {"Hindi", "English"}};
        System.out.println(findMinTranslateLength(graph, translateInput));
    }

    private static int findMinTranslateLength(String[][] graph, String[] input) {
        HashMap<String, ArrayList<String>> adjacencyMap = new HashMap<String, ArrayList<String>>();

        for (String[] path : graph) {
            if (adjacencyMap.containsKey(path[0])) {
                adjacencyMap.get(path[0]).add(path[1]);
            } else {
                adjacencyMap.put(path[0], new ArrayList<>());
                adjacencyMap.get(path[0]).add(path[1]);
            }
        }
        System.out.println(adjacencyMap);

        Queue<String> queue = new LinkedList<>();

        queue.add(input[0]);
        int currentLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            currentLevel++;
            for (int i = 0; i < size; i++) {
                ArrayList<String> adjacencyList = adjacencyMap.get(queue.poll());
                if (adjacencyList != null) {
                    for (String vertex : adjacencyList) {
                        if (input[1].equals(vertex)) {
                            return currentLevel;
                        }
                        queue.add(vertex);
                    }
                }
            }

        }
        return -1;
    }
}
