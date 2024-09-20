package leetcode.hard.h_265_paint_house_II;

//https://leetcode.com/problems/paint-house-ii/description/

class Solution {
    public static int minCostII(int[][] costs) {
        int[][] dp = new int[costs.length][costs[0].length];
        return solve(costs, 0, -1, dp);
    }

    private static int solve(int[][] costs, int houseIndex, int prevColourIndex, int[][] dp) {
        if (houseIndex >= costs.length) {
            return 0;
        }
        if (prevColourIndex != -1 && dp[houseIndex][prevColourIndex] != 0) {
            return dp[houseIndex][prevColourIndex];
        }
        int minCost = Integer.MAX_VALUE;
        for (int colourIndex = 0; colourIndex < costs[0].length; colourIndex++) {
            if (colourIndex != prevColourIndex) {
                minCost = Math.min(costs[houseIndex][colourIndex] + solve(costs, houseIndex + 1, colourIndex, dp), minCost);
            }
        }
        if (prevColourIndex != -1) {
            dp[houseIndex][prevColourIndex] = minCost;
        }
        return minCost;
    }

    public static void main(String[] args) {
        int[][] costs = {{1, 5, 3}, {2, 9, 4}};
        System.out.println(minCostII(costs));
    }
}
