package leetcode.m_34_find_first_and_last_position_of_element_in_sorted_array;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

import java.util.Arrays;

class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        Arrays.fill(res, -1);

        if (nums.length == 1) {
            return res;
        }
        int leftIndex = 0, rightIndex = nums.length - 1, index = 0;

        while (leftIndex < rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (nums[midIndex] == target) {

                if (midIndex > 0 && nums[midIndex - 1] == target) {
                    res[index++] = midIndex - 1;
                    res[index] = midIndex;
                    return res;
                } else if (midIndex < nums.length - 1 && nums[midIndex + 1] == target) {
                    res[index++] = midIndex;
                    res[index] = midIndex + 1;
                }
            } else {
                if (nums[midIndex] < target) {
                    leftIndex = midIndex + 1;
                } else {
                    rightIndex = midIndex - 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        int[] result = searchRange(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
