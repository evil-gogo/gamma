package leetcode.easy.e_933_number_of_recent_calls;

//https://leetcode.com/problems/number-of-recent-calls/description/

import java.util.Deque;
import java.util.LinkedList;

class RecentCounter {
    Deque<Integer> deque;

    public RecentCounter() {
        deque = new LinkedList<>();
    }

    public int ping(int t) {
        deque.offerLast(t);
        while (!deque.isEmpty() && deque.peekFirst() < t - 3000) {
            deque.pollFirst();
        }
        return deque.size();
    }

    public static void main(String[] args) {
        String[] sequence = {"RecentCounter", "ping", "ping", "ping", "ping"};
        int[][] input = {{}, {1}, {100}, {3001}, {3002}};

        RecentCounter obj = null;

        int inputIndex = 0;
        for (String s : sequence) {
            switch (s) {
                case "RecentCounter":
                    obj = new RecentCounter();
                    inputIndex++;
                    break;
                case "ping":
                    assert obj != null;
                    int param_1 = obj.ping(input[inputIndex][0]);
                    System.out.println(param_1);
                    inputIndex++;
                    break;
            }
        }
    }
}
