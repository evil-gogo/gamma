package leetcode.medium.m_647_palindromic_substrings;

//https://leetcode.com/problems/palindromic-substrings/description/

class Solution {
    static int count;

    public static int countSubstrings(String s) {
        return countSubstrings1(s);
        //return countSubstrings2(s);
    }

    public static int countSubstrings1(String s) {
        count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            count++;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    count++;
                }
            }
        }

        return count;
    }

    public static int countSubstrings2(String s) {
        int n = s.length();
        count = 0;

        for (int i = 0; i < n; i++) {
            expandFromCenter(s, i, i, n);
            expandFromCenter(s, i, i + 1, n);
        }
        return count;
    }

    private static void expandFromCenter(String s, int leftIndex, int rightIndex, int n) {
        while (leftIndex >= 0 && rightIndex < n && s.charAt(leftIndex) == s.charAt(rightIndex)) {
            count++;
            leftIndex--;
            rightIndex++;
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(countSubstrings(s));
    }
}
