package leetcode.p_1244_design_a_leaderboard;

//https://leetcode.com/problems/design-a-leaderboard/description/

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Leaderboard {
    private final Map<Integer, Integer> playerScores;
    private final TreeMap<Integer, Integer> sortedScores;

    public Leaderboard() {
        playerScores = new HashMap<>();
        sortedScores = new TreeMap<>((a, b) -> b - a);
    }

    public void addScore(int playerId, int score) {
        playerScores.merge(playerId, score, Integer::sum);
        int updatedScore = playerScores.get(playerId);

        if (updatedScore != score) {
            sortedScores.merge(updatedScore - score, -1, Integer::sum);
        }
        sortedScores.merge(updatedScore, 1, Integer::sum);
    }

    public int top(int K) {
        int sum = 0;

        for (var entry : sortedScores.entrySet()) {
            int score = entry.getKey();
            int count = entry.getValue();

            count = Math.min(count, K);
            sum += score * count;
            K -= count;

            if (K == 0) {
                break;
            }
        }
        return sum;
    }

    public void reset(int playerId) {
        int score = playerScores.remove(playerId);

        if (sortedScores.merge(score, -1, Integer::sum) == 0) {
            sortedScores.remove(score);
        }
    }

    public static void main(String[] args) {
        String[] sequence = {"Leaderboard", "addScore", "addScore", "addScore", "addScore", "addScore", "top", "reset", "reset", "addScore", "top"};
        int[][] input = {{}, {1, 73}, {2, 56}, {3, 39}, {4, 51}, {5, 4}, {1}, {1}, {2}, {2, 51}, {3}};
        Leaderboard leaderBoard = null;
        int inputIndex = 0;
        for (String s : sequence) {
            switch (s) {
                case "Leaderboard":
                    leaderBoard = new Leaderboard();
                    inputIndex++;
                    break;
                case "addScore":
                    assert leaderBoard != null;
                    leaderBoard.addScore(input[inputIndex][0], input[inputIndex][1]);
                    inputIndex++;
                    break;
                case "top":
                    assert leaderBoard != null;
                    System.out.println(leaderBoard.top(input[inputIndex][0]));
                    inputIndex++;
                    break;
                case "reset":
                    assert leaderBoard != null;
                    leaderBoard.reset(input[inputIndex][0]);
                    inputIndex++;
                    break;
            }
        }
    }
}
