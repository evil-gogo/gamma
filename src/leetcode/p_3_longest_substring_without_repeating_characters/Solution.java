package leetcode.p_3_longest_substring_without_repeating_characters;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

import java.util.HashSet;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s.length();
        }
        HashSet<Character> hashSet = new HashSet<>();
        int maxLength = 0;

        int leftIndex = 0, rightIndex = 0;
        while (rightIndex < s.length()) {
            while (hashSet.contains(s.charAt(rightIndex))) {
                hashSet.remove(s.charAt(leftIndex));
                leftIndex++;
            }
            hashSet.add(s.charAt(rightIndex));
            maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
            rightIndex++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        //String s = "abcabcbb";
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
