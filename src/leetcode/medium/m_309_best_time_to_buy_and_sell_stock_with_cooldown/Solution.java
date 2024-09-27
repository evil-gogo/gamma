package leetcode.medium.m_309_best_time_to_buy_and_sell_stock_with_cooldown;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

class Solution {
    public static int maxProfit(int[] prices) {
        //return maxProfit1(prices);
        return maxProfit2(prices);
    }

    public static int maxProfit1(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return solve(prices, 0, 0, dp);
    }

    public static int solve(int[] prices, int index, int isPreviousStockHold, int[][] dp) {
        if (index > prices.length - 1) {
            return 0;
        }
        if (dp[index][isPreviousStockHold] != -1) {
            return dp[index][isPreviousStockHold];
        }
        if (isPreviousStockHold == 1) {
            int sell = prices[index] + solve(prices, index + 2, 0, dp);
            int skip = solve(prices, index + 1, isPreviousStockHold, dp);
            return dp[index][isPreviousStockHold] = Math.max(sell, skip);
        } else {
            int buy = -prices[index] + solve(prices, index + 1, 1, dp);
            int skip = solve(prices, index + 1, isPreviousStockHold, dp);
            return dp[index][isPreviousStockHold] = Math.max(buy, skip);
        }
    }

    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        // dp[i][0]: max profit on day i when not holding stock
        // dp[i][1]: max profit on day i when holding stock
        int[][] dp = new int[n][2];

        dp[0][0] = 0; // Not holding stock on day 0
        dp[0][1] = -prices[0]; // Holding stock on day 0

        for (int i = 1; i < n; i++) {
            // If not holding stock on day i
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            // If holding stock on day i
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);

            // Implement cooldown by checking two days before for not holding
            if (i > 1) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 2][0]); // Include cooldown day
            }
        }

        // The answer is the max profit on the last day when not holding stock
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        //int[] prices = {7, 8, 9};
        System.out.println(maxProfit(prices));
    }
}
