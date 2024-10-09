package leetcode.hard.h_1293_shortest_path_in_a_grid_with_obstacles_elimination;

//https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/description/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row, col;
    int remainingEliminations;
    int steps;

    public Pair(int row, int col, int k, int steps) {
        this.row = row;
        this.col = col;
        this.remainingEliminations = k;
        this.steps = steps;
    }
}

class Solution {
    public static int shortestPath(int[][] grid, int k) {
        int noOfRows = grid.length;
        int noOfColumns = grid[0].length;

        if (k >= noOfRows + noOfColumns - 2) {
            return noOfRows + noOfColumns - 2;
        }
        int[][][] dp = new int[noOfRows][noOfColumns][k + 1];
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, Integer.MAX_VALUE);
            }
        }
        dp[0][0][k] = 0;

//        int result = dfs(grid, 0, 0, k, 0, dp);
//        return result == Integer.MAX_VALUE ? -1 : result;

        int result = bfs(grid, k, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int dfs(int[][] grid, int row, int col, int remainingEliminations, int steps, int[][][] dp) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return steps;
        }

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int minSteps = Integer.MAX_VALUE;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
                int newEliminations = remainingEliminations - grid[newRow][newCol];

                if (newEliminations >= 0 && dp[newRow][newCol][newEliminations] > steps + 1) {
                    dp[newRow][newCol][newEliminations] = steps + 1;
                    int currentSteps = dfs(grid, newRow, newCol, newEliminations, steps + 1, dp);
                    minSteps = Math.min(minSteps, currentSteps);
                }
            }
        }

        return minSteps;
    }

    public static int bfs(int[][] grid, int k, int[][][] dp) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0, k, 0));

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            Pair curPos = queue.poll();

            if (curPos.row == grid.length - 1 && curPos.col == grid[0].length - 1) {
                return curPos.steps;
            }

            for (int[] dir : directions) {
                int newRow = curPos.row + dir[0];
                int newCol = curPos.col + dir[1];

                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
                    int newEliminations = curPos.remainingEliminations - grid[newRow][newCol];

                    if (newEliminations >= 0 && dp[newRow][newCol][newEliminations] > curPos.steps + 1) {
                        queue.offer(new Pair(newRow, newCol, newEliminations, curPos.steps + 1));
                        dp[newRow][newCol][newEliminations] = curPos.steps + 1;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}};
        int k = 1;
        System.out.println(shortestPath(grid, k));
    }
}
