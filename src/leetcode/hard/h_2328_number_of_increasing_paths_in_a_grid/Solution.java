package leetcode.hard.h_2328_number_of_increasing_paths_in_a_grid;

//https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/description/

class Solution {
    static int[] directions = {-1, 0, 1, 0, -1};
    static final int MOD = (int) (1e9 + 7);

    public static int countPaths(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                count = (count + solve(grid, i, j, dp)) % MOD;
            }
        }
        return count;
    }

    private static int solve(int[][] grid, int row, int col, int[][] dp) {
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int pathCount = 1;
        for (int i = 0; i < directions.length - 1; i++) {
            int newRow = row + directions[i];
            int newCol = col + directions[i + 1];

            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[row][col] < grid[newRow][newCol]) {
                pathCount = (pathCount + solve(grid, newRow, newCol, dp)) % MOD;
            }
        }
        return dp[row][col] = pathCount;
    }

    public static void main(String[] args) {
        //int[][] grid = {{1, 1}, {3, 4}};
        int[][] grid = {{1, 2}};
        System.out.println(countPaths(grid));
    }
}

