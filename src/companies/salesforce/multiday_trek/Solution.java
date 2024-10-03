package companies.salesforce.multiday_trek;

import java.util.*;

class Solution {
    public static int efficientTrek(List<Integer> trails, int record) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (Integer trail : trails) {
            if (trail > max) {
                max = trail;
            }
            sum += trail;
        }

        int left = max, right = sum;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canComplete(trails, record, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canComplete(List<Integer> trails, int n, int maxSum) {
        int daysCount = 1;
        int currentSum = 0;

        for (int length : trails) {
            if (currentSum + length > maxSum) {
                daysCount++;
                currentSum = length;
                if (daysCount > n) {
                    return false;
                }
            } else {
                currentSum += length;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        //Integer[] trails = {10, 5, 9, 3, 8, 15};
        //int n = 2;

//        Integer[] trails = {150, 200, 400, 350, 250};
//        int n = 5;

        Integer[] trails = {78, 45, 12, 56, 85, 45};
        int n = 6;

        int minMaxSum = efficientTrek(List.of(trails), n);

        System.out.println("The minimum possible maximum sum of trail lengths per day is: " + minMaxSum);
    }
}
