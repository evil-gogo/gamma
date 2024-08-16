package leetcode.e_1086_high_five;

//https://leetcode.com/problems/high-five/description/

import java.util.*;

class Solution {
    public static int[][] highFive(int[][] items) {
        List<Integer>[] scoresPerStudent = new List[1001];
        for (int i = 0; i < 1001; i++) {
            scoresPerStudent[i] = new ArrayList<>();
        }

        for (int[] item : items) {
            scoresPerStudent[item[0]].add(item[1]);
        }
        for (List<Integer> scores : scoresPerStudent) {
            scores.sort(new Comparator<Integer>() {

                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }

        List<int[]> averageTopFiveScores = new ArrayList<>();

        for (int i = 1; i <= 1000; ++i) {
            List<Integer> scores = scoresPerStudent[i];

            if (!scores.isEmpty()) {
                int sum = 0;
                for (int j = 0; j < Math.min(5, scores.size()); ++j) {
                    sum += scores.get(j);
                }
                averageTopFiveScores.add(new int[]{i, sum / Math.min(5, scores.size())});
            }
        }

        return averageTopFiveScores.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] items = {{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}};
        System.out.println(Arrays.deepToString(highFive(items)));
    }
}
