package leetcode.p_1010_pairs_of_songs_with_total_durations_divisible_by_60;

//https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/description/

import java.util.HashMap;

class Solution {
    public static int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        for (int i = 0; i < time.length; i++) {
            if (time[i] >= 60) {
                time[i] %= 60;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            if (time[i] == 0 && map.containsKey(time[i])) {
                count += map.get(time[i]);
            }
            if (map.containsKey(60 - time[i])) {
                count += map.get(60 - time[i]);
            }
            map.put(time[i], map.getOrDefault(time[i], 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] time = {30, 20, 150, 100, 40};
        System.out.println(numPairsDivisibleBy60(time));
    }
}
