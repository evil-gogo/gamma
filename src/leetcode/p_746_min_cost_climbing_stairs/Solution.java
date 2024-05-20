package leetcode.p_746_min_cost_climbing_stairs;

//https://leetcode.com/problems/min-cost-climbing-stairs/description/

class Solution {
    public static int minCostClimbingStairs(int[] cost) {
        //return minCostClimbingStairs1(cost);
        return minCostClimbingStairs2(cost);
    }

    public static int minCostClimbingStairs1(int[] cost) {
        return Math.min(minCostClimbingStairsUtil(cost, 0), minCostClimbingStairsUtil(cost, 1));
    }

    private static int minCostClimbingStairsUtil(int[] cost, int currentIndex) {
        if (currentIndex > cost.length - 1) {
            return 0;
        }
        return cost[currentIndex] + Math.min(minCostClimbingStairsUtil(cost, currentIndex + 1), minCostClimbingStairsUtil(cost, currentIndex + 2));
    }

    public static int minCostClimbingStairs2(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int length = cost.length;
        for (int i = 2; i < length; i++) {
            cost[i] = cost[i] + Math.min(cost[i - 2], cost[i - 1]);
        }

        return Math.min(cost[length - 1], cost[length - 2]);
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost));
    }
}
