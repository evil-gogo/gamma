package leetcode.m_547_number_of_provinces;

//https://leetcode.com/problems/number-of-provinces/description/

class Solution {
    public static int findCircleNum(int[][] isConnected) {
        int noOfProvinces = 0, noOfCities = isConnected.length;
        if (noOfCities == 0) {
            return noOfProvinces;
        }

        boolean[] visited = new boolean[noOfCities];

        for (int currentCityIndex = 0; currentCityIndex < noOfCities; currentCityIndex++) {
            if (!visited[currentCityIndex]) {
                noOfProvinces++;
                dfs(isConnected, visited, currentCityIndex);
            }
        }
        return noOfProvinces;
    }

    private static void dfs(int[][] isConnected, boolean[] visited, int cityIndex) {
        if (visited[cityIndex]) {
            return;
        }

        visited[cityIndex] = true;

        for (int neighbourCityIndex = 0; neighbourCityIndex < isConnected[0].length; neighbourCityIndex++) {
            if (isConnected[cityIndex][neighbourCityIndex] == 1) {
                dfs(isConnected, visited, neighbourCityIndex);
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(isConnected));
    }
}
