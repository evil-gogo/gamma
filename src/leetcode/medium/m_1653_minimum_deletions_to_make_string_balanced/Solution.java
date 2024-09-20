package leetcode.medium.m_1653_minimum_deletions_to_make_string_balanced;

//https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/description/

class Solution {
    public static int minimumDeletions(String s) {
        int minDeletions = 0, countB = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                countB++;
            } else {
                minDeletions = Math.min(minDeletions + 1, countB);
            }
        }
        return minDeletions;
    }

    public static void main(String[] args) {
        String s = "aababbab";
        //String s = "bbaaaaabb";
        System.out.println(minimumDeletions(s));
    }
}
