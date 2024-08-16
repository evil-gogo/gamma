package leetcode.m_2470_number_of_subarrays_with_lcm_equal_to_k;

//https://leetcode.com/problems/number-of-subarrays-with-lcm-equal-to-k/description/

class Solution {
    public static int subarrayLCM(int[] nums, int k) {
        int length = nums.length;
        int count = 0;

        for (int i = 0; i < length; ++i) {
            int currentLCM = nums[i];
            for (int j = i; j < length; ++j) {
                int nextElement = nums[j];
                currentLCM = lcm(currentLCM, nextElement);

                if (currentLCM == k) {
                    ++count;
                }
            }
        }
        return count;
    }

    private static int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }

        int absNumber1 = Math.abs(a);
        int absNumber2 = Math.abs(b);

        int absHigherNumber = Math.max(absNumber1, absNumber2);
        int absLowerNumber = Math.min(absNumber1, absNumber2);

        int lcm = absHigherNumber;

        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }

        return lcm;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 2, 7, 1};
        int k = 6;
        System.out.println(subarrayLCM(nums, k));
    }
}
