package leetcode.m_1493_longest_subarray_of_1_s_after_deleting_one_element;

//https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/

class Solution {
    public static int longestSubarray(int[] nums) {
        int k = 1;
        int leftIndex = 0, rightIndex = 0;
        while (rightIndex < nums.length) {
            if (nums[rightIndex] == 0) {
                k--;
            }
            if (k < 0) {
                if (nums[leftIndex] == 0) {
                  k++;
                }
                leftIndex++;
            }
            rightIndex++;
        }
        return rightIndex - leftIndex;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(longestSubarray(nums));
    }
}
