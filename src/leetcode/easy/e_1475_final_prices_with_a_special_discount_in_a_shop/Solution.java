package leetcode.easy.e_1475_final_prices_with_a_special_discount_in_a_shop;

//https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public static int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && prices[i] < stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(prices[i]);
            } else {
                int discount = stack.peek();
                stack.push(prices[i]);
                prices[i] = prices[i] - discount;
            }
        }
        return prices;
    }

    public static void main(String[] args) {
        int[] prices = {8, 4, 6, 2, 3};
        System.out.println(Arrays.toString(finalPrices(prices)));
    }
}
