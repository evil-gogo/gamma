package leetcode.m_2743_count_substrings_without_repeating_character;

//https://leetcode.com/problems/count-substrings-without-repeating-character/description/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int numberOfSpecialSubstrings(String s) {
        Set<Character> charSet = new HashSet<>();
        int numberOfSpecialSubstrings = 0;
        int leftIndex = 0, rightIndex = 0;
        while (rightIndex < s.length()) {
            while (charSet.contains(s.charAt(rightIndex))) {
                charSet.remove(s.charAt(leftIndex++));
            }
            charSet.add(s.charAt(rightIndex));
            numberOfSpecialSubstrings += (rightIndex - leftIndex + 1);
            rightIndex++;
        }
        return numberOfSpecialSubstrings;
    }

    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(numberOfSpecialSubstrings(s));
    }
}
