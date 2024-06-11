package companies.microsoft.interview.p_62_unique_paths;

//https://leetcode.com/problems/unique-paths/description/

import java.util.Arrays;

class Solution {
    public static int uniquePaths(int m, int n) {
        //return solve1(m, n, 0, 0);

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve2(m, n, dp, 0, 0);
    }

    private static int solve1(int m, int n, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        int left = solve1(m, n, i + 1, j);
        int right = solve1(m, n, i, j + 1);
        return left + right;
    }

    private static int solve2(int m, int n, int[][] dp, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int left = solve2(m, n, dp, i + 1, j);
        int right = solve2(m, n, dp, i, j + 1);
        return dp[i][j] = left + right;
    }

    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(uniquePaths(m, n));
    }
}
