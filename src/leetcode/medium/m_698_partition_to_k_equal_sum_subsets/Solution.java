package leetcode.medium.m_698_partition_to_k_equal_sum_subsets;

//https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/

class Solution {
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        return solve(nums, k);
    }

    private static boolean solve(int[] nums, int k) {
        int totalSum = 0;
        for (int element : nums) {
            totalSum += element;
        }

        if (totalSum % k != 0) {
            return false;
        }

        int targetSubsetSum = totalSum / k;

        //int[] subsetSums = new int[k];
        //return solve1(nums, 0, subsetSums, targetSubsetSum);

        boolean[] visited = new boolean[nums.length];
        return solve2(nums, k, visited, 0, 0, targetSubsetSum);
    }

    private static boolean solve1(int[] nums, int currentIndex, int[] subsetSums, int targetSubsetSum) {
        if (currentIndex > nums.length - 1) {
            return true;
        }

        for (int i = 0; i < subsetSums.length; ++i) {
            if (subsetSums[i] + nums[currentIndex] > targetSubsetSum) {
                continue;
            }

            subsetSums[i] = subsetSums[i] + nums[currentIndex];
            if (solve1(nums, currentIndex + 1, subsetSums, targetSubsetSum)) {
                return true;
            }
            subsetSums[i] = subsetSums[i] - nums[currentIndex];

            if (subsetSums[i] == 0) {
                break;
            }
        }
        return false;
    }

    private static boolean solve2(int[] nums, int k, boolean[] visited, int currentIndex, int curSum, int targeSubsetSum) {
        if (k == 0) {
            return true;
        }

        if (curSum == targeSubsetSum) {
            return solve2(nums, k - 1, visited, 0, 0, targeSubsetSum);
        }

        for (int i = currentIndex; i < nums.length; i++) {
            if (visited[i] || curSum + nums[i] > targeSubsetSum) {
                continue;
            }
            visited[i] = true;
            if (solve2(nums, k, visited, i + 1, curSum + nums[i], targeSubsetSum)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        System.out.println(canPartitionKSubsets(nums, k));
    }
}
