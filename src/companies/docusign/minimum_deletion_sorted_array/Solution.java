package companies.docusign.minimum_deletion_sorted_array;

import java.util.Arrays;

class Solution {
    public static int minimumNumberOfDeletions(int[] nums) {
        //return nums.length - lengthLIS(nums);
        return nums.length - findLCS(nums);
    }

    private static int findLCS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] numsSorted = Arrays.stream(nums).sorted().toArray();
        System.out.println(Arrays.toString(numsSorted));

        int[][] dp = new int[nums.length + 1][nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= nums.length; j++) {
                if (nums[i - 1] == numsSorted[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums.length][nums.length];
    }


    private static int lengthLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);

        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    if (maxLength < lis[i]) {
                        maxLength = lis[i];
                    }
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {30, 40, 2, 5, 1, 7, 45, 50, 8};
        System.out.println(minimumNumberOfDeletions(nums));
    }
}
