package leetcode.p_152_maximum_product_subarray;

//https://leetcode.com/problems/maximum-product-subarray/description/

class Solution {
    public static int maxProduct(int[] nums) {
        return maxProduct1(nums);
        //return maxProduct2(nums);
    }

    public static int maxProduct1(int[] nums) {
        double prefix = 1, suffix = 1;
        double maxProduct = Integer.MIN_VALUE;

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
        return (int) maxProduct;
    }

    public static int maxProduct2(int[] nums) {
        double maxProductEndingHere = nums[0];
        double minProductEndingHere = nums[0];
        double maxProductSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            double tempMaxProductEndingHere = maxProductEndingHere * nums[i];
            double tempMinProductEndingHere = minProductEndingHere * nums[i];

            maxProductEndingHere = Math.max(nums[i], Math.max(tempMaxProductEndingHere, tempMinProductEndingHere));
            minProductEndingHere = Math.min(nums[i], Math.min(tempMaxProductEndingHere, tempMinProductEndingHere));

            //maxProductSoFar = Math.max(maxProductSoFar, maxProductEndingHere);
            maxProductSoFar = Math.max(maxProductSoFar, Math.max(minProductEndingHere, maxProductEndingHere));
        }
        return (int) maxProductSoFar;
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
