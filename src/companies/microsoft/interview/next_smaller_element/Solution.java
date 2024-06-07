package companies.microsoft.interview.next_smaller_element;

//https://www.geeksforgeeks.org/next-smaller-element/

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    static int[] nextSmallerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                arr[i] = -1;
            } else {
                arr[i] = stack.pop();
                stack.push(arr[i]);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 25};
        //int[] arr = {11, 13, 21, 3};
        System.out.println(Arrays.toString(nextSmallerElement(arr)));
    }
}
