package leetcode.h_895_maximum_frequency_stack;

//https://leetcode.com/problems/maximum-frequency-stack/description/

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class FreqStack {
    private HashMap<Integer, Integer> hashMapFreq;
    private PriorityQueue<int[]> priorityQueue; // val, index, freq
    int currentIndex = 0;

    public FreqStack() {
        hashMapFreq = new HashMap<>();
        priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int diff = o2[2] - o1[2];
                if (diff == 0) {
                    return o2[1] - o1[1];
                }
                return diff;
            }
        });
    }

    public void push(int val) {
        hashMapFreq.put(val, hashMapFreq.getOrDefault(val, 0) + 1);
        priorityQueue.add(new int[] {val, currentIndex, hashMapFreq.get(val)});
        currentIndex++;
    }

    public int pop() {
        int poppedValue = priorityQueue.poll()[0];

        if (hashMapFreq.get(poppedValue) == 1) {
            hashMapFreq.remove(poppedValue);
        } else {
            hashMapFreq.put(poppedValue, hashMapFreq.get(poppedValue) - 1);
        }
        return poppedValue;
    }
}
