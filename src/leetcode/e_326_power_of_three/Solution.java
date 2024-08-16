package leetcode.e_326_power_of_three;

//https://leetcode.com/problems/power-of-three/description/

class Solution {
    public static boolean isPowerOfThree(int n) {
        if (n <= 3) {
            return n == 1 || n == 3;
        }
        while (n >= 3) {
            if (n % 3 != 0) {
                return false;
            } else {
                n = n / 3;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        int n = 27;
        System.out.println(isPowerOfThree(n));
    }
}
