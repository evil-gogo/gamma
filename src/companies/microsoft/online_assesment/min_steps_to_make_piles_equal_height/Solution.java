package companies.microsoft.online_assesment.min_steps_to_make_piles_equal_height;

//https://algo.monster/problems/min_steps_to_make_piles_equal_height

import java.util.Arrays;

class Solution {

    public static int minSteps(int[] piles) {
        Arrays.sort(piles);

        int minSteps = 0, greaterThanElementCount = 1;
        for (int i = piles.length - 1; i > 0; i--) {
            if (piles[i] != piles[i - 1]) {
                minSteps += greaterThanElementCount;
            }
            greaterThanElementCount++;
        }
        return minSteps;
    }

    public static void main(String[] args) {
        int[] piles = {5, 2, 1};
        System.out.println(minSteps(piles));
    }
}
