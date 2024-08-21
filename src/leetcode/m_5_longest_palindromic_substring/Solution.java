package leetcode.m_5_longest_palindromic_substring;

//https://leetcode.com/problems/longest-palindromic-substring/description/

class Solution {
    public static String longestPalindrome(String s) {
        return longestPalindrome1(s);
        //return longestPalindrome2(s);
    }

    private static String longestPalindrome1(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxStartIndex = 0, maxEndIndex = 0, maxLength = 1;

        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            for (int startIndex = 0; startIndex < endIndex; startIndex++) {
                if (s.charAt(startIndex) == s.charAt(endIndex) && (endIndex - startIndex == 1 || dp[startIndex + 1][endIndex - 1])) {
                    dp[startIndex][endIndex] = true;
                    if (endIndex - startIndex + 1 > maxLength) {
                        maxLength = endIndex - startIndex + 1;
                        maxStartIndex = startIndex;
                        maxEndIndex = endIndex;
                    }
                }
            }
        }

        return s.substring(maxStartIndex, maxEndIndex + 1);
    }

    private static String longestPalindrome2(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String longestPalindrom = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            String oddPalindrome = expandFromCenter(s, i, i);
            String evenPalindrome = expandFromCenter(s, i, i + 1);

            if (oddPalindrome.length() > longestPalindrom.length()) {
                longestPalindrom = oddPalindrome;
            }
            if (evenPalindrome.length() > longestPalindrom.length()) {
                longestPalindrom = evenPalindrome;
            }
        }
        return longestPalindrom;
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
