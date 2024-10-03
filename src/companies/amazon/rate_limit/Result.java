package companies.amazon.rate_limit;

import java.util.*;

class Result {
    public static int getMinTime(int n, String requests, int minGap) {
        return getMinTime1(n, requests, minGap);
        //return getMinTime2(n, requests, minGap);
    }

    public static int getMinTime1(int n, String requests, int minGap) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char region : requests.toCharArray()) {
            frequencyMap.put(region, frequencyMap.getOrDefault(region, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : frequencyMap.values()) {
            maxHeap.add(freq);
        }

        int totalTime = 0;

        while (!maxHeap.isEmpty()) {
            List<Integer> waitingList = new ArrayList<>();
            int processed = 0;

            for (int i = 0; i < minGap + 1; i++) {
                if (!maxHeap.isEmpty()) {
                    int freq = maxHeap.poll();
                    processed++;
                    if (freq > 1) {
                        waitingList.add(freq - 1);
                    }
                }
            }

            for (int freq : waitingList) {
                maxHeap.add(freq);
            }

            totalTime += !maxHeap.isEmpty() ? minGap + 1 : processed;
        }

        return totalTime;
    }

    public static int getMinTime2(int n, String requests, int minGap) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char region : requests.toCharArray()) {
            frequencyMap.put(region, frequencyMap.getOrDefault(region, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(frequencyMap.values());

        int totalTime = 0;

        while (!maxHeap.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int cycles = Math.min(minGap + 1, maxHeap.size());
            int processedRequests = 0;

            for (int i = 0; i < cycles; i++) {
                if (!maxHeap.isEmpty()) {
                    int freq = maxHeap.poll();
                    if (freq > 1) {
                        tempList.add(freq - 1);
                    }
                    processedRequests++;
                }
            }

            for (int remaining : tempList) {
                maxHeap.offer(remaining);
            }

            if (!maxHeap.isEmpty()) {
                totalTime += minGap + 1;
            } else {
                totalTime += processedRequests;
            }
        }

        return totalTime;
    }

    public static void main(String[] args) {
        int n = 12;
        String requests = "abacadaeafag";
        int minGap = 2;
        System.out.println(getMinTime(n, requests, minGap));
    }
}