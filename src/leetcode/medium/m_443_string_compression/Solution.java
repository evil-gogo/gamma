package leetcode.medium.m_443_string_compression;

//https://leetcode.com/problems/string-compression/description/

class Solution {
    public static int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        int counterContinuosChar, indexContinuousChar, indexCharsArray = 0, totalCount = 0;

        for (int i = 0; i < chars.length; i++) {
            indexContinuousChar = i;
            counterContinuosChar = 1;
            while (indexContinuousChar < chars.length - 1 && chars[indexContinuousChar] == chars[indexContinuousChar + 1]) {
                indexContinuousChar++;
                counterContinuosChar++;
            }
            chars[indexCharsArray++] = chars[indexContinuousChar];
            totalCount++;

            String temp = counterContinuosChar + "";
            if (counterContinuosChar > 1) {
                for (int j = 0; j < temp.length(); j++) {
                    chars[indexCharsArray++] = temp.charAt(j);
                    totalCount++;
                }
            }

            i = indexContinuousChar;
        }
        return totalCount;
    }

    public static void main(String[] args) {
        //char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        //char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'};
        char[] chars = {'a', 'b', 'c' };
        System.out.println(compress(chars));
    }
}