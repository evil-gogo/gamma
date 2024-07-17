package companies.visa;

import java.util.HashSet;

class Pair {
    int i, j;

    Pair (int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair pair = (Pair) o;
        return (this.i == pair.i && this.j == pair.j);
    }

    @Override
    public int hashCode() {
        return this.i * 31 + this.j;
    }

    @Override
    public String toString() {
        return i + " " + j;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEndOfWord = false;
    }
}

class Trie {
    HashSet<Pair> hashSetPair;
    long count;

    TrieNode root;

    Trie() {
        root = new TrieNode();
        count = 0;
        hashSetPair = new HashSet<>();
    }

    public void insert(String word) {
        TrieNode temp = root;
        boolean isSuffixExist = true;
        for (int i = word.length() - 1; i >= 0; i--) {
            int index = word.charAt(i) - 'a';
            if (temp.children[index] == null) {
                temp.children[index] = new TrieNode();
                isSuffixExist = false;
            } else {
                if (i == 0) {
                    count++;
                }
            }
            temp = temp.children[index];
            if (isSuffixExist && temp.isEndOfWord) {
                count++;
            }
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

        return temp != null;
    }
}

class Solution {
    public long solution(String[] words) {
        HashSet<Pair> resultHashSet = new HashSet<>();
        Trie trie = new Trie();;
        for (int i = 0; i < words.length; i++) {
            //trie = new Trie();
            trie.insert(words[i]);
//            for (int j = 0; j < words.length; j++) {
//                System.out.println("Word input " + words[i] + " Word Search " + words[j] + " " + trie.search(words[j]));
//                if (i != j) {
//                    if (trie.search(words[j])) {
//                        if (i < j) {
//                            trie.hashSetPair.add(new Pair(i, j));
//                        } else {
//                            trie.hashSetPair.add(new Pair(j, i));
//                        }
//
//                    }
//                }
//            }
//            System.out.println(trie.hashSetPair);
//            resultHashSet.addAll(trie.hashSetPair);
        }
        System.out.println("Final Result  " + trie.count);
        return resultHashSet.size();
    }

    public static void main(String[] args) {
        //String[] words = {"cba", "a", "a", "a", "a", "b", "ba", "ca"};
        //String[] words = {"back", "backdoor", "cba", "ba", "or", "door"};
        String[] words = {"dcba", "cba", "a", "a", "a", "a", "b", "ba", "ba", "ca", "a", "a", "a", "a", "b", "ba", "ba", "ca"};
        //String[] words = {"cba", "a", "a", "ba"};
        //String[] words = {"cba", "a", "a", "a", "a", "b", "ba", "ba", "ca", "a", "a", "a", "a", "b", "ba", "ba", "ca"};
        System.out.println(new Solution().solution(words));
    }
}



