package leetcode.p_392_is_subsequence;

//https://leetcode.com/problems/is-subsequence/description/

import java.util.Arrays;

class Solution {
    public static boolean isSubsequence(String s, String t) {
        //return isSubsequence1(s, 0, t, 0);

        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return isSubsequence2(s, 0, t, 0, dp);

        //return isSubsequence3(s, 0, t, 0, dp);
    }

    private static boolean isSubsequence1(String s, int indexS, String t, int indexT) {
        if (indexS == s.length()) {
            return true;
        }
        if (indexT == t.length()) {
            return false;
        }
        boolean match = false, skip = false;
        if (s.charAt(indexS) == t.charAt(indexT)) {
            match = isSubsequence1(s, indexS + 1, t, indexT + 1);
        }
        skip = isSubsequence1(s, indexS, t, indexT + 1);
        return match || skip;
    }

    private static boolean isSubsequence2(String s, int indexS, String t, int indexT, int[][] dp) {
        if (dp[indexS][indexT] != -1) {
            return dp[indexS][indexT] != 0;
        }
        if (indexS == s.length()) {
            return true;
        }
        if (indexT == t.length()) {
            return false;
        }
        boolean match = false, skip = false;
        if (s.charAt(indexS) == t.charAt(indexT)) {
            match = isSubsequence2(s, indexS + 1, t, indexT + 1, dp);
        }
        skip = isSubsequence2(s, indexS, t, indexT + 1, dp);
        dp[indexS][indexT] = (match || skip) ? 1 : 0;
        return match || skip;
    }

    private static boolean isSubsequence3(String s, int indexS, String t, int indexT) {
        while (indexS < s.length() && indexT < t.length()) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++;
                indexT++;
            } else {
                indexT++;
            }
        }
        return indexS == s.length();
    }

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}