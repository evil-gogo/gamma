package leetcode.p_53_maximum_subarray;

//https://leetcode.com/problems/maximum-subarray/description/

class Solution {
    public static int maxSubArray(int[] nums) {
        int maxEndingHere = 0, maxSoFar = Integer.MIN_VALUE;
        for (int num : nums) {
            maxEndingHere = maxEndingHere + num;
            if (maxEndingHere < num) {
                maxEndingHere = num;
            }
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
