package companies.microsoft.interview.p_127_word_ladder;

//https://leetcode.com/problems/word-ladder/description/

import java.util.*;

class Solution {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.addAll(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int ladderLength = 0;

        while (!queue.isEmpty()) {
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
                            return ladderLength + 1;
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

        return 0;
    }

    public static void main(String[] args) {
        //String beginWord = "hit", endWord = "cog";
        //String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        String beginWord = "hot", endWord = "dog";
        String[] wordList = {"hot","dog"};
        System.out.println(ladderLength(beginWord, endWord, List.of(wordList)));
    }
}
