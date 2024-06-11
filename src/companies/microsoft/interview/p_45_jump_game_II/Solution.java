package companies.microsoft.interview.p_45_jump_game_II;

//https://leetcode.com/problems/jump-game-ii/description/

import java.util.Arrays;

class Solution {
    public static int jump(int[] nums) {
        return jump1(nums);
        //return jump2(nums);
    }

    public static int jump1(int[] nums) {
        int steps = 0, maxReachableIndex = 0, lastJumpMaxReachableIndex = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxReachableIndex = Math.max(maxReachableIndex, i + nums[i]);

            if (lastJumpMaxReachableIndex == i) {
                lastJumpMaxReachableIndex = maxReachableIndex;
                steps++;

                if (maxReachableIndex >= nums.length - 1) {
                    break;
                }
            }
        }

        return steps;
    }

    public static int jump2(int[] nums) {
        int[] jump = new int[nums.length];
        int[] result = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            jump[i] = Integer.MAX_VALUE;
        }

        jump[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    if (jump[j] + 1 < jump[i]) {
                        result[i] = j;
                        jump[i] = jump[j] + 1;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(result));

        return jump[jump.length - 1];
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }
}
