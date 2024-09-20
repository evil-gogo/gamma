package leetcode.hard.h_642_design_search_autocomplete_system;

//https://leetcode.com/problems/design-search-autocomplete-system/description/

import java.util.*;

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    String sentence;
    int frequency;

    public TrieNode() {
        this.children = new TrieNode[27];
        this.isEndOfWord = false;
        this.frequency = 0;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String str, int frequency) {
        TrieNode temp = root;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) == ' ' ? 26 : str.charAt(i) - 'a';
            if (temp.children[index] == null) {
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
        }
        temp.isEndOfWord = true;
        temp.frequency += frequency;
        temp.sentence = str;
    }

    public TrieNode searchPrefixNode(String str) {
        TrieNode temp = root;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) == ' ' ? 26 : str.charAt(i) - 'a';
            if (temp.children[index] == null) {
                return null;
            }
            temp = temp.children[index];
        }
        return temp;
    }

    public List<String> search(String str) {
        TrieNode prefixNode = searchPrefixNode(str);
        List<String> result = new ArrayList<>();
        if (prefixNode == null) {
            return result;
        }

        PriorityQueue<TrieNode> minHeap = new PriorityQueue<>(new Comparator<TrieNode>() {
            @Override
            public int compare(TrieNode n1, TrieNode n2) {
                int diff = n1.frequency - n2.frequency;
                if (diff == 0) {
                    return n2.sentence.compareTo(n1.sentence);
                }
                return diff;
            }
        });

        searchAutoCompleteResult(prefixNode, minHeap);

        while (!minHeap.isEmpty()) {
            result.add(0, minHeap.poll().sentence);
        }

        return result;
    }

    public void searchAutoCompleteResult(TrieNode node, PriorityQueue<TrieNode> minHeap) {
        if (node == null) {
            return;
        }
        if (node.isEndOfWord) {
            minHeap.add(node);
            if (minHeap.size() > 3) {
                minHeap.poll();
            }
        }
        for (int i = 0; i < 27; i++) {
            if (node.children[i] != null) {
                searchAutoCompleteResult(node.children[i], minHeap);
            }
        }
    }
}

class AutocompleteSystem {
    Trie trie;
    StringBuilder inputString;

    public AutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        inputString = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            trie.insert(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        List<String> result = new ArrayList<>();
        if (c == '#') {
            trie.insert(inputString.toString(), 1);
            inputString = new StringBuilder();
        } else {
            inputString.append(c);
            result = trie.search(inputString.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        String[] sentences = {"i love you", "island", "iroman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};

        String[] sequence = {"AutocompleteSystem", "input", "input", "input", "input"};
        char[][] input = {{}, {'i'}, {' '}, {'a'}, {'#'}};

        AutocompleteSystem autocompleteSystem = null;
        int inputIndex = 0;
        for (String s : sequence) {
            switch (s) {
                case "AutocompleteSystem":
                    autocompleteSystem = new AutocompleteSystem(sentences, times);
                    inputIndex++;
                    break;
                case "input":
                    assert autocompleteSystem != null;
                    System.out.println(autocompleteSystem.input(input[inputIndex][0]));
                    inputIndex++;
                    break;
            }
        }
    }
}

