package companies.microsoft.online_assesment.minimum_number_of_relocations;

import java.util.*;

class Solution {
    public static int findMinimumNumberOfRelocations(int[] arr) {
        int numMoves = 0, prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            TreeMap<Integer, List<Integer>> treeMapNegativeIndex = getNegativeIndexMap(arr, arr.length - numMoves);
            if (prefixSum < 0) {
                for (Map.Entry<Integer, List<Integer>> entry : treeMapNegativeIndex.entrySet()) {
                    List<Integer> negativeIntegerList = (List<Integer>) entry.getValue();
                    for (int negativeIntegerIndex = 0; negativeIntegerIndex < negativeIntegerList.size(); negativeIntegerIndex++) {
                        int index = negativeIntegerList.get(negativeIntegerIndex);
                        if (index <= i) {
                            for (int j = index; j < arr.length - 1; j++) {
                                arr[j] = arr[j + 1];
                            }
                            arr[arr.length - 1] = arr[index];
                            prefixSum = prefixSum - arr[index];
                            numMoves += 1;
                            if (!isSumLessThanZero(arr)) {
                                return numMoves;
                            }
                            i = index - 1;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return numMoves;
    }

    private static TreeMap<Integer, List<Integer>> getNegativeIndexMap(int[] arr, int size) {
        TreeMap<Integer, List<Integer>> treeMapNegativeIndex = new TreeMap<>();

        for (int i = 0; i < size; i++) {
            if (arr[i] < 0) {
                if (treeMapNegativeIndex.get(arr[i]) == null) {
                    treeMapNegativeIndex.put(arr[i], new ArrayList<>());
                }
                treeMapNegativeIndex.get(arr[i]).add(i);
            }
        }
        return treeMapNegativeIndex;
    }

    private static boolean isSumLessThanZero(int[] arr) {
        int prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (prefixSum < 0) {
                return true;
            }
        }
        return false;
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
