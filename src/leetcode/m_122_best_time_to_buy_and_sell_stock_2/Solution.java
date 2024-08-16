package leetcode.m_122_best_time_to_buy_and_sell_stock_2;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
class Solution {
    public static int maxProfit(int[] prices) {
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

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        //int[] prices = {7, 8, 9};
        System.out.println("Max profit is : " + maxProfit(prices));
    }
}
