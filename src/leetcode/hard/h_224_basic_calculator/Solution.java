package leetcode.hard.h_224_basic_calculator;

//https://leetcode.com/problems/basic-calculator/description/

import java.util.Stack;

class Solution {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int result = 0;
        int length = s.length();

        for (int i = 0; i < length; ++i) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int startIndex = i;
                int number = 0;
                while (startIndex < length && Character.isDigit(s.charAt(startIndex))) {
                    number = number * 10 + s.charAt(startIndex) - '0';
                    startIndex++;
                }
                result += sign * number;
                i = startIndex - 1;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;
            } else if (ch == ')') {
                sign = stack.pop();
                result = sign * result + stack.pop();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));
    }
}
