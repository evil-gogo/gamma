package leetcode.p_1732_find_the_highest_altitude;

//https://leetcode.com/problems/find-the-highest-altitude/description/

class Solution {
    public static int largestAltitude(int[] gain) {
        int maxAltitude = 0, previousAltitude = 0;
        for (int i = 0; i < gain.length; i++) {
            if (gain[i] + previousAltitude > maxAltitude) {
                maxAltitude = gain[i] + previousAltitude;
            }
            previousAltitude = gain[i] + previousAltitude;
        }
        return maxAltitude;
    }

    public static void main(String[] args) {
        //int[] gain = {-4, -3, -2, -1, 4, 3, 2};
        int[] gain = {-5, 1, 5, 0, -7};
        System.out.println(largestAltitude(gain));
    }
}
