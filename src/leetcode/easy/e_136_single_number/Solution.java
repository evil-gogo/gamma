package leetcode.easy.e_136_single_number;

//https://leetcode.com/problems/single-number/description/

class Solution {
    public static int singleNumber(int[] nums) {
        int singleNumber = nums[0];
        for (int i = 1; i < nums.length; i++) {
            singleNumber = singleNumber ^ nums[i];
        }
        return singleNumber;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1};
        System.out.println(singleNumber(nums));
    }
}
