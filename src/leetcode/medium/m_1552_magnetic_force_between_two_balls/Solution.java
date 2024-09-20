package leetcode.medium.m_1552_magnetic_force_between_two_balls;

//https://leetcode.com/problems/magnetic-force-between-two-balls/description/

import java.util.Arrays;

class Solution {
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int leftIndex = 1, rightIndex = position[position.length - 1];

        while (leftIndex < rightIndex) {
            int midIndex = (leftIndex + rightIndex + 1) >>> 1;

            if (isFeasible(position, midIndex, m)) {
                leftIndex = midIndex;
            } else {
                rightIndex = midIndex - 1;
            }
        }

        return leftIndex;
    }

    private static boolean isFeasible(int[] position, int distance, int m) {
        int prevPosition = position[0];
        int count = 1;

        for (int i = 1; i < position.length; ++i) {
            int currentPosition = position[i];

            if (currentPosition - prevPosition >= distance) {
                prevPosition = currentPosition;
                ++count;
                if (count == m) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] position = {1, 2, 3, 4, 7};
        int m = 3;
        System.out.println(maxDistance(position, m));
    }
}