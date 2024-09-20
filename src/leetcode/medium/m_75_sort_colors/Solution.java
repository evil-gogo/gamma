package leetcode.medium.m_75_sort_colors;

//https://leetcode.com/problems/sort-colors/description/

import java.util.Arrays;

class Solution {
    public static void sortColors(int[] nums) {
        int lastZeroIndex = -1;
        int firstTwoIndex = nums.length;
        int currIndex = 0;

        while (currIndex < firstTwoIndex) {
            if (nums[currIndex] == 0) {
                swap(nums, ++lastZeroIndex, currIndex);
                currIndex++;
            } else if (nums[currIndex] == 2) {
                swap(nums, --firstTwoIndex, currIndex);
            } else {
                ++currIndex;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
