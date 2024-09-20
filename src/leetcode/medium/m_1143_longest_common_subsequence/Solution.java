package leetcode.medium.m_1143_longest_common_subsequence;

//https://leetcode.com/problems/longest-common-subsequence/description/

class Solution {
    public static int longestCommonSubsequence(String text1, String text2) {
        //return solve1(text1, text2, 0, 0);

        //int[][] dp = new int[text1.length()][text2.length()];
        //return solve2(text1, text2, 0, 0, dp);

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        return solve3(text1, text2, dp);
    }

    private static int solve1(String text1, String text2, int i, int j) {
        if (i > text1.length() - 1 || j > text2.length() - 1) {
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + solve1(text1, text2, i + 1, j + 1);
        } else {
            return Math.max(solve1(text1, text2, i + 1, j), solve1(text1, text2, i, j + 1));
        }
    }

    private static int solve2(String text1, String text2, int i, int j, int[][] dp) {
        if (i > text1.length() - 1 || j > text2.length() - 1) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + solve2(text1, text2, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = Math.max(solve2(text1, text2, i + 1, j, dp), solve2(text1, text2, i, j + 1, dp));
        }
    }

    private static int solve3(String text1, String text2, int[][] dp) {
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        //String text1 = "bl", text2 = "yby";
        System.out.println(longestCommonSubsequence(text1, text2));
    }
}
