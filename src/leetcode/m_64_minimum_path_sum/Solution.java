package leetcode.m_64_minimum_path_sum;

//https://leetcode.com/problems/minimum-path-sum/description/

import java.util.Arrays;

class Solution {
    public static int minPathSum(int[][] grid) {
        return solve(grid, 0, 0);
    }

    private static int solve(int[][] grid, int i, int j) {
        //return solve1(grid, 0, 0);
        int[][] dp = new int[grid.length][grid[0].length];
        for (int k = 0; k < grid.length; k++) {
            Arrays.fill(dp[k], -1);
        }
        return solve2(grid, 0, 0, dp);
    }

    private static int solve1(int[][] grid, int rowIndex, int colIndex) {
        if (rowIndex == grid.length - 1 && colIndex == grid[0].length - 1) {
            return grid[rowIndex][colIndex];
        }

        int down = rowIndex < grid.length - 1 ? solve1(grid, rowIndex + 1, colIndex) : Integer.MAX_VALUE;
        int right = colIndex < grid[0].length - 1 ? solve1(grid, rowIndex, colIndex + 1) : Integer.MAX_VALUE;

        return grid[rowIndex][colIndex] + Math.min(down, right);
    }

    private static int solve2(int[][] grid, int rowIndex, int colIndex, int[][] dp) {
        if (dp[rowIndex][colIndex] != -1) {
            return dp[rowIndex][colIndex];
        }

        if (rowIndex == grid.length - 1 && colIndex == grid[0].length - 1) {
            return dp[rowIndex][colIndex] = grid[rowIndex][colIndex];
        }

        int down = rowIndex < grid.length - 1 ? solve2(grid, rowIndex + 1, colIndex, dp) : Integer.MAX_VALUE;
        int right = colIndex < grid[0].length - 1 ? solve2(grid, rowIndex, colIndex + 1, dp) : Integer.MAX_VALUE;

        return dp[rowIndex][colIndex] = grid[rowIndex][colIndex] + Math.min(down, right);
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }
}
