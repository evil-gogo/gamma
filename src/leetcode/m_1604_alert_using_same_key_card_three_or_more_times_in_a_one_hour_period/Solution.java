package leetcode.m_1604_alert_using_same_key_card_three_or_more_times_in_a_one_hour_period;

//https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/description/

import java.util.*;

class Solution {
    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> nameToTimesMap = new HashMap<>();

        for (int i = 0; i < keyName.length; ++i) {
            String name = keyName[i];
            String time = keyTime[i];
            int totalMinutes
                    = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
            nameToTimesMap.computeIfAbsent(name, k -> new ArrayList<>()).add(totalMinutes);
        }

        List<String> alerts = new ArrayList<>();

        for (Map.Entry<String, List<Integer>> entry : nameToTimesMap.entrySet()) {
            List<Integer> times = entry.getValue();
            int n = times.size();
            if (n > 2) {
                Collections.sort(times);
                for (int i = 0; i < n - 2; ++i) {
                    if (times.get(i + 2) - times.get(i) <= 60) {
                        alerts.add(entry.getKey());
                        break;
                    }
                }
            }
        }

        Collections.sort(alerts);
        return alerts;
    }

    public static void main(String[] args) {
        String[] keyName = {"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"}, keyTime = {"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};
        System.out.println(alertNames(keyName, keyTime));
    }
}
