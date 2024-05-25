package leetcode.p_72_edit_distance;

//https://leetcode.com/problems/edit-distance/description/

class Solution {
    public static int minDistance(String word1, String word2) {
        //return solve1(word1, word2, word1.length(), word2.length(), 0, 0);

        //int[][] dp = new int[word1.length()][word2.length()];
        //return solve2(word1, word2, word1.length(), word2.length(), 0, 0, dp);

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        return solve3(word1, word2, word1.length(), word2.length(), dp);
    }

    private static int solve3(String word1, String word2, int m, int n, int[][] dp) {
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

    private static int solve1(String word1, String word2, int m, int n, int i, int j) {
        if (i > word1.length() - 1) {
            return word2.length() - j;
        }
        if (j > word2.length() - 1) {
            return word1.length() - i;
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return solve1(word1, word2, m, n, i + 1, j + 1);
        } else {
            int insert = 1 + solve1(word1, word2, m, n, i, j + 1);
            int delete = 1 + solve1(word1, word2, m, n, i + 1, j);
            int replace = 1 + solve1(word1, word2, m, n, i + 1, j + 1);
            return Math.min(insert, Math.min(delete, replace));
        }
    }

    private static int solve2(String word1, String word2, int m, int n, int i, int j, int[][] dp) {
        if (i > word1.length() - 1) {
            return word2.length() - j;
        }
        if (j > word2.length() - 1) {
            return word1.length() - i;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = solve2(word1, word2, m, n, i + 1, j + 1, dp);
        } else {
            int insert = 1 + solve2(word1, word2, m, n, i, j + 1, dp);
            int delete = 1 + solve2(word1, word2, m, n, i + 1, j, dp);
            int replace = 1 + solve2(word1, word2, m, n, i + 1, j + 1, dp);
            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }

    public static void main(String[] args) {
        //String word1 = "intention", word2 = "execution";
        String word1 = "horse", word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }
}
