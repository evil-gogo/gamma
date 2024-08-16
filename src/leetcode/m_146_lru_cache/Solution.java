package leetcode.m_146_lru_cache;

//https://leetcode.com/problems/lru-cache/description/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

class Pair {
    int key, value;

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair pair = (Pair) o;
        return (this.key == pair.key && this.value == pair.value);
    }

    @Override
    public int hashCode() {
        return this.key * 31 + this.value;
    }

    @Override
    public String toString() {
        return key + " " + value;
    }
}

class LRUCache {
    int capacity;
    Deque<Pair> deque;
    HashMap<Integer, Pair> hashMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        deque = new ArrayDeque<>();
        hashMap = new HashMap<>();
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            Pair pair = hashMap.get(key);
            deque.remove(pair);
            deque.addFirst(pair);
            return pair.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            Pair pair = hashMap.get(key);

            deque.remove(pair);
            pair.value = value;
            deque.addFirst(pair);
        } else {
            Pair pair = new Pair(key, value);

            if (deque.size() == capacity) {
                Pair removedPair = deque.removeLast();
                hashMap.remove(removedPair.key);
            }
            deque.addFirst(pair);
            hashMap.put(key, pair);
        }
    }

    public static void main(String[] args) {
        String[] sequence = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
        int[][] input = {{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}};

        LRUCache lruCache = null;
        int inputIndex = 0;
        for (String s : sequence) {
            switch (s) {
                case "LRUCache":
                    lruCache = new LRUCache(input[inputIndex][inputIndex]);
                    inputIndex++;
                    break;
                case "put":
                    assert lruCache != null;
                    lruCache.put(input[inputIndex][0], input[inputIndex][1]);
                    inputIndex++;
                    break;
                case "get":
                    assert lruCache != null;
                    System.out.println(lruCache.get(input[inputIndex][0]));
                    inputIndex++;
                    break;

            }
        }
    }
}

