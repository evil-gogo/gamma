package leetcode.p_213_house_robber_II;

//https://leetcode.com/problems/house-robber-ii/description/

class Solution {
    public static int rob(int[] nums) {
        int houseCount = nums.length;
        if (houseCount == 1) {
            return nums[0];
        }
        int[] t = new int[nums.length + 1];
        return Math.max(robMaxMoney(nums, t, 0, houseCount - 1), robMaxMoney(nums, t, 1, houseCount));
    }

    private static int robMaxMoney(int[] nums, int[] t, int startIndex, int endIndex) {
        t[startIndex] = 0;
        t[startIndex + 1] = nums[startIndex];

        for (int i = startIndex + 2; i <= endIndex; i++) {
            int skip = t[i - 1];
            int steal = nums[i - 1] + t[i - 2];
            t[i] = Math.max(steal, skip);
        }
        return t[endIndex];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }
}
