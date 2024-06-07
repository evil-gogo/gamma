package companies.microsoft.interview.p_121_best_time_to_buy_and_sell_stock_1;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class Solution {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPriceBuyIndex = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[minPriceBuyIndex]) {
                minPriceBuyIndex = i;
            }
            maxProfit = Math.max(maxProfit, prices[i] - prices[minPriceBuyIndex]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        //int[] prices = {7,1,5,3,6,4};
        int[] prices = {7, 8, 9};
        System.out.println("Max profit is : " + maxProfit(prices));
    }
}

