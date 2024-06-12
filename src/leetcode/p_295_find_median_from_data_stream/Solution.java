package leetcode.p_295_find_median_from_data_stream;

//https://leetcode.com/problems/find-median-from-data-stream/description/

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        //System.out.println("addNum: " + num);
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
        //System.out.println(minHeap);
        //System.out.println(maxHeap);
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }

    public static void main(String[] args) {
        String[] sequence = {"MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"};
        int[][] input = {{}, {1}, {2}, {}, {3}, {}};
        MedianFinder medianFinder = null;
        int inputIndex = 0;
        for (String s : sequence) {
            switch (s) {
                case "MedianFinder":
                    medianFinder = new MedianFinder();
                    inputIndex++;
                    break;
                case "addNum":
                    assert medianFinder != null;
                    medianFinder.addNum(Integer.parseInt(String.valueOf(input[inputIndex][0])));
                    inputIndex++;
                    break;
                case "findMedian":
                    assert medianFinder != null;
                    medianFinder.findMedian();
                    inputIndex++;
                    break;
            }
        }
    }
}
