package leetcode.p_735_asteroid_collision;

//https://leetcode.com/problems/asteroid-collision/description/

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0)  {
                    stack.push(asteroid);
                }

                if (stack.peek() == -asteroid) {
                    stack.pop();
                }
            }
        }

        int[] res = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i--;
        }

        return res;
    }

    public static void main(String[] args) {
        //int[] asteroids = {5, 10, -5};
        int[] asteroids = {10, 2, -5};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }
}