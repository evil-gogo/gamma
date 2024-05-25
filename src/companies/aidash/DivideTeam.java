package companies.aidash;

//There are A people numbered 1 to A in a cricket academy.
//The coach of the academy wants to make two teams (not necessary of equal size) but unfortunately,
//not all people get along, and several refuse to be put on the same team as that of their enemies.
//Given a 2-D array B of size M * 2 denoting the enemies i.e B[i][0] and B[i][1] both are enemies of each other.
//Return 1 if it possible to make exactly two teams else return 0.
//
//        {
//        {1, 2},
//        {2, 3},
//        {3, 1},
//        {3, 4},
//        {5, 1},
//        {6, 4}
//        }

import java.util.*;

public class DivideTeam {
    public static boolean canMake2Teams(int[][] enemies, int A, int M) {
        ArrayList<Integer>[] adjacencyList = new ArrayList[M + 1];

        // initializing
        for (int i = 0; i < A + 1; i++) {
            adjacencyList[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            adjacencyList[enemies[i][0]].add(enemies[i][1]);
            adjacencyList[enemies[i][1]].add(enemies[i][0]);
        }
        for (int i = 1; i < A + 1; i++) {
            System.out.println((i) + " -> " + adjacencyList[i]);
        }

        Queue<Integer> queue = new LinkedList<Integer>();

        HashSet<Integer> teamA = new HashSet<Integer>();
        HashSet<Integer> teamB = new HashSet<Integer>();

        HashSet<Integer> enemyTeamRef = new HashSet<>();
        HashSet<Integer> nonenemyTeamRef = new HashSet<>();

        boolean[] isVisited = new boolean[A + 1];
        queue.add(1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int employee = queue.poll();
                if (!isVisited[employee]) {
                    isVisited[employee] = true;

                    if (teamA.contains(employee)) {
                        enemyTeamRef = teamB;
                        nonenemyTeamRef = teamA;
                    } else {
                        enemyTeamRef = teamA;
                        nonenemyTeamRef = teamB;
                        teamB.add(employee);
                    }

                    ArrayList<Integer> enemyList = adjacencyList[employee];
                    for (Integer enemyEmployee : enemyList) {
                        queue.add(enemyEmployee);
                        if (nonenemyTeamRef.contains(enemyEmployee)) {
                            return false;
                        }
                        enemyTeamRef.add(enemyEmployee);
                    }
                }
            }
        }
        System.out.println("Team A " + teamA);
        System.out.println("Team B " + teamB);
        return true;
    }

    public static void main(String[] args) {
        System.out.println();
        int A = 6;
        int M = 6;
        int[][] enemies =
                {
                        {1, 2},
                        {2, 3},
                        {4, 5},
                        {3, 5},
                        {4, 2},
                        {6, 5}
                };
        System.out.println(canMake2Teams(enemies, A, M));
    }
}


