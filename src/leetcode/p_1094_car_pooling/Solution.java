package leetcode.p_1094_car_pooling;

//https://leetcode.com/problems/car-pooling/description/

class Solution {
    public static boolean carPooling(int[][] trips, int capacity) {
        int[] passengersAtLengthOfTrip = new int[1001];

        for (int[] trip : trips) {
            int numberOfPassengers = trip[0];
            int startLocation = trip[1];
            int endLocation = trip[2];

            passengersAtLengthOfTrip[startLocation] += numberOfPassengers;
            passengersAtLengthOfTrip[endLocation] -= numberOfPassengers;
        }

        int carLoad = 0;

        for (int passengers : passengersAtLengthOfTrip) {
            carLoad += passengers;
            if (carLoad > capacity) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
//        int capacity = 4;
//        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
//        int capacity = 5;
        int[][] trips = {{2, 2, 6}, {2, 4, 7}, {8, 6, 7}};
        int capacity = 11;
        System.out.println(carPooling(trips, capacity));
    }
}
