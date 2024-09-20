package leetcode.hard.h_719_find_k_th_smallest_pair_distance;

//https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/

import java.util.Arrays;

class Solution {
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int leftIndex = 0, rightIndex = nums[n - 1] - nums[0];

        int result = 0;
        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (countPairs(nums, midIndex) < k) {
                leftIndex = midIndex + 1;
            } else {
                result = midIndex;
                rightIndex = midIndex - 1;
            }
        }

        return result;
    }

    private static int countPairs(int[] nums, int maxDistance) {
        int count = 0, j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && nums[j] - nums[i] <= maxDistance) {
                j++;
            }
            count += j - i - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1};
        int k = 1;
        System.out.println(smallestDistancePair(nums, k));
    }
}
