package leetcode.medium.m_560_subarray_sum_equals_k;

//https://leetcode.com/problems/subarray-sum-equals-k/description/

import java.util.HashMap;
class Solution {
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int prefixSum = 0, count = 0;

        HashMap<Integer, Integer> hashMapPrefixSum = new HashMap<>();
        hashMapPrefixSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (hashMapPrefixSum.containsKey(prefixSum - k)) {
                count += hashMapPrefixSum.get(prefixSum - k);
            }
            hashMapPrefixSum.put(prefixSum, hashMapPrefixSum.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 3, 4};
        int k = 4;
        System.out.println(subarraySum(nums, k));
    }
}