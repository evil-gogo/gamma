package leetcode.e_1304_find_n_unique_integers_sum_up_to_zero;

//https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description/

import java.util.Arrays;

class Solution {
    public static int[] sumZero(int n) {
        int[] res = new int[n];
        int range = n;
//        while (n * range < n) {
//            range++;
//        }
        for (int i = 0; i < n/2; i++) {
            res[i] = range;
            res[n - 1 - i] = -range;
            range--;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(sumZero(n)));
    }
}
