package leetcode.p_91_decode_ways;

class Solution {
    public static int numDecodings(String s) {
        int index = s.charAt(2) - '0' - 1;
        char c = (char) (index + 'A');
        System.out.println(c);

        int[] dp = new int[s.length() + 1];
        solve(s, dp, 0);

        return 0;
    }

    private static void solve(String s, int[] dp, int index) {
        if (index > s.length() - 1) {
            return;
        }

        for (int i = index; i < s.length(); i++) {

        }



    }

    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));
    }
}
