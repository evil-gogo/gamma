package companies.microsoft.online_assesment.maximum_length_of_a_concatenated_string_with_unique_characters;

//https://algo.monster/problems/max_length_of_a_concatenated_string_with_unique_characters

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static int maxLength(List<String> arr) {
        Map<String, Integer> memo = new HashMap<>();
        return solve(0, arr, "", memo);
    }

    private static int solve(int currentIndex, List<String> arr, String tempStr, Map<String, Integer> memo) {
        if (currentIndex >= arr.size()) {
            return tempStr.length();
        }

        String key = tempStr + currentIndex;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int include = 0, exclude = 0;
        if (!hasCommonChar(arr.get(currentIndex), tempStr)) {
            tempStr += arr.get(currentIndex);
            include = solve(currentIndex + 1, arr, tempStr, memo);
            tempStr = tempStr.substring(0, tempStr.length() - arr.get(currentIndex).length());
        }
        exclude = solve(currentIndex + 1, arr, tempStr, memo);

        int result = Math.max(include, exclude);
        memo.put(key, result);
        return result;
    }

    private static boolean hasCommonChar(String str1, String str2) {
        int[] freq = new int[26];

        for (char c : str1.toCharArray()) {
            if (freq[c - 'a'] > 0) {
                return true;
            } else {
                freq[c - 'a']++;
            }
        }

        for (char c : str2.toCharArray()) {
            if (freq[c - 'a'] > 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        //String[] arr = {"un", "iq", "ue"};
        String[] arr = {"cha","r","act","ers"};
        System.out.println(maxLength(List.of(arr)));
    }
}
