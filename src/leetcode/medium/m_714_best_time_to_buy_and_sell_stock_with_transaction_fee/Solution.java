package leetcode.medium.m_714_best_time_to_buy_and_sell_stock_with_transaction_fee;

import java.util.Arrays;

class Solution {
    public static int maxProfit(int[] prices, int fee) {
        return maxProfit1(prices, fee);
        //return maxProfit2(prices, fee);
    }

    public static int maxProfit1(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return solve(prices, 0, 0, dp, fee);
    }

    public static int solve(int[] prices, int index, int isPreviousStockHold, int[][] dp, int fee) {
        if (index > prices.length - 1) {
            return 0;
        }
        if (dp[index][isPreviousStockHold] != -1) {
            return dp[index][isPreviousStockHold];
        }
        if (isPreviousStockHold == 1) {
            int sell = prices[index] - fee + solve(prices, index + 1, 0, dp, fee);
            int skip = solve(prices, index + 1, isPreviousStockHold, dp, fee);
            return dp[index][isPreviousStockHold] = Math.max(sell, skip);
        } else {
            int buy = -prices[index] + solve(prices, index + 1, 1, dp, fee);
            int skip = solve(prices, index + 1, isPreviousStockHold, dp, fee);
            return dp[index][isPreviousStockHold] = Math.max(buy, skip);
        }
    }

    public static int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0) return 0;

        int[][] dp = new int[n][2];
        // isPreviouslyStockHold = 1/0
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            int skip = dp[i - 1][0];
            int sell = dp[i - 1][1] + prices[i] - fee;

            dp[i][0] = Math.max(skip, sell);

            skip = dp[i - 1][1];
            int buy = dp[i - 1][0] - prices[i];

            dp[i][1] = Math.max(skip, buy);
        }

        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }
}
