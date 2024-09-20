package leetcode.easy.e_605_can_place_flowers;

//https://leetcode.com/problems/can-place-flowers/description/

import java.util.Arrays;

class Solution {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        //return canPlaceFlowers1(flowerbed, n);
        return canPlaceFlowers2(flowerbed, n);
    }

    private static boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int size = flowerbed.length;
        int[] dp = new int[size + 2];
        Arrays.fill(dp, -1);
        return solve(flowerbed, 0, n, size, dp);
    }

    private static boolean solve(int[] flowerbed, int index, int n, int size, int[] dp) {
        if (dp[index] != -1) {
            return dp[index] != 0;
        }
        if (n == 0) {
            dp[index] = 1;
            return true;
        }
        if (index > size - 1) {
            dp[index] = 0;
            return false;
        }

        if (flowerbed[index] == 1) {
            boolean skip = solve(flowerbed, index + 2, n, size, dp);
            dp[index] = skip ? 1 : 0;
            return skip;
        } else {
            boolean plant = false;
            if (index == size - 1 || (index + 1 < size && flowerbed[index + 1] != 1)) {
                plant = solve(flowerbed, index + 2, n - 1, size, dp);
            }
            boolean skip = solve(flowerbed, index + 1, n, size, dp);
            dp[index] = (plant || skip) ? 1 : 0;
            return plant || skip;
        }
    }

    private static boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int length = flowerbed.length;

        for (int i = 0; i < length; i++) {
            int left = i == 0 ? 0 : flowerbed[i - 1];
            int right = i == length - 1 ? 0 : flowerbed[i + 1];

            if (left + flowerbed[i] + right == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }

        return n <= 0;
    }

    public static void main(String[] args) {
        int[] flowerbed = {0, 1, 0, 1, 0, 1, 0, 0};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }
}
