package leetcode.m_1405_longest_happy_string;

//https://leetcode.com/problems/longest-happy-string/

import java.util.PriorityQueue;

class Pair {
    Character character;
    int frequency;

    public Pair(char c, int frequency) {
        this.character = c;
        this.frequency = frequency;
    }
}

class Solution {
    public static String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((pair1, pair2) -> pair2.frequency - pair1.frequency);

        if (a > 0) {
            priorityQueue.offer(new Pair('a', a));
        }
        if (b > 0) {
            priorityQueue.offer(new Pair('b', b));
        }
        if (c > 0) {
            priorityQueue.offer(new Pair('c', c));
        }

        StringBuilder result = new StringBuilder();

        while (!priorityQueue.isEmpty()) {
            Pair currentPair = priorityQueue.poll();
            int length = result.length();
            if (length >= 2 && result.charAt(length - 1) == currentPair.character && result.charAt(length - 2) == currentPair.character) {
                if (priorityQueue.isEmpty()) {
                    break;
                }
                Pair nextPair = priorityQueue.poll();
                result.append(nextPair.character);
                if (nextPair.frequency > 1) {
                    nextPair.frequency--;
                    priorityQueue.offer(nextPair);
                }
                priorityQueue.offer(currentPair);
            } else {
                result.append(currentPair.character);
                if (currentPair.frequency > 1) {
                    currentPair.frequency--;
                    priorityQueue.offer(currentPair);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int a = 1, b = 1, c = 7;
        System.out.println(longestDiverseString(a, b, c));
    }
}
