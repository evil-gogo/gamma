package leetcode.hard.h_2488_count_subarrays_with_median_k;

//https://leetcode.com/problems/count-subarrays-with-median-k/description/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int countSubarrays(int[] nums, int k) {
        int indexK = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                indexK = i;
                nums[i] = 0;
            } else {
                if (nums[i] < k) {
                    nums[i] = -1;
                } else {
                    nums[i] = 1;
                }
            }
        }
        System.out.println("kthIndex " + indexK);
        System.out.println("nums " + Arrays.toString(nums));
        int[] prefixSum = new int[nums.length + 1];

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < prefixSum.length; i++) {
            System.out.print(prefixSum[i] + " ");
        }
        System.out.print("Boom");

        // 3. calculate three range: total [0, n - 1]  - left[0, idxK - 1] - right[idxK + 1];
        int left = helper(0, indexK, prefixSum);
        int right = helper(indexK + 1, nums.length, prefixSum);
        int total = helper(0, nums.length, prefixSum);

        return total - left - right;
    }

    private static int helper(int l, int r, int[] prefixSum) {
        Map<Integer, Integer> counter = new HashMap<>();

        int ans = 0;
        for (int i = l; i <= r; i++) {
            int currSum = prefixSum[i];

            if (counter.containsKey(currSum)) {
                ans += counter.get(currSum);
            }

            if (counter.containsKey(currSum - 1)) {
                ans += counter.get(currSum - 1);
            }

            counter.put(currSum, counter.getOrDefault(currSum, 0) + 1);
        }

        System.out.println(counter);

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 4, 5};
        int k = 4;
        System.out.println(countSubarrays(nums, k));
    }
}
