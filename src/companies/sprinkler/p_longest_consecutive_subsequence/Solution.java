package companies.sprinkler.p_longest_consecutive_subsequence;

//https://www.geeksforgeeks.org/maximum-consecutive-numbers-present-array/

import java.util.*;

class Solution {
    public static int findLongestConsecutiveSubsequence(int[] arr, int n) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            hashSet.add(arr[i]);
        }

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            if (hashSet.contains(arr[i])) {
                int num = arr[i];
                while (hashSet.contains(num)) {
                    num++;
                }

                maxLength = Math.max(maxLength, num - arr[i]);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1, 94, 93, 1000, 5, 92, 78};
        int n = arr.length;
        System.out.println(findLongestConsecutiveSubsequence(arr, n));
    }
}