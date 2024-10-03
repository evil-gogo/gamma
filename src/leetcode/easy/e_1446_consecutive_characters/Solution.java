package leetcode.easy.e_1446_consecutive_characters;

//https://leetcode.com/problems/consecutive-characters/description/

class Solution {
    public static int maxPower(String s) {
        int maxPower = 0;
        int leftIndex = 0, rightIndex = 0;
        while (rightIndex < s.length()) {
            while (rightIndex < s.length() && s.charAt(leftIndex) == s.charAt(rightIndex)) {
                rightIndex++;
            }
            maxPower = Math.max(maxPower, rightIndex - leftIndex);
            leftIndex = rightIndex;
            rightIndex++;
        }
        return maxPower;
    }

    public static void main(String[] args) {
        //String s = "ccbccbb";
        String s = "cc";
        //String s = "abbcccddddeeeeedcba";
        System.out.println(maxPower(s));
    }
}
