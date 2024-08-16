package leetcode.h_214_shortest_palindrome;

//https://leetcode.com/problems/shortest-palindrome/description/

import java.util.Arrays;

class Solution {
    public static String shortestPalindrome(String s) {
        String pattern = s + "$" + new StringBuilder(s).reverse();

        int[] lps = calculateLPS(pattern.toCharArray());
        System.out.println(Arrays.toString(lps));
        int matchedLength = lps[lps.length - 1];

        s = new StringBuilder(s.substring(matchedLength)).reverse() + s;
        return s;
    }

    private static int[] calculateLPS(char[] arr) {
        int[] lps = new int[arr.length];

        int index = 0, i = 1;
        while (i < arr.length) {
            if (arr[index] == arr[i]) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index == 0) {
                    lps[i] = index;
                    i++;
                } else {
                    index = lps[index - 1];
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(shortestPalindrome(s));
    }
}
