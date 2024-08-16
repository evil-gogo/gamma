package leetcode.h_84_largest_rectangle_in_histogram;

//https://leetcode.com/problems/largest-rectangle-in-histogram/description/

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public static int largestRectangleArea(int[] heights) {
        int[] prefix = new int[heights.length], suffix = new int[heights.length];
        int largestRectangleArea = Integer.MIN_VALUE;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                prefix[i] = 0;
            } else {
                if (heights[stack.peek()] < heights[i]) {
                    prefix[i] = stack.peek() + 1;
                }
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                suffix[i] = heights.length - 1;
            } else {
                if (heights[stack.peek()] < heights[i]) {
                    suffix[i] = stack.peek() - 1;
                }
            }
            stack.push(i);
        }

        System.out.println(Arrays.toString(prefix));
        for (int i = 0; i < prefix.length; i++) {
            System.out.print(heights[prefix[i]] + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(suffix));
        for (int i = 0; i < prefix.length; i++) {
            System.out.print(heights[suffix[i]] + " ");
        }
        System.out.println();
        for (int i = 0; i < heights.length; i++) {
            largestRectangleArea = Math.max(largestRectangleArea, heights[i] * (suffix[i] - prefix[i] + 1));
        }
        return largestRectangleArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        //int[] heights = {1,2,2};
        System.out.println(largestRectangleArea(heights));
    }
}
