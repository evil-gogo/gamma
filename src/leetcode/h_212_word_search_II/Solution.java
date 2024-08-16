package leetcode.h_212_word_search_II;

//https://leetcode.com/problems/word-search-ii/description/

import java.util.ArrayList;
import java.util.List;

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    int referenceWordIndex;

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

    public void insert(String word, int referenceWordIndex) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (temp.children[index] == null) {
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
        }
        temp.isEndOfWord = true;
        temp.referenceWordIndex = referenceWordIndex;
    }
}

class Solution {
    public static List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i], i);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, words, i, j, trie.root, result);
            }
        }
        return result;
    }

    private static void dfs(char[][] board, String[] words, int i, int j, TrieNode trieNode, List<String> result) {
        int charIndex = board[i][j] - 'a';

        if (trieNode.children[charIndex] == null) {
            return;
        }

        trieNode = trieNode.children[charIndex];

        if (trieNode.isEndOfWord && trieNode.referenceWordIndex != -1) {
            result.add(words[trieNode.referenceWordIndex]);
            trieNode.referenceWordIndex = -1;
        }

        char tempChar = board[i][j];
        int[] directions = {-1, 0, 1, 0, -1};

        board[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            int newRow = i + directions[k];
            int newCol = j + directions[k + 1];
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length && board[newRow][newCol] != '#') {
                dfs(board, words, newRow, newCol, trieNode, result);
            }
        }
        board[i][j] = tempChar;
    }

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(findWords(board, words));
    }
}
