package leetcode.medium.m_2300_successful_pairs_of_spells_and_potions;

//https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/

import java.util.Arrays;

class Solution {
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];

        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            int midIndex = 0;
            int startIndex = 0, endIndex = potions.length - 1;
            while (startIndex <= endIndex) {
                midIndex = startIndex + (endIndex - startIndex) / 2;
                if (((long) spells[i] * potions[midIndex]) < success) {
                    startIndex = midIndex + 1;
                } else {
                    endIndex = midIndex - 1;
                }
            }
            res[i] = potions.length - startIndex;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] spells = {5, 1, 3}, potions = {1, 2, 3, 4, 5};
        int success = 7;
        System.out.println(Arrays.toString(successfulPairs(spells, potions, success)));
    }
}
