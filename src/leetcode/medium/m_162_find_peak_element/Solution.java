package leetcode.medium.m_162_find_peak_element;

//https://leetcode.com/problems/find-peak-element/description/

class Solution {
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        int startIndex = 1;
        int endIndex = n - 1 - 1;

        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if (nums[midIndex] > nums[midIndex - 1] && nums[midIndex] > nums[midIndex + 1]) {
                return midIndex;
            } else if (nums[midIndex] < nums[midIndex - 1]) {
                endIndex = midIndex - 1;
            } else if (nums[midIndex] < nums[midIndex + 1]) {
                startIndex = midIndex + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(nums));
    }
}
