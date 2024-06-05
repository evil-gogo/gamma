package companies.microsoft.online_assesment.day_of_the_week_that_is_k_days_later;

//https://algo.monster/problems/day_of_week

import java.util.List;

class Solution {
    public static String dayOfTheWeek(String day, int k) {
        List<String> days = List.of("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
        int index = days.indexOf(day);
        return days.get((index + k) % 7);
    }

    public static void main(String[] args) {
        String day = "Monday";
        int k = 3;
        System.out.println(dayOfTheWeek(day, k));
    }
}
