package companies.microsoft.interview.p_4_median_of_two_sorted_arrays;

//https://leetcode.com/problems/median-of-two-sorted-arrays/description/

class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int leftIndex = 0, rightIndex = m;
        while (leftIndex <= rightIndex) {
            int midIndex1 = leftIndex + (rightIndex - leftIndex) / 2;
            int midIndex2 = (m + n + 1) / 2 - midIndex1;

            int x = (midIndex1 == 0) ? Integer.MIN_VALUE : nums1[midIndex1 - 1];
            int y = (midIndex1 == m) ? Integer.MAX_VALUE : nums1[midIndex1];

            int p = (midIndex2 == 0) ? Integer.MIN_VALUE : nums2[midIndex2 - 1];
            int q = (midIndex2 == n) ? Integer.MAX_VALUE : nums2[midIndex2];

            if (x <= q && p <= y) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(x, p) + Math.min(y, q)) / 2.0;
                } else {
                    return Math.max(x, p);
                }
            } else if (x > q) {
                rightIndex = midIndex1 - 1;
            } else {
                leftIndex = midIndex1 + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2}, nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}