package leetcode.h_1032_stream_of_characters;

//https://leetcode.com/problems/stream-of-characters/description/

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
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
        for (int i = word.length() - 1; i >= 0; i--) {
            int index = word.charAt(i) - 'a';
            if (temp.children[index] == null) {
                return false;
            }
            temp = temp.children[index];
            if (temp.isEndOfWord) {
                return true;
            }
        }
        return temp != null && temp.isEndOfWord;
    }
}

class StreamChecker {
    Trie trie;
    StringBuilder prevInputQueries;

    public StreamChecker(String[] words) {
        trie = new Trie();
        prevInputQueries = new StringBuilder();
        for (String word : words) {
            trie.insert(new StringBuilder(word).reverse().toString());
        }
    }

    public boolean query(char letter) {
        prevInputQueries.append(letter);
        return trie.search(prevInputQueries.toString());
    }

    public static void main(String[] args) {
        String[] sequence = {"StreamChecker", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query"};
        char[][] input = {{}, {'a'}, {'b'}, {'c'}, {'d'}, {'e'}, {'f'}, {'g'}, {'h'}, {'i'}, {'j'}, {'k'}, {'l'}};
        String[] words = {"cd", "f", "kl"};

        StreamChecker streamChecker = null;
        int inputIndex = 0;
        for (String s : sequence) {
            switch (s) {
                case "StreamChecker":
                    streamChecker = new StreamChecker(words);
                    inputIndex++;
                    break;
                case "query":
                    assert streamChecker != null;
                    System.out.println(streamChecker.query(input[inputIndex][0]));
                    inputIndex++;
                    break;
            }
        }
    }
}
