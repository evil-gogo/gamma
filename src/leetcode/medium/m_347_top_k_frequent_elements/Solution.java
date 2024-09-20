package leetcode.medium.m_347_top_k_frequent_elements;

//https://leetcode.com/problems/top-k-frequent-elements/description/

import java.util.*;

class Pair {
    int number;
    int frequency;

    public Pair(int number, int frequency) {
        this.number = number;
        this.frequency = frequency;
    }
}

class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int number : nums) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        PriorityQueue<Pair> maxPair = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.frequency - o1.frequency;
            }
        });

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            maxPair.add(new Pair(entry.getKey(), entry.getValue()));
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxPair.poll().number;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
