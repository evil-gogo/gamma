package leetcode.p_402_remove_k_digits;

//https://leetcode.com/problems/remove-k-digits/description/

import java.util.Stack;

class Solution {
    public static String removeKdigits(String num, int k) {
        char[] chars = num.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char digit : chars) {
            while (!stack.isEmpty() && stack.peek() > digit && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.insert(0, stack.pop());
        }

        int nonZeroIndex = 0;
        while (nonZeroIndex < str.length() && str.charAt(nonZeroIndex) == '0') {
            nonZeroIndex++;
        }

        String result = str.substring(nonZeroIndex);
        return result.isEmpty() ? "0" : result;
    }

    public static void main(String[] args) {
//        String num = "1432219";
//        int k = 3;
//        String num = "10200";
//        int k = 1;
        String num = "112";
        int k = 1;
        System.out.println(removeKdigits(num, k));
    }
}
