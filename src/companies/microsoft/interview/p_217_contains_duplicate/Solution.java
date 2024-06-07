package companies.microsoft.interview.p_217_contains_duplicate;

//https://leetcode.com/problems/contains-duplicate/description/

import java.util.HashSet;

class Solution {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                return true;
            }
            hashSet.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }
}
