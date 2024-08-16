package leetcode.e_349_intersection_of_two_arrays;

//https://leetcode.com/problems/intersection-of-two-arrays/description/

import java.util.*;

class Solution {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> union = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        for (int num : nums1) {
            union.add(num);
        }

        for (int num : nums2) {
            if (union.contains(num)) {
                intersection.add(num);
            }
        }
        int[] res = new int[intersection.size()];
        int index = 0;
        for (int num : intersection) {
            res[index++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        int[] result = intersection(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
