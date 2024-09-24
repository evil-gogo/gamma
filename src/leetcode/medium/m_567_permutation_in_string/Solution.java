package leetcode.medium.m_567_permutation_in_string;

//https://leetcode.com/problems/permutation-in-string/description/

class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        int[] frequencies = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            frequencies[s1.charAt(i) - 'a']++;
        }

        int leftIndex = 0, rightIndex = 0, remainingChars = s1.length();

        while (rightIndex < s2.length()) {
            int rightCharIndex = s2.charAt(rightIndex) - 'a';

            if (frequencies[rightCharIndex] > 0) {
                remainingChars--;
            }

            frequencies[rightCharIndex]--;
            rightIndex++;

            if (remainingChars == 0) {
                return true;
            }

            if (rightIndex - leftIndex == s1.length()) {
                int leftCharIndex = s2.charAt(leftIndex) - 'a';

                if (frequencies[leftCharIndex] >= 0) {
                    remainingChars++;
                }
                frequencies[leftCharIndex]++;
                leftIndex++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }
}
