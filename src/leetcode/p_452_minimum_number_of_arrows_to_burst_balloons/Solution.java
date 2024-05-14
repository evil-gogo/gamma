package leetcode.p_452_minimum_number_of_arrows_to_burst_balloons;

//https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int count = 1, currentMinEndCoordinate = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > currentMinEndCoordinate) {
                currentMinEndCoordinate = points[i][1];
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        //int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        System.out.println(findMinArrowShots(points));
    }
}
