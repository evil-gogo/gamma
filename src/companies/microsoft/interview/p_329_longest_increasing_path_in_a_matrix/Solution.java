package companies.microsoft.interview.p_329_longest_increasing_path_in_a_matrix;

//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/

class Solution {
    public static int longestIncreasingPath(int[][] matrix) {
        int longestPath = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                longestPath = Math.max(longestPath, dfs(matrix, i, j, dp));
            }
        }
        return longestPath;
    }

    private static int dfs(int[][] matrix, int row, int col, int[][] dp) {
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int[] directions = {-1, 0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            int nextRow = row + directions[k];
            int nextCol = col + directions[k + 1];

            if (nextRow >= 0 && nextRow < matrix.length && nextCol >= 0 && nextCol < matrix[0].length && matrix[nextRow][nextCol] > matrix[row][col]) {
                dp[row][col] = Math.max(dp[row][col], dfs(matrix, nextRow, nextCol, dp));
            }
        }
        return dp[row][col] = 1 + dp[row][col];
    }

    public static void main(String[] args) {
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(longestIncreasingPath(matrix));
    }
}
