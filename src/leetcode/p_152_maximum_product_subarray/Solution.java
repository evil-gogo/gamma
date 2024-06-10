package leetcode.p_152_maximum_product_subarray;

class Solution {
    public static int maxProduct(int[] nums) {
        //return maxProduct1(nums); // fails for 1 TC, Crossing int limit
        return maxProduct2(nums);
    }

    public static int maxProduct1(int[] nums) {
        int prefix = 1, suffix = 1;
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length - 1 - i];
            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }
        return maxProduct;
    }

    public static int maxProduct2(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            int currentMax = maxProduct;
            int currentMin = minProduct;

            maxProduct = Math.max(nums[i], Math.max(currentMax * nums[i], currentMin * nums[i]));
            minProduct = Math.min(nums[i], Math.min(currentMax * nums[i], currentMin * nums[i]));

            answer = Math.max(answer, maxProduct);
        }
        return answer;
    }

    public static void main(String[] args) {
        //int[] nums = {2, 3, -2, 4};
        //int[] nums = {0, 2};
        //int[] nums = {-2, 3, -4};
        int[] nums = {0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0};
        System.out.println(maxProduct(nums));
        int x = 1000000000;
       // int y = 10000000000;
    }
}
