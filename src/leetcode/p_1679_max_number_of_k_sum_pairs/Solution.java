package leetcode.p_1679_max_number_of_k_sum_pairs;

//https://leetcode.com/problems/max-number-of-k-sum-pairs/description/

import java.util.Arrays;

class Solution {
    public static int maxOperations(int[] nums, int k) {
        int leftIndex = 0, rightIndex = nums.length - 1, counter = 0, sum;

        Arrays.sort(nums);

        while (leftIndex < rightIndex) {
            sum = nums[leftIndex] + nums[rightIndex];

            if (sum == k) {
                ++counter;
                ++leftIndex;
                --rightIndex;
            } else if (sum > k) {
                --rightIndex;
            } else {
                ++leftIndex;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int k = 5;
        System.out.println(maxOperations(nums, k));
    }
}
