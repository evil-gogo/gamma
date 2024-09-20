package leetcode.easy.e_1207_unique_number_of_occurrences;

//https://leetcode.com/problems/unique-number-of-occurrences/description/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int number : arr) {
            countMap.put(number, countMap.getOrDefault(number, 0) + 1);
        }

        Set<Integer> occurrenceSet = new HashSet<>(countMap.values());

        return occurrenceSet.size() == countMap.size();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(arr));
    }
}
