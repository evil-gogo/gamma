package leetcode.hard.h_42_trapping_rain_water;

//https://leetcode.com/problems/trapping-rain-water/description/

import java.util.Arrays;

class Solution {
    public static int trap(int[] height) {
        return trap1(height);
        //return trap2(height);
    }
    public static int trap1(int[] height) {
        int[] maxHeightLeft = new int[height.length];
        int[] maxHeightRight = new int[height.length];

        int currentMaxHeight = 0;
        for (int i = 0; i < height.length; i++) {
            maxHeightLeft[i] = currentMaxHeight;
            if (currentMaxHeight < height[i]) {
                currentMaxHeight = height[i];
            }

        }
        currentMaxHeight = 0;
        for (int i = height.length - 1; i >= 0 ; i--) {
            maxHeightRight[i] = currentMaxHeight;
            if (currentMaxHeight < height[i]) {
                currentMaxHeight = height[i];
            }
        }
        System.out.println(Arrays.toString(maxHeightLeft));
        System.out.println(Arrays.toString(maxHeightRight));
        int totalTrappedWater = 0;

        for (int i = 0; i < height.length; i++) {
            if (height[i] < maxHeightLeft[i] && height[i] < maxHeightRight[i]) {
                totalTrappedWater += Math.min(maxHeightLeft[i], maxHeightRight[i]) - height[i];
            }
        }

        return totalTrappedWater;
    }

    public static int trap2(int[] height) {
        int maxHeightLeft = height[0], maxHeightRight = height[height.length - 1];
        int indexLeft = 1, indexRight = height.length - 1 - 1;

        int totalTrappedWater = 0;

        while (indexLeft <= indexRight) {
            if (maxHeightLeft < maxHeightRight) {
                if (maxHeightLeft <= height[indexLeft]) {
                    maxHeightLeft = height[indexLeft];
                } else {
                    totalTrappedWater += maxHeightLeft - height[indexLeft];
                }
                indexLeft++;
            } else {
                if (maxHeightRight <= height[indexRight]) {
                    maxHeightRight = height[indexRight];
                } else {
                    totalTrappedWater += maxHeightRight - height[indexRight];
                }
                indexRight--;
            }
        }
        return totalTrappedWater;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }
}
