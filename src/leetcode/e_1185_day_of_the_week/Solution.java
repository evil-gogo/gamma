package leetcode.e_1185_day_of_the_week;

//https://leetcode.com/problems/day-of-the-week/description/

import java.util.Calendar;
import java.util.List;

class Solution {
    public static String dayOfTheWeek(int day, int month, int year) {
        List<String> days = List.of("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return days.get(dayOfWeek);
    }

    public static void main(String[] args) {
        int day = 31, month = 8, year = 2019;
        System.out.println(dayOfTheWeek(day, month, year));
    }
}
