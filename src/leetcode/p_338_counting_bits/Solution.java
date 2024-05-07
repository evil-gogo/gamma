package leetcode.p_338_counting_bits;

//https://leetcode.com/problems/counting-bits/description/

class Solution {
    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            //System.out.println(i + " " + Integer.toBinaryString(i) + " | " + (i>>1) + " " + Integer.toBinaryString(i>>1));
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] ans = countBits(5);
        for (int i = 0; i <= n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
