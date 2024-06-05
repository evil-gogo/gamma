package leetcode.p_1615_maximal_network_rank;

//https://leetcode.com/problems/maximal-network-rank/description/

class Solution {
    public static int maximalNetworkRank(int n, int[][] roads) {
        int[][] adjacencyMatrix = new int[n][n];
        int[] numberOfRoads = new int[n];

        for (int[] road : roads) {
            int cityA = road[0];
            int cityB = road[1];
            adjacencyMatrix[cityA][cityB] = 1;
            adjacencyMatrix[cityB][cityA] = 1;

            numberOfRoads[cityA]++;
            numberOfRoads[cityB]++;
        }

        int maximalNetworkRank = 0;
        for (int indexCityA = 0; indexCityA < n; indexCityA++) {
            for (int indexCityB = indexCityA + 1; indexCityB < n; indexCityB++) {
                maximalNetworkRank = Math.max(maximalNetworkRank, numberOfRoads[indexCityA] + numberOfRoads[indexCityB] - adjacencyMatrix[indexCityA][indexCityB]);
            }
        }
        return maximalNetworkRank;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] roads = {{0, 1}, {0, 3}, {1, 2}, {1, 3}};
        System.out.println(maximalNetworkRank(n, roads));
    }
}
