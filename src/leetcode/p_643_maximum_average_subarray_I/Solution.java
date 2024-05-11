package leetcode.p_643_maximum_average_subarray_I;

//https://leetcode.com/problems/maximum-average-subarray-i/description/?

class Solution {
    public static double findMaxAverage(int[] nums, int k) {
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        int maxSum = currentSum;

        for (int i = k; i < nums.length; i++) {
            currentSum = currentSum + nums[i] - nums[i - k];
            maxSum = Math.max(currentSum, maxSum);
        }
        return (double)maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println("Hell");
        System.out.println(findMaxAverage(nums, k));
    }
}
