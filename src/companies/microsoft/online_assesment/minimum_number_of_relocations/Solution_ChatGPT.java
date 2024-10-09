package companies.microsoft.online_assesment.minimum_number_of_relocations;

import java.util.PriorityQueue;

class Solution_ChatGPT {
    public static int findMinimumNumberOfRelocations(int[] A) {
        PriorityQueue<Integer> maxHeapNegativeExpenses = new PriorityQueue<>((a, b) -> a - b);
        int minimumRelocations = 0;
        long prefixSum = 0;

        for (int number : A) {
            prefixSum += number;

            if (number < 0) {
                maxHeapNegativeExpenses.offer(number);
            }

            while (prefixSum < 0 && !maxHeapNegativeExpenses.isEmpty()) {
                int largestNegativeExpense = maxHeapNegativeExpenses.poll();
                prefixSum -= largestNegativeExpense;
                minimumRelocations++;
            }
        }

        return minimumRelocations;
    }

    public static void main(String[] args) {
        int[] arr = {10, -10, -1, -1, 10, 0, -1};
        System.out.println(findMinimumNumberOfRelocations(arr));

        arr = new int[]{-1, -1, -1, 1, 1, 1, 1};
        System.out.println(findMinimumNumberOfRelocations(arr));

        arr = new int[]{5, -2, -3, 1};
        System.out.println(findMinimumNumberOfRelocations(arr));
    }
}
