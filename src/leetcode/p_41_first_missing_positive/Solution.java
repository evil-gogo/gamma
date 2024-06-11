package leetcode.p_41_first_missing_positive;

//https://leetcode.com/problems/first-missing-positive/description/

class Solution {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean is1Exists = false;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                is1Exists = true;
            }
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        if (!is1Exists) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            int absValue = Math.abs(nums[i]);
            int index = absValue - 1;

            if (nums[index] < 0) {
                continue;
            }
            nums[index] *= -1;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums));
    }
}

