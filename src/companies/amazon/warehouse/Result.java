package companies.amazon.warehouse;

import java.util.*;

public class Result {
    static boolean isCountZero = false;
    public static int suitableLocations(List<Integer> centers, long d) {
        Collections.sort(centers);

        int n = centers.size();

        long minX = Integer.MIN_VALUE;// = centers.get(0) - (int) d;
        long maxX = Integer.MAX_VALUE;// = centers.get(n - 1) + (int) d;

        for (int center : centers) {
            minX = Math.max(minX, center - d);
            maxX = Math.min(maxX, center + d);
        }

        int totalCount = 0;
        long leftIndex = (minX + maxX) / 2;
        long righIndex = leftIndex + 1;

        isCountZero = false;
        while (leftIndex >= minX && !isCountZero) {
            totalCount += getSuitableCountAtIndex(centers, leftIndex, d);
            leftIndex--;
        }

        isCountZero = false;
        while (righIndex <= maxX  && !isCountZero ) {
            totalCount += getSuitableCountAtIndex(centers, righIndex, d);
            righIndex++;
        }
//        for (long leftIndex = minX; leftIndex <= maxX; x++) {
//            totalCount += getSuitableCountAtIndex(centers, x, d);
//        }
//
//        for (long x = minX; x <= maxX; x++) {
//            totalCount += getSuitableCountAtIndex(centers, x, d);
//        }

        return totalCount;
    }

    public static int getSuitableCountAtIndex(List<Integer> centers, long x, long d) {
        int suitableCount = 0;
        long totalDistance = 0;

        for (int center : centers) {
            totalDistance += (2L * Math.abs(center - x));
        }

        if (totalDistance <= d) {
            suitableCount++;
        }
        if (suitableCount ==  0) {
            isCountZero = false;
        }
        return suitableCount;
    }

    public static void main(String[] args) {
        // Example test case based on your input
        List<Integer> centers = Arrays.asList(2, 0, 3, -4);
        long d = 22;
        System.out.println(suitableLocations(centers, d));  // Output should be 5 based on the problem description
    }

}




//package companies.amazon.warehouse;
//
//import java.util.*;
//
//public class Result {
//    public static int suitableLocations(List<Integer> centers, long d) {
//        Collections.sort(centers);
//
//        int n = centers.size();
//        int suitableCount = 0;
//
//        int minX = centers.get(0) - (int) d;
//        int maxX = centers.get(n - 1) + (int) d;
//
//        for (int x = minX; x <= maxX; x++) {
//            long totalDistance = 0;
//
//            for (int center : centers) {
//                totalDistance += (2L * Math.abs(center - x));
//            }
//
//            if (totalDistance <= d) {
//                suitableCount++;
//            }
//        }
//
//        return suitableCount;
//    }
//
//    public static void main(String[] args) {
//        // Example test case based on your input
//        List<Integer> centers = Arrays.asList(2, 0, 3, -4);
//        long d = 22;
//        System.out.println(suitableLocations(centers, d));  // Output should be 5 based on the problem description
//    }
//
//}
//
