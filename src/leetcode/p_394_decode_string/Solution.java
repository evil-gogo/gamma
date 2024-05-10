package leetcode.p_394_decode_string;

import java.util.Stack;

class Solution {
    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        StringBuilder tempSB = new StringBuilder();
        StringBuilder poppedSB = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == Character.valueOf(']')) {
                char c;
                while ((stack.pop()) != Character.valueOf('[')) {
                    poppedSB.append(stack.pop());
                    System.out.println("stackI " + stack + stack.pop().equals("["));
                }
            } else {
                stack.push(s.charAt(i));
                System.out.println("stackE " + stack);
            }
        }
        System.out.println("stack " + stack);
        System.out.println("popped SB " + poppedSB);
        return null;

    }

    public static void main(String[] args) {
        //String s = "3[a]2[bc]";
        String s = "3[a2[c]]";
        System.out.println(decodeString(s));
    }
}
