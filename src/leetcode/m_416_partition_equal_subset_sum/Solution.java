package leetcode.m_416_partition_equal_subset_sum;

//https://leetcode.com/problems/partition-equal-subset-sum/description/

class Solution {
    public static boolean canPartition(int[] nums) {
        //return canPartition1(nums);
        return canPartition2(nums);
    }

    private static boolean canPartition2(int[] nums) {
        int n = nums.length;
        int targetSum = 0;
        for (int num : nums) {
            targetSum += num;
        }
        if (targetSum % 2 != 0) {
            return false;
        }
        targetSum = targetSum / 2;

        boolean[][] dp = new boolean[n + 1][targetSum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= targetSum; i++) {
            dp[0][i] = false;
        }

        for (int elementIndex = 1; elementIndex <= n; elementIndex++) {
            for (int sum = 1; sum <= targetSum; sum++) {
                if (sum < nums[elementIndex - 1]) {
                    dp[elementIndex][sum] = dp[elementIndex - 1][sum];
                } else if (sum >= nums[elementIndex - 1]) {
                    dp[elementIndex][sum] = dp[elementIndex - 1][sum] || dp[elementIndex - 1][sum - nums[elementIndex - 1]];
                }
            }
        }

        return dp[n][targetSum];
    }

    public static boolean canPartition1(int[] nums) {
        int targetSum = 0;
        for (int num : nums) {
            targetSum += num;
        }
        if (targetSum % 2 != 0) {
            return false;
        }

        boolean[][] memo = new boolean[nums.length + 1][targetSum + 1];
        return subsetSum(nums, 0, targetSum / 2, memo);
    }

    public static boolean subsetSum(int[] nums, int elementIndex, int targetSum, boolean[][] memo) {
        if (targetSum == 0) {
            return true;
        } else if (elementIndex >= nums.length || targetSum < 0) {
            return false;
        }

        if (memo[elementIndex][targetSum]) {
            return true;
        }

        return memo[elementIndex][targetSum] = subsetSum(nums, elementIndex + 1, targetSum - nums[elementIndex], memo)
                || subsetSum(nums, elementIndex + 1, targetSum, memo);
    }

    public static void main(String[] args) {
        //int[] nums = {1, 5, 11, 5};
        int[] nums = {1, 2, 3, 5};
        System.out.println(canPartition(nums));
    }
}
