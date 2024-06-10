package companies.microsoft.interview.p_26_remove_duplicates_from_sorted_array;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

class Solution {
    public static int removeDuplicates(int[] nums) {
        int uniqueCount = 0;
        for (int currentNum : nums) {
            if (uniqueCount == 0 || currentNum != nums[uniqueCount - 1]) {
                nums[uniqueCount++] = currentNum;
            }
        }
        return uniqueCount;
    }

    public static void main(String[] args) {
        //int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }
}
