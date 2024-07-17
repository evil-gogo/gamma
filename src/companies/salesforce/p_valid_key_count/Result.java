package companies.salesforce.p_valid_key_count;

import java.util.ArrayList;
import java.util.List;

class Result {

    /*
     * Complete the 'getValidKeyCount' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts LONG_INTEGER_ARRAY keys as parameter.
     */

    public static List<Integer> getValidKeyCount(List<Long> keys) {
        List<Integer> countResult = new ArrayList<>();
        boolean[] dp = new boolean[100001];

        for (Long key : keys) {
            List<Long> list = new ArrayList<>();
            findValidNumbers(key, list, dp);
            countResult.add(list.size());
        }
        return countResult;
    }

    private static void findValidNumbers(long num, List<Long> list, boolean[] dp) {
        for (int i = 2; (long) i * i <= num; i++) {
            if (dp[i]) {
                list.add(((long) i * i));
            } else {
                if (isPrimeNumber(i)) {
                    list.add(((long) i * i));
                    dp[i] = true;
                }
            }
        }
    }

    private static boolean isPrimeNumber(long num) {
        for (int i = 2; (long) i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int N = 122;
        //numbersWith3Divisors(N);

        List<Long> keys = List.of(Long.valueOf(122));
        System.out.println(getValidKeyCount(keys));
    }
}
