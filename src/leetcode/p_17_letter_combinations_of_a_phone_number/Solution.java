package leetcode.p_17_letter_combinations_of_a_phone_number;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

import java.util.LinkedList;
import java.util.List;

class Solution {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();

        if (digits.isEmpty()) {
            return result;
        }

        result.add("");

        String[] digitToLetters = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (char digit : digits.toCharArray()) {
            String letters = digitToLetters[digit - '2'];

            List<String> temp = new LinkedList<>();

            for (String combination : result) {
                for (char letter : letters.toCharArray()) {
                    temp.add(combination + letter);
                }
            }
            result = temp;
        }

        return result;
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
