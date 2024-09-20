package leetcode.medium.m_435_non_overlapping_intervals;

//https://leetcode.com/problems/non-overlapping-intervals/description/

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int count = 0, currentEndCoordinate = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= currentEndCoordinate) {
                currentEndCoordinate = intervals[i][1];
            } else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][]intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
