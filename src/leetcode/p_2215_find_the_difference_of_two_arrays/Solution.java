package leetcode.p_2215_find_the_difference_of_two_arrays;

//https://leetcode.com/problems/find-the-difference-of-two-arrays/description/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> list = new ArrayList<>();

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }

        for (int num : nums2) {
            set1.remove(num);
        }
        for (int num : nums1) {
            set2.remove(num);
        }

        list.add(new ArrayList<>(set1));
        list.add(new ArrayList<>(set2));
        return list;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3}, nums2 = {2, 4, 6};
        System.out.println(findDifference(nums1, nums2));
    }
}