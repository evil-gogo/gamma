package companies.microsoft.interview.p_190_reverse_bits;

//https://leetcode.com/problems/reverse-bits/description/

public class Solution {
    public static int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32 && n != 0; i++) {
            result |= ((n & 1) << (31 - i));
            n >>>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = Integer.parseUnsignedInt("00000010100101000001111010011100", 2);
        System.out.println(reverseBits(n));
    }
}