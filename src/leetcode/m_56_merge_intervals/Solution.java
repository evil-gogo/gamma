package leetcode.m_56_merge_intervals;

//https://leetcode.com/problems/merge-intervals/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> mergedIntervals = new ArrayList<>();

        mergedIntervals.add(intervals[0]);

        for (int i = 1; i < intervals.length; ++i) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            int[] lastMergedInterval = mergedIntervals.get(mergedIntervals.size() - 1);

            if (lastMergedInterval[1] < start) {
                mergedIntervals.add(intervals[i]);
            } else {
                lastMergedInterval[1] = Math.max(lastMergedInterval[1], end);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
