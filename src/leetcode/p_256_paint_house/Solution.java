package leetcode.p_256_paint_house;

//https://leetcode.com/problems/paint-house/description/

class Solution {
    public static int minCost(int[][] costs) {
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
        for (int colourIndex = 0; colourIndex < costs[houseIndex].length; colourIndex++) {
            if (prevColourIndex != colourIndex) {
                minCost = Math.min(costs[houseIndex][colourIndex] + solve(costs, houseIndex + 1, colourIndex, dp), minCost);
            }
        }
        if (prevColourIndex != -1) {
            dp[houseIndex][prevColourIndex] = minCost;
        }
        return minCost;
    }

    public static void main(String[] args) {
        int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        System.out.println(minCost(costs));
    }
}
