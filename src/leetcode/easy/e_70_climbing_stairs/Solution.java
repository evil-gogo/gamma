package leetcode.easy.e_70_climbing_stairs;

//https://leetcode.com/problems/climbing-stairs/description/

class Solution {
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return solve1(n, dp);

//        int[] memo = new int[n + 1];
//        Arrays.fill(memo, -1);
//        return solve2(n, memo);
    }

    private static int solve1(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return 1;
        }
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static int solve2(int n, int[] memo) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        return memo[n] = solve2(n - 1, memo) + solve2(n - 2, memo);
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(climbStairs(n));
    }
}
