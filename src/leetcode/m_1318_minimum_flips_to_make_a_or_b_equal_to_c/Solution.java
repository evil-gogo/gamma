package leetcode.m_1318_minimum_flips_to_make_a_or_b_equal_to_c;

//https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/

class Solution {
    public static int minFlips(int a, int b, int c) {
        int minFlipsCount = 0;
        while (a > 0 || b > 0 || c > 0) {
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;

            if ((bitA | bitB) != bitC) {
                if (bitA == bitB && bitA == 1) {
                    minFlipsCount += 2;
                } else {
                    minFlipsCount += 1;
                }
            }
            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }
        return minFlipsCount;
    }

    public static void main(String[] args) {
        System.out.println(minFlips(2, 6, 5));
    }
}
