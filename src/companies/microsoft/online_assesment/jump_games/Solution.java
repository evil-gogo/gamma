package companies.microsoft.online_assesment.jump_games;

//https://algo.monster/problems/jump_game

import java.util.*;

class Solution {
    public static boolean jumpGame(List<Integer> arr, int start) {
        boolean[] isVisited = new boolean[arr.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            int currentIndex = queue.poll();
            isVisited[currentIndex] = true;
            if (arr.get(currentIndex) == 0) {
                return true;
            }
            int nextIndex = currentIndex + arr.get(currentIndex);
            if (nextIndex <= arr.size() - 1 && !isVisited[nextIndex]) {
                queue.add(nextIndex);
            }
            nextIndex = currentIndex - arr.get(currentIndex);
            if (nextIndex >= 0 && !isVisited[nextIndex]) {
                queue.add(nextIndex);
            }
        }
        return false;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        //Integer[] input = {3, 2, 1, 3, 0, 3, 1, 2, 1};
        //int start = 2;

        Integer[] input = {3, 4, 2, 3, 0, 3, 1, 2, 1};
        int start = 7;
        List<Integer> arr = Arrays.asList(input);
        System.out.println(jumpGame(arr, start));
    }
}

