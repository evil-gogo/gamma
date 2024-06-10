package companies.microsoft.interview.p_153_find_minimum_in_rotated_sorted_array;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

class Solution {
    public static int findMin(int[] nums) {
        int length = nums.length;
        if (nums[0] <= nums[length - 1]) {
            return nums[0];
        }
        int leftIndex = 0, rightIndex = length - 1;

        while (leftIndex < rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;

            if (nums[0] <= nums[midIndex]) {
                leftIndex = midIndex + 1;
            } else {
                rightIndex = midIndex;
            }
        }
        return nums[leftIndex];
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums));
    }
}
