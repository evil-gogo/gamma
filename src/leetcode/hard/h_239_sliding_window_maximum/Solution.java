package leetcode.hard.h_239_sliding_window_maximum;

//https://leetcode.com/problems/sliding-window-maximum/description/

import java.util.*;

class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int numsLength = nums.length;
        int[] result = new int[numsLength - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < numsLength; i++) {
            System.out.println("i - k + 1 " + (i - k + 1));
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            System.out.println("FIRST " + deque);
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            System.out.println("SECOND " + deque);

            deque.offer(i);
            System.out.println("THIRD " + deque);


            if (i >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
            System.out.println(Arrays.toString(result));
            System.out.println();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
