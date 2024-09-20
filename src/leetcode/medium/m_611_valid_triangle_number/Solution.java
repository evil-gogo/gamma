package leetcode.medium.m_611_valid_triangle_number;

//https://leetcode.com/problems/valid-triangle-number/description/

import java.util.Arrays;

class Solution {
    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = nums.length;
        int result = 0;

        for (int i = count - 1; i >= 2; --i) {
            int left = 0, right = i - 1;

            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    result += right - left;
                    --right;
                } else {
                    ++left;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4};
        System.out.println(triangleNumber(nums));
    }
}
