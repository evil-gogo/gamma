package companies.microsoft.interview.p_64_minimum_path_sum;

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

    private static int solve1(int[][] grid, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        if (i == grid.length - 1) {
            return grid[i][j] + solve1(grid, i, j + 1);
        } else if (j == grid[0].length - 1) {
            return grid[i][j] + solve1(grid, i + 1, j);
        } else {
            int down = solve1(grid, i + 1, j);
            int right = solve1(grid, i, j + 1);

            return grid[i][j] + Math.min(down, right);
        }
    }

    private static int solve2(int[][] grid, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return dp[i][j] = grid[i][j];
        }
        if (i == grid.length - 1) {
            return dp[i][j] = grid[i][j] + solve2(grid, i, j + 1, dp);
        } else if (j == grid[0].length - 1) {
            return dp[i][j] = grid[i][j] + solve2(grid, i + 1, j, dp);
        } else {
            int down = solve2(grid, i + 1, j, dp);
            int right = solve2(grid, i, j + 1, dp);

            return dp[i][j] = grid[i][j] + Math.min(down, right);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }
}
