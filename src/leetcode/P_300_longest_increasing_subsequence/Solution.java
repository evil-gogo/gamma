package leetcode.P_300_longest_increasing_subsequence;

import java.util.Arrays;

//https://leetcode.com/problems/longest-increasing-subsequence/description/
class Solution {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null  || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLength = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (maxLength < dp[i]) {
                        maxLength = dp[i];
                    }
                }
            }
        }

        //int maxLength = Arrays.stream(dp).max().orElse(0);

        return maxLength;
    }
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        //int[] nums = {10};

        System.out.println("lengthOfLIS : " + lengthOfLIS(nums));
    }
}
