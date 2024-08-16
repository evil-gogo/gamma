package leetcode.e_3110_score_of_a_string;

//https://leetcode.com/problems/score-of-a-string/description/

class Solution {
    public static int scoreOfString(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            sum += Math.abs(s.charAt(i + 1) - s.charAt(i));
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(scoreOfString(s));
    }
}
