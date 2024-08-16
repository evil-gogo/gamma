package leetcode.e_2185_counting_words_with_a_given_prefix;

//https://leetcode.com/problems/counting-words-with-a-given-prefix/description/

class TrieNode {
    TrieNode[] children;
    int count;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.count = 0;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void insert(String word, int prefixLength) {
        TrieNode temp = root;
        for (int i = 0; i < word.length() && i < prefixLength; i++) {
            int index = word.charAt(i) - 'a';
            if (temp.children[index] == null) {
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
            temp.count = temp.count + 1;
        }
    }

    public int search(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (temp.children[index] == null) {
                return 0;
            }
            temp = temp.children[index];
        }
        return temp.count;
    }
}

class Solution {
    public static int prefixCount(String[] words, String pref) {
        int prefixLength = pref.length();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word, prefixLength);
        }
        return trie.search(pref);
    }

    public static void main(String[] args) {
//        String[] words = {"pay","attention","practice","attend"};
//        String pref = "at";

        String[] words = {"leetcode", "win", "loops", "success"};
        String pref = "code";
        System.out.println(prefixCount(words, pref));
    }
}
