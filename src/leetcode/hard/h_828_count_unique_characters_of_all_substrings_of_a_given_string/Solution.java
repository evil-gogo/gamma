package leetcode.hard.h_828_count_unique_characters_of_all_substrings_of_a_given_string;

//https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/description/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int uniqueLetterString(String s) {
        List<Integer>[] indexList = new List[26];
        for (int i = 0; i < 26; i++) {
            indexList[i] = new ArrayList<>();
        }

        for (int i = 0; i < 26; ++i) {
            indexList[i].add(-1);
        }

        for (int i = 0; i < s.length(); i++) {
            indexList[s.charAt(i) - 'A'].add(i);
        }

        int count = 0;

        for (List<Integer> occurrences : indexList) {
            occurrences.add(s.length());

            for (int i = 1; i < occurrences.size() - 1; i++) {
                count += (occurrences.get(i) - occurrences.get(i - 1)) * (occurrences.get(i + 1) - occurrences.get(i));
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "ABC";
        System.out.println(uniqueLetterString(s));
    }
}
