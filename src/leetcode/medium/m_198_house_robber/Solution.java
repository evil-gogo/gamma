package leetcode.medium.m_198_house_robber;

//https://leetcode.com/problems/house-robber/description/

class Solution {
    public static int rob(int[] nums) {
//        return robUtil1(nums, 0);
//
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, -1);
//        return robUtil2(nums, 0, dp);

        int[] t = new int[nums.length + 1];
        return robUtil3(nums, t);
    }

    private static int robUtil1(int[] nums, int index) {
        if (index > nums.length - 1) {
            return 0;
        }
        int skip = robUtil1(nums, index + 1);
        int steal = nums[index] + robUtil1(nums, index + 2);
        return Math.max(skip, steal);
    }

    private static int robUtil2(int[] nums, int index, int[] dp) {
        if (index > nums.length - 1) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int skip = robUtil2(nums, index + 1, dp);
        int steal = nums[index] + robUtil2(nums, index + 2, dp);
        dp[index] = Math.max(skip, steal);
        return dp[index];
    }

    private static int robUtil3(int[] nums, int[] t) {
        t[0] = 0;
        t[1] = nums[0];

        for (int i = 2; i <= nums.length; i++) {
            int skip = t[i - 1];
            int steal = nums[i - 1] + t[i - 2];
            t[i] = Math.max(skip, steal);
        }
        return t[nums.length];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }
}
