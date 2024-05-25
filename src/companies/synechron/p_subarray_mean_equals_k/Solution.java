package companies.synechron.p_subarray_mean_equals_k;

import java.util.HashMap;

class Solution {
    public static int subarrayMean(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - k;
        }

        k = 0;

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
        if (count > 1000000000) {
            return 1000000000;
        } else {
            return count;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 3, 4};
        int k = 4;
        System.out.println(subarrayMean(nums, k));
    }
}