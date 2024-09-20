package leetcode.easy.e_268_missing_number;

//https://leetcode.com/problems/missing-number/description/

class Solution {
    public static int missingNumber(int[] nums) {
        int n = nums.length;

        int result = n;
        for (int i = 0; i < n; ++i) {
            result = result ^ (i ^ nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));
    }
}
