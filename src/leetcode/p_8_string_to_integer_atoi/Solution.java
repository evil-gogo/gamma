package leetcode.p_8_string_to_integer_atoi;

import java.util.Objects;

class Solution {
    public static int myAtoi(String s) {
        if (s.isEmpty() || s.matches("[a-zA-Z]+")) {
            return 0;
        }
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        int sign = 1;
        if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }
        int res = 0, threshold = Integer.MAX_VALUE / 10;
        for (int i = index; i < s.length(); i++) {
            if (res > threshold || (res == threshold && s.charAt(i) > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                break;
            }

            res = res * 10 + s.charAt(i) - '0';
        }
        return sign * res;
    }

    public static void main(String[] args) {
        String s = "42";
        System.out.println(myAtoi(s));
    }
}
