package companies.microsoft.interview.p_377_combination_sum_IV;

//https://leetcode.com/problems/combination-sum-iv/description/

import java.util.Arrays;

class Solution {
    public static int combinationSum4(int[] nums, int target) {
        //return solve1(nums, target, 0);
        int[][] dp = new int[nums.length + 1][target + 1];
        for (int i = 0; i <= nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        //return solve2(nums, target, 0, dp);
        return solve3(nums, target, 0, dp);
    }

    private static int solve1(int[] nums, int target, int index) {
        if (target == 0) {
            return 1;
        }
        if (target < 0 || index > nums.length - 1) {
            return 0;
        }

        int include = solve1(nums, target - nums[index], 0);
        int exclude = solve1(nums, target, index + 1);
        return include + exclude;
    }

    private static int solve2(int[] nums, int target, int index, int[][] dp) {
        if (target == 0) {
            return 1;
        }
        if (target < 0 || index > nums.length - 1) {
            return 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int include = solve2(nums, target - nums[index], 0, dp);
        int exclude = solve2(nums, target, index + 1, dp);
        return dp[index][target] = include + exclude;
    }

    private static int solve3(int[] nums, int target, int index, int[][] dp) {
        if (target == 0) {
            return 1;
        }
        if (target < 0 || index > nums.length - 1) {
            return 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        int include = 0, exclude = 0, result = 0;
        for (int i = index; i < nums.length; i++) {
            include = solve3(nums, target - nums[i], 0, dp);
            //exclude = solve3(nums, target, i + 1, dp);

            //result += include + exclude;
            result += include;
        }
        return dp[index][target] = result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }
}
