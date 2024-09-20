package leetcode.easy.e_345_reverse_vowels_of_a_string;

//https://leetcode.com/problems/reverse-vowels-of-a-string/description/

class Solution {
    public static String reverseVowels(String s) {
        char[] charArray = s.toCharArray();

        int indexLeft = 0, indexRight = s.length() - 1;

        char temp;
        while (indexLeft <= indexRight) {
            while (!isVowel(charArray[indexLeft]) && indexLeft < indexRight) {
                indexLeft++;
            }

            while (!isVowel(charArray[indexRight]) && indexRight > indexLeft) {
                indexRight--;
            }
            temp = charArray[indexLeft];
            charArray[indexLeft] = charArray[indexRight];
            charArray[indexRight] = temp;
            indexLeft++;
            indexRight--;
        }
        return new String(charArray);
    }

    private static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("Hello"));
    }
}