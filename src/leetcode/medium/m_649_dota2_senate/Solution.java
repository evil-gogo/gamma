package leetcode.medium.m_649_dota2_senate;

//https://leetcode.com/problems/dota2-senate/description/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static String predictPartyVictory(String senate) {
        int totalSenators = senate.length();
        Deque<Integer> radiantQueue = new ArrayDeque<>();
        Deque<Integer> direQueue = new ArrayDeque<>();

        for (int i = 0; i < totalSenators; i++) {
            if (senate.charAt(i) == 'R') {
                radiantQueue.offerLast(i);
            } else {
                direQueue.offerLast(i);
            }
        }

        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            int radiantIndex = radiantQueue.peekFirst();
            int direIndex = direQueue.peekFirst();

            if (radiantIndex < direIndex) {
                radiantQueue.offerLast(radiantIndex + totalSenators);
            } else {
                direQueue.offerLast(direIndex + totalSenators);
            }

            radiantQueue.pollFirst();
            direQueue.pollFirst();
        }
        return radiantQueue.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        String senate = "RD";
        System.out.println(predictPartyVictory(senate));
    }
}
