package companies.microsoft.online_assesment.longest_substring_without_two_contiguous_occurrences_of_letter;

//https://algo.monster/problems/longest_substring_without_3_contiguous_occurrences_letter

class Solution {

    public static String longestValidString(String str) {
        int maxLength = Integer.MIN_VALUE;
        int countContinuos = 1, startIndex = 0, currentLength = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                countContinuos++;
                currentLength++;
            } else {
                countContinuos = 1;
                currentLength = 0;
            }
            if (countContinuos >= 2) {
                maxLength = Math.max(maxLength, i - startIndex);
                startIndex = i;
            }
        }
        return str.substring(startIndex, startIndex + maxLength - 1);
    }

    public static void main(String[] args) {
        String str = "aabbaaaaabb";
        System.out.println(longestValidString(str));
    }
}
