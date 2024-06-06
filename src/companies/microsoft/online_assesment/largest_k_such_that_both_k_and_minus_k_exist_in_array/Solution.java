package companies.microsoft.online_assesment.largest_k_such_that_both_k_and_minus_k_exist_in_array;

//https://algo.monster/problems/largest_k_positive_and_negative

import java.util.HashSet;

public class Solution {
    public static int largestK(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int curMax = 0;
        for (int k : arr) {
            if (set.contains(-k)) {
                curMax = Math.max(curMax, Math.abs(k));
            } else {
                set.add(k);
            }
        }
        return curMax;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, -2, 5, -3};
        System.out.println(largestK(arr));
    }
}
