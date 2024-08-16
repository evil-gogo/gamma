package leetcode.h_76_minimum_window_substring;

//https://leetcode.com/problems/minimum-window-substring/description/

class Solution {
    public static String minWindow(String source, String target) {
        int[] charFrequencyInTarget = new int[128];
        int[] charFrequencyInWindow = new int[128];

        int sourceLength = source.length(), targetLength = target.length();

        for (int i = 0; i < targetLength; ++i) {
            charFrequencyInTarget[target.charAt(i)]++;
        }

        int windowStartIndex = 0, minWindowStartIndex = -1, minWindowLength = Integer.MAX_VALUE, matchCount = 0;

        for (int windowEndIndex = 0; windowEndIndex < sourceLength; windowEndIndex++) {
            char charAtWindowEndIndex = source.charAt(windowEndIndex);
            charFrequencyInWindow[charAtWindowEndIndex]++;

            if (charFrequencyInWindow[charAtWindowEndIndex] <= charFrequencyInTarget[charAtWindowEndIndex]) {
                matchCount++;
            }

            while (matchCount == targetLength) {
                int windowLength = windowEndIndex - windowStartIndex + 1;

                if (windowLength < minWindowLength) {
                    minWindowLength = windowLength;
                    minWindowStartIndex = windowStartIndex;
                }

                char charAtWindowStartIndex = source.charAt(windowStartIndex);

                if (charFrequencyInWindow[charAtWindowStartIndex] <= charFrequencyInTarget[charAtWindowStartIndex]) {
                    matchCount--;
                }

                charFrequencyInWindow[charAtWindowStartIndex]--;
                windowStartIndex++;
            }
        }

        return minWindowStartIndex < 0 ? "" : source.substring(minWindowStartIndex, minWindowStartIndex + minWindowLength);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
