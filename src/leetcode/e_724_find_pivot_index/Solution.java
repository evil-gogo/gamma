package leetcode.e_724_find_pivot_index;

//https://leetcode.com/problems/find-pivot-index/description/

class Solution {
    public static int pivotIndex(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (0 == nums[nums.length - 1] - nums[i]) {
                    return i;
                }
            } else {
                if (nums[i - 1] == nums[nums.length - 1] - nums[i]) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //int[] nums = {1,7,3,6,5,6};
        //int[] nums = {2,1,-1};
        //int[] nums = {1,2,3};
        int[] nums = {-1, -1, 0, 1, 1, 0};
        System.out.println(pivotIndex(nums));
    }
}
