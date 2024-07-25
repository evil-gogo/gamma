//package leetcode.p_1293_shortest_path_in_a_grid_with_obstacles_elimination;
//
//class Minimum {
//    int minLength;
//}
//
//class Solution {
//    public static int shortestPath(int[][] grid, int k) {
//        Minimum minimum = new Minimum();
//        minimum.minLength = Integer.MAX_VALUE;
//        solve(grid, k, 0, 0, 0, minimum);
//        return minimum.minLength;
//    }
//
//    private static int solve(int[][] grid, int k, int x, int y, int noOfSteps, Minimum minimum) {
//        if (x == grid.length - 1 && y == grid[0].length - 1) {
//            return 0;
//        }
//        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
//
//        for (int i = 0; i < directions.length; i++) {
//            int nextX = x + directions[i][0];
//            int nextY = x + directions[i][1];
//
//            if (nextX >= 0 && nextX  < grid.length && nextY >=0 && nextY < grid[0].length) {
//                if (grid[nextX][nextY] != 0) {
//                    int cost = solve(grid, k, nextX, nextY, 1 + noOfSteps, minimum);
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}};
//        int k = 1;
//        System.out.println(shortestPath(grid, k));
//    }
//}
