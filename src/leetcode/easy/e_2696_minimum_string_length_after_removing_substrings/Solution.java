package leetcode.easy.e_2696_minimum_string_length_after_removing_substrings;

//https://leetcode.com/problems/minimum-string-length-after-removing-substrings/description/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static int minLength(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        stack.push(' ');

        for (char currentChar : s.toCharArray()) {
            if ((currentChar == 'B' && stack.peek() == 'A') || (currentChar == 'D' && stack.peek() == 'C')) {
                stack.pop();
            } else {
                stack.push(currentChar);
            }
        }
        return stack.size() - 1;
    }

    public static void main(String[] args) {
        String s = "ABFCACDB";
        System.out.println(minLength(s));
    }
}
