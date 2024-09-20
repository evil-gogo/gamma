package leetcode.medium.m_1014_best_sightseeing_pair;

//https://leetcode.com/problems/best-sightseeing-pair/description/

class Solution {
    public static int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0;
        int maxValueWithIndex = values[0] + 0;

        for (int currentIndex = 1; currentIndex < values.length; currentIndex++) {
            maxScore = Math.max(maxScore, (values[currentIndex] - currentIndex) + maxValueWithIndex);

            int currentValueWithIndex = values[currentIndex] + currentIndex;
            maxValueWithIndex = Math.max(maxValueWithIndex, currentValueWithIndex);
        }
        return maxScore;
    }

    public static void main(String[] args) {
        int[] values = {8, 1, 5, 2, 6};
        System.out.println(maxScoreSightseeingPair(values));
    }
}
