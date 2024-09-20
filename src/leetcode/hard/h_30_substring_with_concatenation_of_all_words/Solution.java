package leetcode.hard.h_30_substring_with_concatenation_of_all_words;

//https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> frequencies = new HashMap<>();
        for (String word : words) {
            frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
        }

        int inputStringLength = s.length();
        int numberOfWords = words.length;
        int wordSize = words[0].length();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < wordSize; i++) {
            Map<String, Integer> currentFrequencies = new HashMap<>();
            int leftIndex = i, rightIndex = i, totalWords = 0;

            while (rightIndex + wordSize <= inputStringLength) {
                String currentWord = s.substring(rightIndex, rightIndex + wordSize);
                rightIndex += wordSize;

                if (!frequencies.containsKey(currentWord)) {
                    currentFrequencies.clear();
                    leftIndex = rightIndex;
                    totalWords = 0;
                    continue;
                }

                currentFrequencies.put(currentWord, currentFrequencies.getOrDefault(currentWord, 0) + 1);
                totalWords++;

                while (currentFrequencies.get(currentWord) > frequencies.get(currentWord)) {
                    String leftWord = s.substring(leftIndex, leftIndex + wordSize);
                    currentFrequencies.put(leftWord, currentFrequencies.get(leftWord) - 1);
                    leftIndex += wordSize;
                    totalWords--;
                }

                if (totalWords == numberOfWords) {
                    result.add(leftIndex);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(findSubstring(s, words));
    }
}