package companies.microsoft.interview.p_322_coin_change;

//https://leetcode.com/problems/coin-change/description/

class Solution {
    public static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }

        int include, exclude;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    if (dp[i][j - coins[i - 1]] != Integer.MAX_VALUE) {
                        include = 1 + dp[i][j - coins[i - 1]];
                    } else {
                        include = Integer.MAX_VALUE;
                    }
                    exclude = dp[i - 1][j];
                    dp[i][j] = Math.min(exclude, include);
                }

            }
        }
        return dp[coins.length][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length][amount];
    }

    public static void main(String[] args) {
//        int[] coins = {1, 2, 5};
//        int amount = 11;
        int[] coins = {2};
        int amount = 3;
        System.out.println(coinChange(coins, amount));
    }
}
