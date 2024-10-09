package companies.jp_morgan.wind_farms;

import java.util.*;

class Solution {
    public static int windFarms(List<Integer> premium, List<Integer> x, List<Integer> y) {
        //return windFarms1(premium, x, y);
        return windFarms2(premium, x, y);
    }

    public static int windFarms1(List<Integer> premium, List<Integer> x, List<Integer> y) {
        List<Integer> controlCenter;
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        for (Integer integer : x) {
            if (integer < minX) {
                minX = integer;
            }
            if (integer > maxX) {
                maxX = integer;
            }
        }
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        for (Integer integer : y) {
            if (integer < minY) {
                minY = integer;
            }
            if (integer > maxY) {
                maxY = integer;
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                controlCenter = new ArrayList<>();
                controlCenter.add(i);
                controlCenter.add(j);
                int cost = 0;
                for (int k = 0; k < x.size(); k++) {
                    cost = cost + calculateCost(premium, x, y, controlCenter, k);

                }
                if (cost < answer) {
                    answer = cost;
                }
            }
        }

        return answer;
    }

    private static int calculateCost(List<Integer> premium, List<Integer> x, List<Integer> y, List<Integer> controlCenter, int currentIndex) {
        int distance = (Math.abs(x.get(currentIndex) - controlCenter.get(0))) + (Math.abs(y.get(currentIndex) - controlCenter.get(1)));
        return premium.get(currentIndex) * distance;
    }

    public static int windFarms2(List<Integer> premium, List<Integer> x, List<Integer> y) {
        int optimalX = binarySearch(premium, x, y, true);
        int optimalY = binarySearch(premium, x, y, false);

        return calculateTotalCost(premium, x, y, optimalX, optimalY);
    }

    private static int binarySearch(List<Integer> premium, List<Integer> x, List<Integer> y, boolean isX) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        List<Integer> coordinate = isX ? x : y;
        for (int val : coordinate) {
            low = Math.min(low, val);
            high = Math.max(high, val);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            int costMid = calculateTotalCost(premium, x, y, isX ? mid : null, isX ? null : mid);
            int costMidNext = calculateTotalCost(premium, x, y, isX ? mid + 1 : null, isX ? null : mid + 1);

            if (costMidNext < costMid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private static int calculateTotalCost(List<Integer> premium, List<Integer> x, List<Integer> y, Integer optimalX, Integer optimalY) {
        int totalCost = 0;
        for (int i = 0; i < x.size(); i++) {
            int distanceX = optimalX != null ? Math.abs(x.get(i) - optimalX) : 0;
            int distanceY = optimalY != null ? Math.abs(y.get(i) - optimalY) : 0;
            totalCost += premium.get(i) * (distanceX + distanceY);
        }
        return totalCost;
    }

    public static void main(String[] args) {
        Integer[] premium = {1, 3, 2, 4};

        Integer[] inputX = {1, 3, 2, 4};
        Integer[] inputY = {1, 2, 3, 4};

//        Integer[] premium = {1, 1, 1};
//
//        Integer[] inputX = {2, 3, 5};
//        Integer[] inputY = {1, 1, 1};
        System.out.println(windFarms(Arrays.asList(premium), Arrays.asList(inputX), Arrays.asList(inputY)));
    }
}
