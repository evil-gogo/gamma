package leetcode.m_139_word_break;

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

            if (temp != null && temp.isEndOfWord && search(word.substring(i + 1))) {
                return true;
            }
        }
        return temp != null && temp.isEndOfWord;
    }
}

class Solution {
    public static boolean wordBreak(String s, List<String> wordDict) {
        //return wordBreak1(s, wordDict);
        return wordBreak2(s, wordDict);
    }

    public static boolean wordBreak1(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word : wordDict) {
            trie.insert(word);
        }
        return trie.search(s);
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return solve(s, wordDict, dp, 0);
    }

    private static boolean solve(String s, List<String> wordDict, Boolean[] dp, int currenIndex) {
        if (currenIndex == s.length()) {
            return true;
        }

        if (dp[currenIndex] != null) {
            return dp[currenIndex];
        }

        for (int endIndex = currenIndex + 1; endIndex <= s.length(); endIndex++) {
            String subStr = s.substring(currenIndex, endIndex);
            if (wordDict.contains(subStr) && solve(s, wordDict, dp, endIndex)) {
                return dp[currenIndex] = true;
            }
        }

        return dp[currenIndex] = false;
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
