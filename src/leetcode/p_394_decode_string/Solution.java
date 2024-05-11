package leetcode.p_394_decode_string;

//https://leetcode.com/problems/decode-string/description/

import java.util.Stack;

class Solution {
    public static String decodeString(String s) {
        if (s.length() == 0 || s == null) {
            return s;
        }
        Stack<String> stackString = new Stack<>();
        Stack<Integer> stackNumber = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int num = 0;
                while (Character.isDigit(s.charAt(index))) {
                    num = num * 10 + (s.charAt(index) - '0');
                    index++;
                }
                stackNumber.push(num);
            } else {
                switch (s.charAt((index))) {
                    case '[':
                        stackString.push(sb.toString());
                        sb = new StringBuilder();
                        index++;
                        break;
                    case ']':
                        StringBuilder tempSb = new StringBuilder(stackString.pop());
                        int repeatTimes = stackNumber.pop();
                        for (int i = 0; i < repeatTimes; i++) {
                            tempSb.append(sb);
                        }
                        sb = tempSb;
                        index++;
                        break;
                    default:
                        sb.append(s.charAt(index++));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        //String s = "3[a2[c]]";
        System.out.println(decodeString(s));
    }
}
