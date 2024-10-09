package companies.jp_morgan.maximize_cpu;

import java.util.Arrays;
import java.util.List;

class Solution {
    public static int maximizeCPU(List<Integer> requirements, int processingCapacity) {
        return solve(requirements, processingCapacity, 0, 0);
    }

    private static int solve(List<Integer> requirements, int processingCapacity, int currentIndex, int currentCapacity) {
        if (currentIndex > requirements.size() - 1) {
            return currentCapacity;
        }
        int take = Integer.MIN_VALUE;
        if (currentCapacity + requirements.get(currentIndex) <= processingCapacity) {
            take = solve(requirements, processingCapacity, currentIndex + 1, currentCapacity + requirements.get(currentIndex));
        }
        int not_take = solve(requirements, processingCapacity, currentIndex + 1, currentCapacity);

        return Math.max(take, not_take);
    }

    public static void main(String[] args) {
        Integer[] input = {15, 12, 3, 7, 8};
        int processingCapacity = 18;
//        Integer[] input = {2, 9, 7};
//        int processingCapacity = 15;
        System.out.println(maximizeCPU(Arrays.asList(input), processingCapacity));
    }

}