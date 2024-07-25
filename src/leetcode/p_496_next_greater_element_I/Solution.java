package leetcode.p_496_next_greater_element_I;

//https://leetcode.com/problems/next-greater-element-i/description/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterElementMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nextGreaterElementMap.put(nums2[i], -1);
                stack.push(nums2[i]);
            } else {
                nextGreaterElementMap.put(nums2[i], stack.peek());
                stack.push(nums2[i]);
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nextGreaterElementMap.get(nums1[i]);
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
}
