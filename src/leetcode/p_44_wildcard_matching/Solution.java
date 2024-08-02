package leetcode.p_44_wildcard_matching;

//https://leetcode.com/problems/wildcard-matching/description/

import java.util.Arrays;

class Solution {
    public static boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        for (int i = 0; i <=s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(s, p, 0, 0, dp);
    }

    private static boolean solve(String s, String p, int strIndex, int patternIndex, int[][] dp) {
        if (patternIndex == p.length()) {
            dp[strIndex][patternIndex] = strIndex == s.length()?1:0;
            return strIndex == s.length();
        }

        if (dp[strIndex][patternIndex] != -1) {
            return dp[strIndex][patternIndex] == 1;
        }
        char c = p.charAt(patternIndex);
        switch (c) {
            case '*':
                dp[strIndex][patternIndex] = ((strIndex < s.length() && solve(s, p, strIndex + 1, patternIndex, dp)) || solve(s, p, strIndex, patternIndex + 1, dp)) ? 1 : 0;
                return dp[strIndex][patternIndex] == 1;
            case '?':
                dp[strIndex][patternIndex] = (strIndex < s.length() && solve(s, p, strIndex + 1, patternIndex + 1, dp)) ? 1 : 0;
                return dp[strIndex][patternIndex] == 1;
            default:
                dp[strIndex][patternIndex] = (strIndex < s.length() && s.charAt(strIndex) == p.charAt(patternIndex) && solve(s, p, strIndex + 1, patternIndex + 1, dp)) ? 1 : 0;
                return dp[strIndex][patternIndex] == 1;
        }
    }

    public static void main(String[] args) {
        //String s = "cb", p = "?a";
        String s = "aa", p = "*";
        //String s = "adceb", p = "*a*b";
        System.out.println(isMatch(s, p));
    }
}
