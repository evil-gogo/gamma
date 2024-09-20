package leetcode.medium.m_208_implement_trie_prefix_tree;

//https://leetcode.com/problems/implement-trie-prefix-tree/description/

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
        return (temp != null && temp.isEndOfWord);
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (temp.children[index] == null) {
                return false;
            }
            temp = temp.children[index];
        }
        return (temp != null);
    }

    public void printTrie() {
        char[] str = new char[26];
        int level = 0;
        printTrieUtil(root, str, level);
    }

    private void printTrieUtil(TrieNode node, char[] str, int level) {
        if (node.isEndOfWord) {
            str[level] = '\0';
            System.out.println(str);
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                str[level] = (char) (i + 'a');
                printTrieUtil(node.children[i], str, level + 1);
            }
        }
    }
}

class Solution {
    public static void main(String[] args) {
        String[] sequence = {"Trie", "insert", "search", "search", "startsWith", "insert", "search"};
        String[][] input = {{}, {"apple"}, {"apple"}, {"app"}, {"app"}, {"app"}, {"app"}};

        Trie trie = null;

        int inputIndex = 0;
        for (String s : sequence) {
            switch (s) {
                case "Trie":
                    trie = new Trie();
                    inputIndex++;
                    break;
                case "insert":
                    assert trie != null;
                    trie.insert(input[inputIndex][0]);
                    inputIndex++;
                    break;
                case "search":
                    assert trie != null;
                    System.out.println(trie.search(input[inputIndex][0]));
                    inputIndex++;
                    break;
                case "startsWith":
                    assert trie != null;
                    System.out.println(trie.startsWith(input[inputIndex][0]));
                    inputIndex++;
                    break;
            }
        }
        trie.printTrie();
    }
}
