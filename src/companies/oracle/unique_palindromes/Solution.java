package companies.oracle.unique_palindromes;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void findUniquePalindromes(String str) {
        int n = str.length();
        Set<String> palindromeSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String subStr = str.substring(i, j);

                if (isPalindrome(subStr.toCharArray())) {
                    palindromeSet.add(subStr);
                }
            }
        }

        System.out.println(palindromeSet);
    }

    private static boolean isPalindrome(char[] charArray) {
        int leftIndex = 0, rightIndex = charArray.length - 1;

        while (leftIndex <= rightIndex) {
            if (charArray[leftIndex] != charArray[rightIndex]) {
                return false;
            } else {
                leftIndex++;
                rightIndex--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "racecarlevelmadam";
        findUniquePalindromes(input);
    }
}
