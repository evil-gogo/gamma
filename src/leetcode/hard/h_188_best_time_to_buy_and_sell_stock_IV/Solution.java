package leetcode.hard.h_188_best_time_to_buy_and_sell_stock_IV;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/

class Solution {
    public static int maxProfit(int k, int[] prices) {
        //return maxProfit1(k, prices);
        return maxProfit2(k, prices);
    }

    public int maxProfit1(int maxTransactions, int[] prices) {
        int[][][] dp = new int[prices.length][2][maxTransactions + 1];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < maxTransactions + 1; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(prices, 0, 0, dp, maxTransactions);
    }

    public static int solve(int[] prices, int index, int isPreviousStockHold, int[][][] dp, int maxTransactions) {
        if (index > prices.length - 1 || maxTransactions <= 0) {
            return 0;
        }

        if (dp[index][isPreviousStockHold][maxTransactions] != -1) {
            return dp[index][isPreviousStockHold][maxTransactions];
        }
        if (isPreviousStockHold == 1) {
            int sell = prices[index] + solve(prices, index + 1, 0, dp, maxTransactions - 1);
            int skip = solve(prices, index + 1, isPreviousStockHold, dp, maxTransactions);
            return dp[index][isPreviousStockHold][maxTransactions] = Math.max(sell, skip);
        } else {
            int buy = -prices[index] + solve(prices, index + 1, 1, dp, maxTransactions);
            int skip = solve(prices, index + 1, isPreviousStockHold, dp, maxTransactions);
            return dp[index][isPreviousStockHold][maxTransactions] = Math.max(buy, skip);
        }
    }

    public static int maxProfit2(int maxTransactions, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        int[][][] dp = new int[n][2][maxTransactions + 1];

        // isPreviouslyStockHold = 1/0
        for (int k = 0; k <= maxTransactions; k++) {
            dp[0][0][k] = 0;
            dp[0][1][k] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= maxTransactions; k++) {
                int skip = dp[i - 1][0][k];
                int sell = dp[i - 1][1][k] + prices[i];

                dp[i][0][k] = Math.max(skip, sell);

                skip = dp[i - 1][1][k];
                int buy = dp[i - 1][0][k - 1] - prices[i];

                dp[i][1][k] = Math.max(skip, buy);
            }
        }

        return dp[n - 1][0][maxTransactions];
    }

    public static void main(String[] args) {
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        //int[] prices = {7, 8, 9};
        System.out.println(maxProfit(k, prices));
    }
}
