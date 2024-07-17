package leetcode.p_334_increasing_triplet_subsequence;

//https://leetcode.com/problems/increasing-triplet-subsequence/description/

import java.util.Arrays;

class Solution {
    public static boolean increasingTriplet(int[] nums) {
        int k = 3;
        int[] sequence = new int[k];
        Arrays.fill(sequence, Integer.MAX_VALUE);

        for (int num : nums) {
            int i = 0;
            while (sequence[i] < num) {
                i++;
            }
            sequence[i] = num;

            if (i == k - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //int[] nums = {1, 2, 3, 4, 5};
        int[] nums = {2, 1, 5, 0, 4, 6};
        //int[] nums = {20, 100, 10, 12, 5, 13};
        System.out.println(increasingTriplet(nums));
    }
}
