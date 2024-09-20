package leetcode.medium.m_1283_find_the_smallest_divisor_given_a_threshold;

//https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/

class Solution {
    public static int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int startIndex = 1, endIndex = max;
        while (startIndex <= endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            if (findSum(nums, midIndex) > threshold) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }

        }
        return startIndex;
    }

    public static int findSum(int[] nums, int divisor) {
        int value = 0;
        for (int num : nums) {
            value += (int) Math.ceil((double) num / divisor);
        }
        return value;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        System.out.println(smallestDivisor(nums, threshold));
    }
}
