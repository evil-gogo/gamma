package companies.microsoft.interview.p_33_search_in_rotated_sorted_array;

//https://leetcode.com/problems/search-in-rotated-sorted-array/description/

class Solution {
    public static int search(int[] nums, int target) {
        int leftIndex = 0, rightIndex = nums.length - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;

            if (nums[midIndex] == target) {
                return midIndex;
            }

            if (nums[leftIndex] <= nums[midIndex]) {
                if (nums[leftIndex] <= target && target < nums[midIndex]) {
                    rightIndex = midIndex - 1;
                } else {
                    leftIndex = midIndex + 1;
                }
            } else {
                if (nums[midIndex] < target && target <= nums[rightIndex]) {
                    leftIndex = midIndex + 1;
                } else {
                    rightIndex = midIndex - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));
    }
}
