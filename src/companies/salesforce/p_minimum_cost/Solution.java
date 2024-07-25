package companies.salesforce.p_minimum_cost;

import java.util.List;

class Solution {
    public static long getMinimumCost(List<Integer> arr) {
        int index = 0, maxDiff = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (Math.abs(arr.get(i + 1) - arr.get(i)) > maxDiff) {
                maxDiff = Math.abs(arr.get(i + 1) - arr.get(i));
                index = i;
            }
        }
        int mid = (arr.get(index) + arr.get(index + 1)) / 2;

        long minCost = 0;
        minCost += (long) (Math.pow(arr.get(index) - mid, 2) + Math.pow(arr.get(index + 1) - mid, 2));

        for (int i = 0; i < arr.size() - 1; i++) {
            if (i == index) {
                continue;
            }
            minCost += (long) Math.pow(arr.get(i) - arr.get(i + 1), 2);
        }

        return minCost;
    }

    public static void main(String[] args) {
        //Integer[] arr = {1, 3, 5, 2, 10};
        //Integer[] arr = {4, 7, 1, 4};
        Integer[] arr = {4, 7, 7};
        System.out.println(getMinimumCost(List.of(arr)));
    }
}
