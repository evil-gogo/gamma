package companies.microsoft.interview.P_300_longest_increasing_subsequence;

//https://leetcode.com/problems/longest-increasing-subsequence/description/

import java.util.Arrays;

class Solution {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);
        int maxLength = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    if (maxLength < lis[i]) {
                        maxLength = lis[i];
                    }
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        //int[] nums = {10};

        System.out.println("lengthOfLIS : " + lengthOfLIS(nums));
    }
}
