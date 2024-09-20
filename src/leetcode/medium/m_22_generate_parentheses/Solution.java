package leetcode.medium.m_22_generate_parentheses;

//https://leetcode.com/problems/generate-parentheses/description/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        generate("", 0, 0, n, result);
        return result;
    }

    private static void generate(String currentString, int openCount, int closeCount, int n, List<String> result) {
        if (openCount > n || closeCount > n || openCount < closeCount) {
            return;
        }
        if (openCount == n && closeCount == n) {
            result.add(currentString);
            return;
        }
        generate(currentString + "(", openCount + 1, closeCount, n, result);
        generate(currentString + ")", openCount, closeCount + 1, n, result);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}
