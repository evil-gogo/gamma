package leetcode.p_88_merge_sorted_array;

import java.util.Arrays;

class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0, index2 = 0, indexR = n;
        while (index1 < m && index2 < n && indexR < m) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                nums1[indexR] = nums1[index1];
                indexR++;
                nums1[index1] = nums2[index2];
                index1++;
                index2++;
            }
        }
        index1++;
        while (index2 < m) {
            nums1[index1++] = nums2[index2++];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
