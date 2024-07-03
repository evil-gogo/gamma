package leetcode.p_1200_minimum_absolute_difference;

//https://leetcode.com/problems/minimum-absolute-difference/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;

        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; ++i) {
            minDifference = Math.min(minDifference, arr[i + 1] - arr[i]);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n - 1; ++i) {
            if (arr[i + 1] - arr[i] == minDifference) {
                result.add(List.of(arr[i], arr[i + 1]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3,8,-10,23,19,-4,-14,27};
        System.out.println(minimumAbsDifference(arr));
    }
}
