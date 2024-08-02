package leetcode.p_253_meeting_rooms_II;

//https://leetcode.com/problems/meeting-rooms-ii/description/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public static int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> pqMeetingEndTime = new PriorityQueue<Integer>();

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] input1, int[] input2) {
                return input1[0] - input2[0];
            }
        });

        int minMeetingRooms = 0;
        for (int[] interval : intervals) {
            int startTime = interval[0];
            int endTime = interval[1];
            while (!pqMeetingEndTime.isEmpty() && pqMeetingEndTime.peek() <= startTime) {
                pqMeetingEndTime.remove();
            }
            pqMeetingEndTime.add(endTime);
            if (pqMeetingEndTime.size() > minMeetingRooms) {
                minMeetingRooms = pqMeetingEndTime.size();
            }
        }
        return minMeetingRooms;
    }

    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(minMeetingRooms(intervals));
    }
}
