package leetcode.medium.m_1328_break_a_palindrome;

//https://leetcode.com/problems/break-a-palindrome/description/

class Solution {
    public static String breakPalindrome(String palindrome) {
        char[] charArray = palindrome.toCharArray();
        for (int i = 0; i < charArray.length / 2; i++) {
            if (charArray[i] != 'a') {
                charArray[i] = 'a';
                return new String(charArray);
            }
        }

        charArray[charArray.length - 1] = 'b';
        return charArray.length == 1 ? "" : new String(charArray);
    }

    public static void main(String[] args) {
        String palindrome = "abccba";
        System.out.println(breakPalindrome(palindrome));
    }
}
