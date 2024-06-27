package leetcode.p_1189_maximum_number_of_balloons;

//https://leetcode.com/problems/maximum-number-of-balloons/description/

class Solution {
    public static int maxNumberOfBalloons(String text) {
        int[] charFrequency = new int[26];

        for (int i = 0; i < text.length(); ++i) {
            ++charFrequency[text.charAt(i) - 'a'];
        }

        charFrequency['l' - 'a'] >>= 1;
        charFrequency['o' - 'a'] >>= 1;

        int maxBalloons = Integer.MAX_VALUE;

        for (char c : "balon".toCharArray()) {
            maxBalloons = Math.min(maxBalloons, charFrequency[c - 'a']);
        }
        return maxBalloons;
    }

    public static void main(String[] args) {
        String text = "loonbalxballpoon";
        System.out.println(maxNumberOfBalloons(text));
    }
}
