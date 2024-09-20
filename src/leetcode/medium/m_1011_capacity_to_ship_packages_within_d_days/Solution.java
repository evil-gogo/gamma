package leetcode.medium.m_1011_capacity_to_ship_packages_within_d_days;

//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

class Solution {
    public static int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0, totalWeight = 0;
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }
        int leftIndex = maxWeight, rightIndex = totalWeight;
        while (leftIndex < rightIndex) {
            int midCapacity = (leftIndex + rightIndex) >> 1;
            if (canShip(weights, midCapacity, days)) {
                rightIndex = midCapacity;
            } else {
                leftIndex = midCapacity + 1;
            }
        }

        return leftIndex;
    }

    private static boolean canShip(int[] weights, int capacity, int days) {
        int currentLoad = 0;
        int dayCount = 1;

        for (int weight : weights) {
            currentLoad += weight;
            if (currentLoad > capacity) {
                currentLoad = weight;
                dayCount++;
            }
        }
        return dayCount <= days;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }
}