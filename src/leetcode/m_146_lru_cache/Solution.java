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
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return key == pair.key && value == pair.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(key) * 31 + Integer.hashCode(value);
    }

    @Override
    public String toString() {
        return key + " " + value;
    }
}

class LRUCache {
    int capacity;
    Deque<Pair> deque;
    HashMap<Integer, Pair> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        deque = new ArrayDeque<>();
        cache = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Pair pair = cache.get(key);
        deque.remove(pair);
        deque.addFirst(pair);
        return pair.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Pair pair = cache.get(key);

            deque.remove(pair);
            pair.value = value;
            deque.addFirst(pair);
        } else {
            Pair pair = new Pair(key, value);
            if (deque.size() == capacity) {
                Pair removedPair = deque.removeLast();
                cache.remove(removedPair.key);
            }
            cache.put(key, pair);
            deque.addFirst(pair);
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

