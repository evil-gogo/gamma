package leetcode.medium.m_211_design_add_and_search_words_data_structure;

//https://leetcode.com/problems/design-add-and-search-words-data-structure/description/

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

    public boolean search(String word, TrieNode temp) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (int j = 0; j < 26; j++) {
                    assert temp != null;
                    if (temp.children[j] != null && search(word.substring(i + 1), temp.children[j])) {
                        return true;
                    }
                }
                return false;
            } else {
                int index = word.charAt(i) - 'a';
                if (temp.children[index] == null) {
                    return false;
                }
                temp = temp.children[index];
            }
        }
        return temp != null && temp.isEndOfWord;
    }
}

class WordDictionary {
    Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        return trie.search(word, trie.root);
    }
}

class Solution {
    public static void main(String[] args) {
        //String[] sequence = {"WordDictionary", "addWord", "addWord", "addWord", "search", "search", "search", "search"};
        //String[][] input = {{}, {"bad"}, {"dad"}, {"mad"}, {"pad"}, {"bad"}, {".ad"}, {"b.."}};

        String[] sequence = {"WordDictionary", "addWord", "addWord", "addWord", "addWord", "search", "search", "addWord", "search", "search", "search", "search", "search", "search"};
        String[][] input = {{}, {"at"}, {"and"}, {"an"}, {"add"}, {"a"}, {".at"}, {"bat"}, {".at"}, {"an."}, {"a.d."}, {"b."}, {"a.d"}, {"."}};

        WordDictionary wordDictionary = null;
        int inputIndex = 0;
        for (String s : sequence) {
            switch (s) {
                case "WordDictionary":
                    wordDictionary = new WordDictionary();
                    inputIndex++;
                    break;
                case "addWord":
                    assert wordDictionary != null;
                    wordDictionary.addWord(input[inputIndex][0]);
                    inputIndex++;
                    break;
                case "search":
                    assert wordDictionary != null;
                    wordDictionary.search(input[inputIndex][0]);
                    inputIndex++;
                    break;
            }
        }
    }
}
