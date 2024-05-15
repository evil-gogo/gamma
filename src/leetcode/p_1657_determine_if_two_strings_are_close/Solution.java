package leetcode.p_1657_determine_if_two_strings_are_close;

//https://leetcode.com/problems/determine-if-two-strings-are-close/description/

import java.util.Arrays;

class Solution {
    public static boolean closeStrings(String word1, String word2) {
        int[] frequency1 = new int[26], frequency2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            frequency1[word1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < word2.length(); i++) {
            frequency2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((frequency1[i] > 0 && frequency2[i] == 0) || (frequency2[i] > 0 && frequency1[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(frequency1);
        Arrays.sort(frequency2);

        for (int i = 0; i < 26; i++) {
            if (frequency1[i] != frequency2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String word1 = "abc", word2 = "bca";
        System.out.println(closeStrings(word1, word2));
    }
}

