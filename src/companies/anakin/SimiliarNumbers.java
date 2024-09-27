package companies.anakin;

import java.util.HashSet;
import java.util.Set;

class Result {
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

        boolean isSimiliar = true;
        for (int i = 0; i < 10; i++) {
            if (freqA[i] != freqB[i]) {
                isSimiliar = false;
                break;
            }
        }
        int[] freq = freqA;
        String str = a;
        if (!isSimiliar) {
            freq = freqB;
            str = b;
        }

        Set<String> result = permute(str.toCharArray());

        return result.size();
    }

    private static int nPr(int n, int r) {
        return fact(n) / fact(n - r);
    }

    private static int fact(int n) {
        if (n <= 1)
            return 1;
        return n * fact(n - 1);
    }


    private static String removeLeadingZeroes(String str) {
        int index = 0;
        while (index < str.length() && str.charAt(index) == '0') {
            index++;
        }
        return str.substring(index);
    }

    private static Set<String> permute(char[] charArray) {
        Set<String> result = new HashSet<>();
        solve(charArray, 0, result);
        return result;
    }

    private static void solve(char[] charArray, int index, Set<String> result) {
        if (index == charArray.length - 1) {
            if (charArray[0] != '0') {
                result.add((String.valueOf(charArray)));
            }
            return;
        }
        for (int i = index; i < charArray.length; i++) {
            swap(charArray, index, i);
            solve(charArray, index + 1, result);
            swap(charArray, index, i);
        }
    }

    private static void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    public static void main(String[] args) {
        String a = "1234", b = "1213";
        System.out.println(findSimilar(a, b));
    }
}