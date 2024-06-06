package companies.microsoft.online_assesment.longest_semi_alternating_substring;

//https://algo.monster/problems/longest_semi_alternating_substring

class Solution {
    public static int longestSemiSubstring(String s) {
        if (s.length() < 3) {
            return s.length();
        }
        int count = 2, result = 0;
        for (int i = 2; i < s.length() ; i++) {
            if (s.charAt(i - 1) == s.charAt(i) && s.charAt(i - 2) == s.charAt(i)) {
                result = Math.max(result, count);
                count = 2;
            } else {
                count++;
            }
        }
        return Math.max(result, count);
    }

    public static void main(String[] args) {
        String s = "abaaaa";
        System.out.println(longestSemiSubstring(s));
    }
}
