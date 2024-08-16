package leetcode.m_151_reverse_words_in_a_string;

//https://leetcode.com/problems/reverse-words-in-a-string/description/

class Solution {
    public static String reverseWords(String s) {
        String[] stringSplit = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = stringSplit.length - 1; i >= 0; i--) {
            sb.append(stringSplit[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("The sky is blue"));
    }
}
