package leetcode.p_215_kth_largest_element_in_an_array;

//https://leetcode.com/problems/kth-largest-element-in-an-array/description/

import java.util.PriorityQueue;

class Solution {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (minPriorityQueue.size() == k) {
                if (nums[i] > minPriorityQueue.peek()) {
                    minPriorityQueue.poll();
                    minPriorityQueue.offer(nums[i]);
                }
            } else {
                minPriorityQueue.offer(nums[i]);
            }
        }
        return minPriorityQueue.peek();
    }

    public static void main(String[] args) {
        //int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
}
