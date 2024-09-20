package leetcode.medium.m_875_koko_eating_bananas;

//https://leetcode.com/problems/koko-eating-bananas/description/

class Solution {
    public static int minEatingSpeed(int[] piles, int h) {
        int startIndex = 0, endIndex = 0;
        for (int i : piles) {
            endIndex = Math.max(endIndex, i);
        }

        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if (canEatInTime(piles, midIndex, h)) {
                endIndex = midIndex - 1;
            } else {
                startIndex = midIndex + 1;
            }
        }
        return startIndex;
    }

    public static boolean canEatInTime(int[] piles, int k, int h) {
        int hours = 0;
        for (int p : piles) {
            hours += Math.ceil((double) p / k);
        }
        return hours <= h;
    }

    public static void main(String[] args) {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 5;
        System.out.println(minEatingSpeed(piles, h));
    }
}
