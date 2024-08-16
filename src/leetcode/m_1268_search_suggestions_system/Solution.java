package leetcode.m_1268_search_suggestions_system;

//https://leetcode.com/problems/search-suggestions-system/description/

import java.util.LinkedList;
import java.util.List;

class TrieNode {
    TrieNode[] children;
    String word;
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
        temp.word = word;
        temp.isEndOfWord = true;
    }

    public List<String> getWordsStartsWith(String prefix) {
        List<String> wordsStartWithPrefixList = new LinkedList<>();
        TrieNode temp = root;

        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (temp.children[index] == null) {
                return wordsStartWithPrefixList;
            }
            temp = temp.children[index];
        }
        dfsWithPrefixNode(temp, wordsStartWithPrefixList);
        return wordsStartWithPrefixList;
    }


    private void dfsWithPrefixNode(TrieNode node, List<String> wordsStartWithPrefixList) {
        if (node.isEndOfWord) {
            if (wordsStartWithPrefixList.size() < 3) {
                wordsStartWithPrefixList.add(node.word);
            }
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                dfsWithPrefixNode(node.children[i], wordsStartWithPrefixList);
            }
        }
    }
}

class Solution {
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }

        List<List<String>> suggestedProductsList = new LinkedList<>();

        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < searchWord.length(); i++) {
            prefix.append(searchWord.charAt(i));
            suggestedProductsList.add((trie.getWordsStartsWith(prefix.toString())));
        }
        return suggestedProductsList;
    }

    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mousepad";

        //String[] products = {"havana"};
        //String searchWord = "tatiana";
        System.out.println(suggestedProducts(products, searchWord));
    }
}