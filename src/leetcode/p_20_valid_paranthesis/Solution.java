package leetcode.p_20_valid_paranthesis;

//https://leetcode.com/problems/valid-parentheses/

import java.util.Stack;

class Solution {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() && (c == ')' || c == '}' || c == ']')) {
                return false;
            }
            switch (c) {
                case ')':
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                default:
                    stack.push(s.charAt(i));
            }
        }
        return (stack.size() == 0);
    }

    public static void main(String[] args) {
        //System.out.println(isValid("()[]{}"));
        System.out.println(isValid("]"));
    }
}