package leetcode.medium.m_681_next_closest_time;

//https://leetcode.com/problems/next-closest-time/description/

import java.util.HashSet;
import java.util.Set;

class Solution {
    private  int originalTotalMinutes;
    private  int minDifference;
    private  String answer;
    private  Set<Character> validDigits;

    public  String nextClosestTime(String time) {
        originalTotalMinutes = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
        minDifference = Integer.MAX_VALUE;
        validDigits = new HashSet<>();

        char minDigit = '9';
        for (char c : time.toCharArray()) {
            if (c != ':') {
                validDigits.add(c);
                if (c < minDigit) {
                    minDigit = c;
                }
            }
        }
        answer = null;
        deepFirstSearch("");
        if (answer == null) {
            answer = "" + minDigit + minDigit + ":" + minDigit + minDigit;
        }
        return answer;
    }

    private  void deepFirstSearch(String current) {
        if (current.length() == 4) {
            if (!isValidTime(current)) {
                return;
            }
            int potentialTimeMinutes = Integer.parseInt(current.substring(0, 2)) * 60 + Integer.parseInt(current.substring(2));
            if (potentialTimeMinutes > originalTotalMinutes && potentialTimeMinutes - originalTotalMinutes < minDifference) {
                minDifference = potentialTimeMinutes - originalTotalMinutes;
                answer = current.substring(0, 2) + ":" + current.substring(2);
            }
            return;
        }
        for (char c : validDigits) {
            deepFirstSearch(current + c);
        }
    }

    private  boolean isValidTime(String timeStr) {
        int hour = Integer.parseInt(timeStr.substring(0, 2));
        int minute = Integer.parseInt(timeStr.substring(2));
        return 0 <= hour && hour < 24 && 0 <= minute && minute < 60;
    }

    public  void main(String[] args) {
        String time = "19:34";
        System.out.println(nextClosestTime(time));
    }
}
