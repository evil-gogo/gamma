package leetcode.hard.h_403_frog_jump;

//https://leetcode.com/problems/frog-jump/description/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static boolean canCross(int[] stones) {
        Map<Integer, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            positionMap.put(stones[i], i);
        }
        //return solve1(stones, positionMap, 0, 0, stones.length - 1);

        Boolean[][] dp = new Boolean[2001][2001];
        return solve2(stones, positionMap, 0, 0, stones.length - 1, dp);
    }

    private static boolean solve1(int[] stones, Map<Integer, Integer> positionMap, int prevUnits, int currentStoneIndex, int lastStoneIndex) {
        if (currentStoneIndex > lastStoneIndex) {
            return false;
        }
        if (currentStoneIndex == lastStoneIndex) {
            return true;
        }

        int[] nextPossibleJumps = new int[3];
        nextPossibleJumps[0] = prevUnits - 1;
        nextPossibleJumps[1] = prevUnits;
        nextPossibleJumps[2] = prevUnits + 1;

        boolean isNextJumpPossible = false;
        for (int i = 0; i < 3; i++) {
            if (nextPossibleJumps[i] > 0) {
                int nextStone = stones[currentStoneIndex] + nextPossibleJumps[i];
                if (positionMap.containsKey(nextStone)) {
                    int nextStoneIndex = positionMap.get(nextStone);
                    isNextJumpPossible = isNextJumpPossible || solve1(stones, positionMap, nextPossibleJumps[i], nextStoneIndex, lastStoneIndex);
                }
            }
        }
        return isNextJumpPossible;
    }

    private static boolean solve2(int[] stones, Map<Integer, Integer> positionMap, int prevUnits, int currentStoneIndex, int lastStoneIndex, Boolean[][] dp) {
        if (dp[prevUnits][currentStoneIndex] != null) {
            return dp[prevUnits][currentStoneIndex];
        }
        if (currentStoneIndex > lastStoneIndex) {
            return false;
        }
        if (currentStoneIndex == lastStoneIndex) {
            return true;
        }

        int[] nextPossibleJumps = new int[3];
        nextPossibleJumps[0] = prevUnits - 1;
        nextPossibleJumps[1] = prevUnits;
        nextPossibleJumps[2] = prevUnits + 1;

        boolean isNextJumpPossible = false;
        for (int i = 0; i < 3; i++) {
            if (nextPossibleJumps[i] > 0) {
                int nextStone = stones[currentStoneIndex] + nextPossibleJumps[i];
                if (positionMap.containsKey(nextStone)) {
                    int nextStoneIndex = positionMap.get(nextStone);
                    isNextJumpPossible = isNextJumpPossible || solve2(stones, positionMap, nextPossibleJumps[i], nextStoneIndex, lastStoneIndex, dp);
                }
            }
        }
        dp[prevUnits][currentStoneIndex] = isNextJumpPossible;
        return isNextJumpPossible;
    }

    public static void main(String[] args) {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println(canCross(stones));
    }
}