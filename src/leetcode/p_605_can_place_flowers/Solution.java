package leetcode.p_605_can_place_flowers;

//https://leetcode.com/problems/can-place-flowers/description/

class Solution {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
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
        int [] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }
}
