package leetcode.m_399_evaluate_division;

//https://leetcode.com/problems/evaluate-division/description/

import java.util.*;

class Pair {
    String v;
    double weight;

    Pair(String v, double weight) {
        this.v = v;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return v + ", weight " + weight + " ";
    }
}

class Solution {
    static double val;

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> adjacencyMap = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String u = equation.get(0);
            String v = equation.get(1);
            double w = values[i];

            adjacencyMap.putIfAbsent(u, new LinkedList<>());
            adjacencyMap.get(u).add(new Pair(v, w));
            adjacencyMap.putIfAbsent(v, new LinkedList<>());
            adjacencyMap.get(v).add(new Pair(u, 1 / w));
        }

        double[] ans = new double[queries.size()];

        for (int i = 0 ; i < queries.size() ; i++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);

            if (!adjacencyMap.containsKey(u)) {
                ans[i] = -1;
                continue;
            }

            val = -1;

            dfs(adjacencyMap, u, v, 1, new HashSet<>());
            ans[i] = val;
        }
        return ans;
    }

    private static void dfs(Map<String, List<Pair>> adjacencyMap, String u, String v, double curVal, Set<String> visited) {
        if (u.equals(v)) {
            val = curVal;
            return;
        }

        visited.add(u);

        for (Pair p : adjacencyMap.get(u)){
            if (!visited.contains(p.v)) {
                dfs(adjacencyMap, p.v, v, curVal * p.weight, visited);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> equations = new LinkedList<>();
        equations.add(new ArrayList<>(Arrays.asList("a", "b")));
        equations.add(new ArrayList<>(Arrays.asList("b", "c")));

        double[] values = {2.0, 3.0};

        List<List<String>> queries = new LinkedList<>();
        queries.add(new ArrayList<>(Arrays.asList("a", "c")));
        queries.add(new ArrayList<>(Arrays.asList("b", "a")));
        queries.add(new ArrayList<>(Arrays.asList("a", "e")));
        queries.add(new ArrayList<>(Arrays.asList("a", "a")));
        queries.add(new ArrayList<>(Arrays.asList("x", "x")));

        System.out.println(Arrays.toString(calcEquation(equations, values, queries)));
    }
}
