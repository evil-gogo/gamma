package leetcode.easy.e_415_add_strings;

//https://leetcode.com/problems/add-strings/description/

class Solution {
    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder answer = new StringBuilder();
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = i < 0 ? 0 : num1.charAt(i) - '0';
            int digit2 = j < 0 ? 0 : num2.charAt(j) - '0';
            carry += digit1 + digit2;
            answer.append(carry % 10);
            carry /= 10;
            --i;
            --j;
        }

        answer.reverse();
        return answer.toString();
    }

    public static void main(String[] args) {
        String num1 = "11", num2 = "123";
        System.out.println(addStrings(num1, num2));
    }
}
