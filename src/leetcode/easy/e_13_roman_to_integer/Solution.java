package leetcode.easy.e_13_roman_to_integer;

//https://leetcode.com/problems/roman-to-integer/description/

class Solution {
    public static int romanToInt(String s) {
        int[] roman = new int[26];

        roman['I' - 'A'] = 1;
        roman['V' - 'A'] = 5;
        roman['X' - 'A'] = 10;
        roman['L' - 'A'] = 50;
        roman['C' - 'A'] = 100;
        roman['D' - 'A'] = 500;
        roman['M' - 'A'] = 1000;

        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int currentIntValue = roman[s.charAt(i) - 'A'];
            int nextIntValue = roman[s.charAt(i + 1) - 'A'];
            if (currentIntValue < nextIntValue) {
                result = result - currentIntValue;
            } else {
                result = result + currentIntValue;
            }
        }

        return result + roman[s.charAt(s.length() - 1) - 'A'];
    }

    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(romanToInt(s));
    }
}
