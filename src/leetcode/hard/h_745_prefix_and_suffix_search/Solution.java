package leetcode.hard.h_745_prefix_and_suffix_search;

//https://leetcode.com/problems/prefix-and-suffix-search/description/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TrieNode {
    TrieNode[] children;
    List<Integer> indexes;

    public TrieNode() {
        children = new TrieNode[26];
        indexes = new ArrayList<>();
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word, int wordIndex) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (temp.children[index] == null) {
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
            temp.indexes.add(wordIndex);
        }
    }

    public List<Integer> search(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (temp.children[index] == null) {
                return Collections.emptyList();
            }
            temp = temp.children[index];
        }
        return temp.indexes;
    }
}

class WordFilter {
    Trie prefixTrie;
    Trie suffixTrie;

    public WordFilter(String[] words) {
        prefixTrie = new Trie();
        suffixTrie = new Trie();

        for (int i = 0; i < words.length; i++) {
            prefixTrie.insert(words[i], i);
            suffixTrie.insert(new StringBuilder(words[i]).reverse().toString(), i);
        }
    }

    public int f(String pref, String suff) {
        suff = new StringBuilder(suff).reverse().toString();
        List<Integer> prefixIndexes = prefixTrie.search(pref);
        List<Integer> suffixIndexes = suffixTrie.search(suff);

        if (prefixIndexes.isEmpty() || suffixIndexes.isEmpty()) {
            return -1;
        }
        int prefixItr = prefixIndexes.size() - 1;
        int suffixItr = suffixIndexes.size() - 1;
        while (prefixItr >= 0 && suffixItr >= 0) {
            int prefixIndex = prefixIndexes.get(prefixItr);
            int suffixIndex = suffixIndexes.get(suffixItr);
            if (prefixIndex == suffixIndex) {
                return prefixIndex;
            }
            if (prefixIndex > suffixIndex) {
                prefixItr--;
            } else {
                suffixItr--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] sequence = {"WordFilter", "f"};
        String[][] input = {{"apple"}, {"a", "e"}};

        WordFilter wordFilter = null;
        int inputIndex = 0;
        for (String s : sequence) {
            switch (s) {
                case "WordFilter":
                    wordFilter = new WordFilter(input[inputIndex]);
                    inputIndex++;
                    break;
                case "f":
                    assert wordFilter != null;
                    System.out.println(wordFilter.f(input[inputIndex][0], input[inputIndex][1]));
                    inputIndex++;
                    break;
            }
        }
    }
}


