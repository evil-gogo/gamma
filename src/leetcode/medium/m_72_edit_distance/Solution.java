package leetcode.medium.m_72_edit_distance;

//https://leetcode.com/problems/edit-distance/description/

class Solution {
    public static int minDistance(String word1, String word2) {
//        return solve1(word1, word2, 0, 0);

//        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
//        for (int i = 0; i < dp.length; i++) {
//            Arrays.fill(dp[i], -1);
//
//        }
//        return solve2(word1, word2, 0, 0, dp);

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        return solve3(word1, word2, dp);
    }

    private static int solve1(String word1, String word2, int i, int j) {
        if (i > word1.length() - 1) {
            return word2.length() - j;
        }
        if (j > word2.length() - 1) {
            return word1.length() - i;
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return solve1(word1, word2, i + 1, j + 1);
        } else {
            int insert = 1 + solve1(word1, word2, i, j + 1);
            int delete = 1 + solve1(word1, word2, i + 1, j);
            int replace = 1 + solve1(word1, word2, i + 1, j + 1);
            return Math.min(insert, Math.min(delete, replace));
        }
    }

    private static int solve2(String word1, String word2, int i, int j, int[][] dp) {
        if (i > word1.length() - 1) {
            return word2.length() - j;
        }
        if (j > word2.length() - 1) {
            return word1.length() - i;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = solve2(word1, word2, i + 1, j + 1, dp);
        } else {
            int insert = 1 + solve2(word1, word2, i, j + 1, dp);
            int delete = 1 + solve2(word1, word2, i + 1, j, dp);
            int replace = 1 + solve2(word1, word2, i + 1, j + 1, dp);

            dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }

        return dp[i][j];
    }

    private static int solve3(String word1, String word2, int[][] dp) {
        int m = word1.length(), n = word2.length();

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = 1 + dp[i - 1][j];
                    int delete = 1 + dp[i][j - 1];
                    int replace = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }

            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        //String word1 = "intention", word2 = "execution";
        String word1 = "horse", word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }
}
