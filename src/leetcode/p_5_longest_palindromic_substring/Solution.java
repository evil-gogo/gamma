package leetcode.p_5_longest_palindromic_substring;

class Solution {
    public static String longestPalindrome(String s) {
        return longestPalindrome1(s);
        //return longestPalindrome2(s);
    }

    private static String longestPalindrome1(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int startIndex = 0, endIndex = 0, maxLength = 1;

        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLength) {
                        maxLength = i - j + 1;
                        startIndex = j;
                        endIndex = i;
                    }
                }
            }
        }

        return s.substring(startIndex, endIndex + 1);
    }

    private static String longestPalindrome2(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String maxStr = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            String odd = expandFromCenter(s, i, i);
            String even = expandFromCenter(s, i, i + 1);

            if (odd.length() > maxStr.length()) {
                maxStr = odd;
            }
            if (even.length() > maxStr.length()) {
                maxStr = even;
            }
        }
        return maxStr;
    }

    private static String expandFromCenter(String s, int leftIndex, int rightIndex) {
        while (leftIndex >= 0 && rightIndex < s.length() && s.charAt(leftIndex) == s.charAt(rightIndex)) {
            leftIndex--;
            rightIndex++;
        }
        return s.substring(leftIndex + 1, rightIndex);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
