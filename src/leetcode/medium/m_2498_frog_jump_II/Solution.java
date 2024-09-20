package leetcode.medium.m_2498_frog_jump_II;

//https://leetcode.com/problems/frog-jump-ii/description/
//https://www.youtube.com/watch?v=7eqGntQ7-Fs&ab_channel=CheatCodeNinja

class Solution {
    public static int maxJump(int[] stones) {
        int maxJumpDistance = stones[1] - stones[0];
        if (stones.length == 2) {
            return maxJumpDistance;
        }

        for (int i = 2; i < stones.length; ++i) {
            int jumpDistance = stones[i] - stones[i - 2];

            maxJumpDistance = Math.max(maxJumpDistance, jumpDistance);
        }

        return maxJumpDistance;
    }

    public static void main(String[] args) {
        int[] stones = {0, 2, 5, 6, 7};
        System.out.println(maxJump(stones));
    }
}
