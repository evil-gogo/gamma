package leetcode.medium.m_55_jump_game;

//https://leetcode.com/problems/jump-game/description/

class Solution {
    public static boolean canJump(int[] nums) {
        int maxReachableIndex = 0;

        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            if (maxReachableIndex < currentIndex) {
                return false;
            }
            if (maxReachableIndex >= nums.length - 1) {
                return true;
            }
            maxReachableIndex = Math.max(maxReachableIndex, currentIndex + nums[currentIndex]);
        }
        return true;
    }


    public static void main(String[] args) {
        //int[] nums = {2, 3, 1, 1, 4};
        //int[] nums = {3,2,1,0,4};
        //int[] nums = {2, 5, 0, 0};
        //int[] nums = {2, 0, 0};
        //int[] nums = {3, 0, 8, 2, 0, 0, 1};
        int[] nums = {1, 1, 1, 0};
        System.out.println(canJump(nums));
    }
}
