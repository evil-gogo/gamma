package leetcode.p_283_move_zeros;

//https://leetcode.com/problems/move-zeroes/description/

import java.util.Arrays;

class Solution {
    public static void moveZeroes(int[] nums) {
        int indexZero = 0, temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp = nums[i];
                nums[i] = nums[indexZero];
                nums[indexZero] = temp;

                indexZero++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 0, 1, 2, 3, 12};
        //int[] nums = {1};
        //int[] nums = {1, 0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
