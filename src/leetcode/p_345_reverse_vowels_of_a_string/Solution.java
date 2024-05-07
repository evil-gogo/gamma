package leetcode.p_345_reverse_vowels_of_a_string;

//https://leetcode.com/problems/reverse-vowels-of-a-string/description/

class Solution {
    public static String reverseVowels(String s) {
        char[] charArray = s.toCharArray();

        int indexL = 0, indexR = s.length() - 1;

        char temp;
        while (indexL <= indexR) {
            while (!isVowel(charArray[indexL]) && indexL < indexR) {
                indexL++;
            }

            while (!isVowel(charArray[indexR]) && indexR > indexL) {
                indexR--;
            }
            temp = charArray[indexL];
            charArray[indexL] = charArray[indexR];
            charArray[indexR] = temp;
            indexL++;
            indexR--;
        }
        return new String(charArray);
    }

    public static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("Hello"));
    }
}