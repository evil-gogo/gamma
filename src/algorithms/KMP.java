package algorithms;

import java.util.Arrays;

public class KMP {
    public static void KMPSearch(String text, String pattern) {
        int[] lps = computeLongestPrefixSuffixArray(pattern);

        System.out.println(Arrays.toString(lps));
        int i = 0, j = 0;
        while (i < text.length() && j < pattern.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                System.out.println("Found pattern " + "at index " + (i - j));
                j = lps[j - 1];
            } else {
                if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                    if (j == 0) {
                        i++;
                    } else {
                        j = lps[j - 1];
                    }
                }
            }
        }
    }

    public static int[] computeLongestPrefixSuffixArray(String pattern) {
        int[] lps = new int[pattern.length()];

        int index = 0, i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(index)) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index == 0) {
                    lps[i] = index;
                    i++;
                } else {
                    index = lps[index - 1];
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        //String pattern = "ABA";
        KMPSearch(text, pattern);
    }
}
