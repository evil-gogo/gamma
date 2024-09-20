package leetcode.medium.m_911_online_election;

import java.util.*;

class TopVotedCandidate {
    int[] winners;
    int[] times;
    Map<Integer, Integer> mapPlayerVotes;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.winners = new int[persons.length];
        this.times = times;

        this.mapPlayerVotes = new HashMap<>();

        int maxVotesPersonId = 0;
        for (int i = 0; i < times.length; i++) {
            mapPlayerVotes.put(persons[i], mapPlayerVotes.getOrDefault(persons[i], 0) + 1);
            if (mapPlayerVotes.get(persons[i]) >= mapPlayerVotes.get(maxVotesPersonId)) {
                maxVotesPersonId = persons[i];
            }
            winners[i] = maxVotesPersonId;
        }
        //System.out.println(Arrays.toString(winners));
    }

    public int q(int t) {
        int leftIndex = 0, rightIndex = times.length - 1;

        while (leftIndex < rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            if (times[midIndex] == t) {
                //System.out.print(winners[midIndex]);
                return winners[midIndex];
            } else {
                if (times[midIndex] < t) {
                    leftIndex = midIndex + 1;
                } else {
                    rightIndex = midIndex - 1;
                }
            }
        }
        //System.out.print(winners[leftIndex]);
        return winners[leftIndex];
    }

    public static void main(String[] args) {
        String[] sequence = {"TopVotedCandidate", "q", "q", "q", "q", "q", "q" };
        int[][] input = {{}, {3}, {12}, {25}, {15}, {24}, {8}};
        int[] persons = {0, 1, 1, 0, 0, 1, 0};
        int[] times = {0, 5, 10, 15, 20, 25, 30};

        TopVotedCandidate topVotedCandidate = null;
        int inputIndex = 0;
        for (String s : sequence) {
            switch (s) {
                case "TopVotedCandidate":
                    topVotedCandidate = new TopVotedCandidate(persons, times);
                    inputIndex++;
                    break;
                case "q":
                    assert topVotedCandidate != null;
                    topVotedCandidate.q(input[inputIndex][0]);
                    inputIndex++;
                    break;
            }
        }
    }
}
