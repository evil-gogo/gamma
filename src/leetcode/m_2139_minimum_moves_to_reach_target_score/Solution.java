package leetcode.m_2139_minimum_moves_to_reach_target_score;

//https://leetcode.com/problems/minimum-moves-to-reach-target-score/description/

class Solution {
    public static int minMoves(int target, int maxDoubles) {
        int moves = 0;

        while (maxDoubles > 0 && target > 1) {
            moves++;

            if (target % 2 == 1) {
                target--;
            } else {
                target /= 2;
                maxDoubles--;
            }
        }

        moves += target - 1;

        return moves;
    }

    public static void main(String[] args) {
        int target = 19, maxDoubles = 2;
        System.out.println(minMoves(target, maxDoubles));

    }
}
