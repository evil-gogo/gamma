package leetcode.e_338_counting_bits;

//https://leetcode.com/problems/counting-bits/description/

import java.util.Arrays;

class Solution {
    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            //System.out.println(i + " " + Integer.toBinaryString(i) + " | " + (i >> 1) + " " + Integer.toBinaryString(i >> 1));
            //ans[i] = ans[i >> 1] + (i & 1);
            //ans[i] = ans[i / 2] + (i % 2);
            if (i == 0) {
                ans[i] = 0;
            } else {
                ans[i] = ans[i & (i - 1)] + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = countBits(5);
        System.out.println(Arrays.toString(ans));
    }
}
