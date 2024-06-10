package companies.microsoft.interview.p_31_next_permutation;

//https://leetcode.com/problems/next-permutation/description/

import java.util.Arrays;

class Solution {
    public static void nextPermutation(int[] nums) {
        int length = nums.length;
        int lastPeakIndex = length - 1 - 1;

        while (lastPeakIndex >= 0 && nums[lastPeakIndex] >= nums[lastPeakIndex + 1]) {
            lastPeakIndex--;
        }

        if (lastPeakIndex >= 0) {
            for (int j = length - 1; j > lastPeakIndex; j--) {
                if (nums[j] > nums[lastPeakIndex]) {
                    swap(nums, lastPeakIndex, j);
                    break;
                }
            }
        }

        int start = lastPeakIndex + 1, end = length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        //int[] nums = {1, 2, 3};
        int[] nums = {1, 3, 5, 4, 2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
