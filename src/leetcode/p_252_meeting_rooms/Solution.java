package leetcode.p_252_meeting_rooms;

//https://leetcode.com/problems/meeting-rooms/description/

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public static boolean canAttendMeetings(int[][] intervals) {
        PriorityQueue<Integer> pqMeetingEndTime = new PriorityQueue<>(Collections.reverseOrder());

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] input1, int[] input2) {
                return input1[0] - input2[0];
            }
        });

        for (int[] interval : intervals) {
            int startTime = interval[0];
            int endTime = interval[1];
            if (!pqMeetingEndTime.isEmpty() && pqMeetingEndTime.peek() > startTime) {
                return false;
            }
            pqMeetingEndTime.add(endTime);
        }
        return true;
    }

    public static void main(String[] args) {
        //int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals = {{7, 10}, {2, 4}};
        System.out.println(canAttendMeetings(intervals));
    }
}
