package leetcode.m_2447_number_of_subarrays_with_gcd_equal_to_k;

//https://leetcode.com/problems/number-of-subarrays-with-gcd-equal-to-k/description/

class Solution {
    public static int subarrayGCD(int[] nums, int k) {
        int length = nums.length;
        int count = 0;

        for (int i = 0; i < length; ++i) {
            int currentGCD = nums[i];
            for (int j = i; j < length; ++j) {
                int nextElement = nums[j];
                currentGCD = gcd(currentGCD, nextElement);

                if (currentGCD == k) {
                    ++count;
                }
            }
        }
        return count;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] nums = {9, 3, 1, 2, 6, 3};
        int k = 3;
        System.out.println(subarrayGCD(nums, k));
    }
}
