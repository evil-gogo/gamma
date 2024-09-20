package leetcode.medium.m_1456_maximum_number_of_vowels_in_a_substring_of_given_length;

//https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
class Solution {
    public static int maxVowels(String s, int k) {
        int maxVowelCount, currenVowelCount = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currenVowelCount++;
            }
        }
        maxVowelCount = currenVowelCount;
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                currenVowelCount++;
            }
            if (isVowel(s.charAt(i - k))) {
                currenVowelCount--;
            }
            maxVowelCount = Math.max(maxVowelCount, currenVowelCount);
        }
        return maxVowelCount;
    }

    public static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    public static void main(String[] args) {
        //String s = "abciiidef";
        String s = "leetcode";
        int k = 3;
        System.out.println(maxVowels(s, k));
    }
}
