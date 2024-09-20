package leetcode.medium.m_91_decode_ways;

//https://leetcode.com/problems/decode-ways/description/

import java.util.Arrays;

class Solution {
    public static int numDecodings(String s) {
        //return solve1(s, 0);

        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return solve2(s, 0, dp);
    }

    private static int solve1(String s, int index) {
        if (index == s.length()) {
            return 1;
        }

        if (index > s.length() || s.charAt(index) == '0') {
            return 0;
        }

        int result1 = solve1(s, index + 1);
        int result2 = 0;
        if (s.charAt(index) == '1' || (index + 1 < s.length() && s.charAt(index) == '2' && s.charAt(index + 1) <= '6')) {
            result2 = solve1(s, index + 2);
        }
        return result1 + result2;
    }

    private static int solve2(String s, int index, int[] dp) {
        if (index == s.length()) {
            return 1;
        }

        if (index > s.length() || s.charAt(index) == '0') {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }

        int result1 = solve2(s, index + 1, dp);
        int result2 = 0;
        if (s.charAt(index) == '1' || (index + 1 < s.length() && s.charAt(index) == '2' && s.charAt(index + 1) <= '6')) {
            result2 = solve2(s, index + 2, dp);
        }
        return dp[index] = result1 + result2;
    }

    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));
    }
}
