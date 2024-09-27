package leetcode.medium.m_122_best_time_to_buy_and_sell_stock_2;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

class Solution {
    public static int maxProfit(int[] prices) {
        //return maxProfit1(prices);
        //return maxProfit2(prices);
        return maxProfit3(prices);
    }

    public static int maxProfit1(int[] prices) {
        int maxProfit = 0;
        int minPriceBuyIndex = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > prices[minPriceBuyIndex]) {
                maxProfit += prices[i] - prices[minPriceBuyIndex];
            }
            minPriceBuyIndex = i;
        }
        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
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
            int sell = prices[index] + solve(prices, index + 1, 0, dp);
            int skip = solve(prices, index + 1, isPreviousStockHold, dp);
            return dp[index][isPreviousStockHold] = Math.max(sell, skip);
        } else {
            int buy = -prices[index] + solve(prices, index + 1, 1, dp);
            int skip = solve(prices, index + 1, isPreviousStockHold, dp);
            return dp[index][isPreviousStockHold] = Math.max(buy, skip);
        }
    }

    public static int maxProfit3(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int[][] dp = new int[n][2];
        // isPreviouslyStockHold = 1/0
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            int skip = dp[i - 1][0];
            int sell = dp[i - 1][1] + prices[i];

            dp[i][0] = Math.max(skip, sell);

            skip = dp[i - 1][1];
            int buy = dp[i - 1][0] - prices[i];

            dp[i][1] = Math.max(skip, buy);
        }

        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        //int[] prices = {7, 8, 9};
        System.out.println(maxProfit(prices));
    }
}
