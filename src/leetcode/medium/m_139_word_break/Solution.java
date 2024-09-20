package leetcode.medium.m_139_word_break;

//https://leetcode.com/problems/word-break/description/

import java.util.List;

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (temp.children[index] == null) {
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
        }
        temp.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode temp = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (temp.children[index] == null) {
                return false;
            }
            temp = temp.children[index];
        }
        return temp != null && temp.isEndOfWord;
    }
}

class Solution {
    public static boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak1(s, wordDict);
        //return wordBreak2(s, wordDict);
    }

    public static boolean wordBreak1(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word : wordDict) {
            trie.insert(word);
        }
        Boolean[] dp = new Boolean[s.length()];
        return solve1(s, trie, 0, dp);
    }

    private static boolean solve1(String s, Trie trie, int startIndex, Boolean[] dp) {
        if (startIndex == s.length()) {
            return true;
        }

        if (dp[startIndex] != null) {
            return dp[startIndex];
        }

        for (int endIndex = startIndex + 1; endIndex <= s.length(); endIndex++) {
            String subStr = s.substring(startIndex, endIndex);
            if (trie.search(subStr) && solve1(s, trie, endIndex, dp)) {
                return dp[startIndex] = true;
            }
        }

        return dp[startIndex] = false;
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return solve2(s, wordDict, 0, dp);
    }

    private static boolean solve2(String s, List<String> wordDict, int startIndex, Boolean[] dp) {
        if (startIndex == s.length()) {
            return true;
        }

        if (dp[startIndex] != null) {
            return dp[startIndex];
        }

        for (int endIndex = startIndex + 1; endIndex <= s.length(); endIndex++) {
            String subStr = s.substring(startIndex, endIndex);
            if (wordDict.contains(subStr) && solve2(s, wordDict, endIndex, dp)) {
                return dp[startIndex] = true;
            }
        }

        return dp[startIndex] = false;
    }

    public static void main(String[] args) {
//        String s = "leetcode";
//        String[] wordDict = {"leet","code"};

//        String s = "applepenapple";
//        String[] wordDict = {"apple","pen"};

        String s = "catsandog";
        String[] wordDict = {"cats", "dog", "sand", "and", "cat"};

//        String s = "aaaaaaa";
//        String[] wordDict =
//                {"aaaa", "aaa"};
        System.out.println(wordBreak(s, List.of(wordDict)));
    }
}
