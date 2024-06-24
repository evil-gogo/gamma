package leetcode.p_76_minimum_window_substring;

//https://leetcode.com/problems/minimum-window-substring/description/

class Solution {
    public static String minWindow(String source, String target) {
        int[] charFrequencyInTarget = new int[128];

        int sourceLength = source.length(), targetLength = target.length();

        for (int i = 0; i < targetLength; ++i) {
            charFrequencyInTarget[target.charAt(i)]++;
        }

        int windowStart = 0, minWindowStart = -1, matchCount = 0, minLength = Integer.MAX_VALUE;

        for (int windowEnd = 0; windowEnd < sourceLength; windowEnd++) {
            charFrequencyInTarget[source.charAt(windowEnd)]--;

            if (charFrequencyInTarget[source.charAt(windowEnd)] >= 0) {
                matchCount++;
            }

            while (matchCount == targetLength) {
                int windowLength = windowEnd - windowStart + 1;

                if (windowLength < minLength) {
                    minLength = windowLength;
                    minWindowStart = windowStart;
                }

                char charAtStart = source.charAt(windowStart);

                if (charFrequencyInTarget[charAtStart] >= 0) {
                    matchCount--;
                }

                charFrequencyInTarget[charAtStart]++;
                windowStart++;
            }
        }

        return minWindowStart < 0 ? "" : source.substring(minWindowStart, minWindowStart + minLength);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
