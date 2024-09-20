package leetcode.hard.h_85_maximal_rectangle;

//https://leetcode.com/problems/maximal-rectangle/description/

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public static int maximalRectangle(char[][] matrix) {
        int numColumns = matrix[0].length;
        int[] heights = new int[numColumns];
        int maxArea = 0;

        for (char[] row : matrix) {
            for (int j = 0; j < numColumns; ++j) {
                heights[j] = row[j] == '1' ? heights[j] + 1 : 0;
            }
            System.out.println(Arrays.toString(heights));
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    private static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] right = nextSmallerElementRightSide(heights);
        int[] left = nextSmallerElementLeftSide(heights);
        int[] width = new int[n];
        for (int i = 0; i < n; i++)
            width[i] = right[i] - left[i] - 1;
        int max_area = 0;

        for (int i = 0; i < n; i++) {
            int a = width[i] * heights[i];
            if (max_area < a)
                max_area = a;
        }
        return max_area;
    }

    private static int[] nextSmallerElementLeftSide(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (stack.empty()) {
                left[i] = -1;
            } else {
                while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                if (stack.empty()) {
                    left[i] = -1;
                } else {
                    left[i] = stack.peek();
                }
            }
            stack.push(i);
        }
        return left;
    }

    private static int[] nextSmallerElementRightSide(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (stack.empty()) {
                right[i] = n;
            } else {
                while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                if (stack.empty()) {
                    right[i] = n;
                } else {
                    right[i] = stack.peek();
                }
            }
            stack.push(i);
        }
        return right;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0' }, {'1', '0', '1', '1', '1' }, {'1', '1', '1', '1', '1' }, {'1', '0', '0', '1', '0' }};
        System.out.println(maximalRectangle(matrix));
    }
}
