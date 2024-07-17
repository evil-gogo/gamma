package leetcode.p_238_product_of_array_except_self;

//https://leetcode.com/problems/product-of-array-except-self/description/

import java.util.Arrays;

class Solution {
    public static int[] productExceptSelf(int[] nums) {
        return productExceptSelf1(nums, nums.length);
        //return productExceptSelf2(nums, nums.length);
    }

    private static int[] productExceptSelf1(int[] nums, int length) {
        int[] prefix = new int[length];
        int[] suffix = new int[length];

        int currentProduct = 1;
        prefix[0] = 1;

        for (int i = 1; i < length; i++) {
            prefix[i] = currentProduct * nums[i - 1];
            currentProduct = prefix[i];
        }

        currentProduct = 1;
        suffix[length - 1] = 1;

        for (int i = length - 1 - 1; i >= 0; i--) {
            suffix[i] = currentProduct * nums[i + 1];
            currentProduct = suffix[i];
        }

        for (int i = 0; i < length; i++) {
            nums[i] = prefix[i] * suffix[i];
        }
        return nums;
    }

    private static int[] productExceptSelf2(int[] nums, int length) {
        int[] output = new int[length];

        int currentProduct = 1;
        output[0] = 1;

        for (int i = 1; i < length; i++) {
            output[i] = currentProduct * nums[i - 1];
            currentProduct = output[i];
        }

        currentProduct = 1;

        for (int i = length - 1 - 1; i >= 0; i--) {
            currentProduct = currentProduct * nums[i + 1];
            output[i] = currentProduct * output[i];
        }

        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}