package companies.anakin;

import java.util.HashMap;
import java.util.Map;

public class SolutionChatGPT {
    private static Map<Integer, Long> factorialMemo = new HashMap<>();

    public static long findSimilar(String a, String b) {
        a = removeLeadingZeroes(a);
        b = removeLeadingZeroes(b);

        int[] freqA = new int[10];
        for (int i = 0; i < a.length(); i++) {
            freqA[a.charAt(i) - '0']++;
        }

        int[] freqB = new int[10];
        for (int i = 0; i < b.length(); i++) {
            freqB[b.charAt(i) - '0']++;
        }

        if (areFrequenciesEqual(freqA, freqB)) {
            return countDistinctPermutations(freqA, a.length());
        } else {
            return countDistinctPermutations(freqB, b.length());
        }
    }

    private static boolean areFrequenciesEqual(int[] freqA, int[] freqB) {
        for (int i = 0; i < 10; i++) {
            if (freqA[i] != freqB[i]) {
                return false;
            }
        }
        return true;
    }

    private static long countDistinctPermutations(int[] freq, int n) {
        long totalPermutations = factorial(n);
        long denominator = 1;

        for (int count : freq) {
            if (count > 1) {
                denominator *= factorial(count);
            }
        }

        long validPermutations = totalPermutations / denominator;

        if (freq[0] > 0) {
            int[] freqWithoutLeadingZero = freq.clone();
            freqWithoutLeadingZero[0]--;
            long invalidPermutationsWithZero = factorial(n - 1); // reduce the length
            long denominatorWithZero = 1;
            for (int count : freqWithoutLeadingZero) {
                if (count > 1) {
                    denominatorWithZero *= factorial(count);
                }
            }
            invalidPermutationsWithZero /= denominatorWithZero;
            validPermutations -= invalidPermutationsWithZero;
        }

        return validPermutations;
    }

    private static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        if (factorialMemo.containsKey(n)) {
            return factorialMemo.get(n);
        }

        long result = n * factorial(n - 1);
        factorialMemo.put(n, result);
        return result;
    }

    private static String removeLeadingZeroes(String str) {
        int index = 0;
        while (index < str.length() && str.charAt(index) == '0') {
            index++;
        }
        return str.substring(index);
    }

    public static void main(String[] args) {
        String a = "1234", b = "1213";
        System.out.println(findSimilar(a, b));
    }
}
