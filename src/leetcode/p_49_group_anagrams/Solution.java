package leetcode.p_49_group_anagrams;

//https://leetcode.com/problems/group-anagrams/description/

import java.util.*;

class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            String sortedStr = String.valueOf(charArray);

            anagramsMap.computeIfAbsent(sortedStr, key -> new ArrayList<>()).add(str);
        }

        return anagramsMap.values().stream().toList();
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
