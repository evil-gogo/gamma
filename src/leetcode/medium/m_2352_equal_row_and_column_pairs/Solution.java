package leetcode.medium.m_2352_equal_row_and_column_pairs;

//https://leetcode.com/problems/equal-row-and-column-pairs/description/

import java.util.HashMap;
import java.util.Objects;

class Key {
    String key;

    Key(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key1 = (Key) o;
        return key1.key.equals(String.valueOf(key));
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key);
    }

    @Override
    public String toString() {
        return key;
    }
}

class Solution {
    public static int equalPairs(int[][] grid) {
        HashMap<Key, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            StringBuilder key = new StringBuilder();

            for (int j = 0; j < grid[i].length; j++) {
                key.append(grid[i][j]);
                key.append("-");
            }
            Key rowKey = new Key(key.toString());
            hashMap.put(rowKey, hashMap.getOrDefault(rowKey, 0) + 1);
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                key.append(grid[j][i]);
                key.append("-");
            }
            Key colKey = new Key(key.toString());
            if (hashMap.containsKey(colKey)) {
                count += hashMap.get(colKey);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //int[][] grid = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        int[][] grid = {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
        System.out.println(equalPairs(grid));

        Key key1 = new Key("abc d");
        Key key2 = new Key("abc d");
        System.out.println(key1.equals(key2));
    }
}
