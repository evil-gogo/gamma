package leetcode.p_155_min_stack;

//https://leetcode.com/problems/min-stack/description/

import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minValuesStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minValuesStack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minValuesStack.isEmpty()) {
            minValuesStack.push(val);
        } else {
            minValuesStack.push(Math.min(minValuesStack.peek(), val));
        }
    }

    public void pop() {
        stack.pop();
        minValuesStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValuesStack.peek();
    }
}

class Solution {
    public static void main(String[] args) {
        String[] sequence = {"MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"};
        int[][] input = {{}, {-2}, {0}, {-3}, {}, {}, {}, {}};
        MinStack minStack = null;
        int inputIndex = 0;
        for (String s : sequence) {
            switch (s) {
                case "MinStack":
                    minStack = new MinStack();
                    inputIndex++;
                    break;
                case "push":
                    assert minStack != null;
                    minStack.push(input[inputIndex][0]);
                    inputIndex++;
                    break;
                case "getMin":
                    assert minStack != null;
                    minStack.getMin();
                    inputIndex++;
                    break;
                case "pop":
                    assert minStack != null;
                    minStack.pop();
                    inputIndex++;
                    break;
            }
        }
    }
}
