package leetcode.p_219_contains_duplicate_II;

//https://leetcode.com/problems/contains-duplicate-ii/description/

import java.util.HashMap;

class Solution {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            int lastIndex = hashMap.getOrDefault(nums[currentIndex], -1000000);

            if (currentIndex - lastIndex <= k) {
                return true;
            }
            hashMap.put(nums[currentIndex], currentIndex);
        }
        return false;
    }

    public static void main(String[] args) {
        //int[] nums = {1, 2, 3, 1};
        int[] nums = {1, 1, 1, 1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
