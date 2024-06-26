package companies.microsoft.interview.p_239_sliding_window_maximum;

//https://leetcode.com/problems/sliding-window-maximum/description/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int numsLength = nums.length;
        int[] result = new int[numsLength - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < numsLength; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
