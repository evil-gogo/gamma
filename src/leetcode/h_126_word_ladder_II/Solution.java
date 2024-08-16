package leetcode.h_126_word_ladder_II;

//https://leetcode.com/problems/word-ladder-ii/description/

import java.util.*;

class Solution {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        HashSet<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return result;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int minLadderLength = Integer.MAX_VALUE;
        int ladderLength = 0;

        while (!queue.isEmpty()) {
            ladderLength = 1;
            ladderLength++;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String word = queue.poll();
                System.out.println(word);
                assert word != null;
                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    for (char replacedChar = 'a'; replacedChar <= 'z'; replacedChar++) {
                        char temp = chars[j];
                        chars[j] = replacedChar;
                        String newWord = new String(chars);
                        if (newWord.equals(word)) {
                            continue;
                        }
                        if (newWord.equals(endWord)) {
                            ladderLength = ladderLength + 1;
                            if (ladderLength < minLadderLength) {
                                minLadderLength = ladderLength;
                            }
                        }
                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }
                        chars[j] = temp;
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(findLadders(beginWord, endWord, Arrays.asList(wordList)));
    }
}
