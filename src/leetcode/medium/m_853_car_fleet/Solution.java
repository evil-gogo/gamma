package leetcode.medium.m_853_car_fleet;

//https://leetcode.com/problems/car-fleet/description/

import java.util.Arrays;

class Solution {
    public static int carFleet(int target, int[] position, int[] speed) {
        int carCount = position.length;

        Integer[] indices = new Integer[carCount];

        for (int i = 0; i < carCount; ++i) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> position[b] - position[a]);

        int fleetCount = 0;
        double previousTime = 0;

        for (int index : indices) {
            double timeToReach = 1.0 * (target - position[index]) / speed[index];

            if (timeToReach > previousTime) {
                fleetCount++;
                previousTime = timeToReach;
            }
        }
        return fleetCount;
    }

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3}, speed = {2, 4, 1, 1, 3};
        System.out.println(carFleet(target, position, speed));
    }
}
