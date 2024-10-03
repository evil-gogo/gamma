package companies.salesforce.perfect_pair_count;

import java.util.ArrayList;
import java.util.List;

public class Result {
    public static long getPerfectPairsCount(List<Integer> arr) {
        int size = arr.size();
        long count = 0;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (isValidatePair(arr.get(i), arr.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isValidatePair(Integer x, Integer y) {
        int absDifference = Math.abs(x - y);
        int absSum = Math.abs(x + y);

        boolean condition1, condition2 = false;

        condition1 = (Math.min(absDifference, absSum) <= Math.min(Math.abs(x), Math.abs(y)));
        if (condition1) {
            condition2 = (Math.max(absDifference, absSum) >= Math.max(Math.abs(x), Math.abs(y)));
        }
        return condition1 && condition2;
    }

    public static void main(String[] args) {
        Integer[] arr = {-9, 6, -2, 1};
        System.out.println(getPerfectPairsCount(List.of(arr)));
    }
}
//
//package companies.salesforce.perfect_pair_count;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Result {
//    public static long getPerfectPairsCount(List<Integer> arr) {
//        int size = arr.size();
//        long count = 0;
//
//        List<String> success = new ArrayList<>();
//        List<String> failure = new ArrayList<>();
//
//        for (int i = 0; i < size; i++) {
//            for (int j = i + 1; j < size; j++) {
//                if (isValidatePair(arr.get(i), arr.get(j))) {
//                    success.add(arr.get(i) + " " + arr.get(j));
//                    count++;
//                } else {
//                    failure.add(arr.get(i) + " " + arr.get(j));
//                }
//            }
//        }
//        System.out.println(success);
//        System.out.println(failure);
//        return count;
//    }
//
//    private static boolean isValidatePair(Integer x, Integer y) {
//        int absDifference = Math.abs(x - y);
//        int absSum = Math.abs(x + y);
//
//        boolean condition1, condition2;
//
//        condition1 = (Math.min(absDifference, absSum) <= Math.min(Math.abs(x), Math.abs(y)));
//        condition2 = (Math.max(absDifference, absSum) >= Math.max(Math.abs(x), Math.abs(y)));
//
//        return condition1 && condition2;
//    }
//
//    public static void main(String[] args) {
//        Integer[] arr = {-9, 6, -2, 1};
//        System.out.println(getPerfectPairsCount(List.of(arr)));
//    }
//}