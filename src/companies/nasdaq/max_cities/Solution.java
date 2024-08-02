package companies.nasdaq.max_cities;

import java.util.*;

class Pair {
    String city;
    int distance;

    Pair(String city, int distance) {
        this.city = city;
        this.distance = distance;
    }
}

class Solution {
    public static int maxCities(String[] cities, int[] distances) {
        Pair[] pairs = new Pair[cities.length];
        for (int i = 0; i < cities.length; i++) {
            pairs[i] = new Pair(cities[i], distances[i]);
        }

        Arrays.sort(pairs, Comparator.comparing(pair -> pair.city));

        int[] sortedDistances = new int[cities.length];
        for (int i = 0; i < pairs.length; i++) {
            sortedDistances[i] = pairs[i].distance;
        }

        return findLISLength(sortedDistances);
    }

    public static int findLISLength(int[] distances) {
        if (distances == null || distances.length == 0) {
            return 0;
        }

        int[] lis = new int[distances.length];
        Arrays.fill(lis, 1);
        int maxLength = 1;

        for (int i = 1; i < distances.length; i++) {
            for (int j = 0; j < i; j++) {
                if (distances[i] > distances[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    if (maxLength < lis[i]) {
                        maxLength = lis[i];
                    }
                }
            }
        }
        return maxLength;
    }

    public static void main(String args[]) {
        String[] cities = {"Tucson", "Albany", "Smith", "Westford", "Berkeley" };
        int[] distances = {102, 95, 114, 1421, 50};
        System.out.println(maxCities(cities, distances));
    }
}