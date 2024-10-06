package leetcode.medium.m_1017_convert_to_base_2;

//https://leetcode.com/problems/convert-to-base-2/description/

class Solution {
    public static String baseNeg2(int n) {
        return solve1(n);
        //return solve2(n);
    }

    private static String solve1(int n) {
        if (n == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        int remainder, base = -2;

        while (n != 0) {
            remainder = n % base;
            n = n / base;
            if (remainder < 0) {
                remainder = remainder - base;
                n++;
            }
            sb.append(remainder);
        }
        return sb.reverse().toString();
    }

    private static String solve2(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb = new StringBuilder((((n & 1) == 1) ? "1" : "0") + sb);
            n = -(n >> 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(baseNeg2(n));
    }
}
