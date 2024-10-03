package leetcode.medium.m_1926_nearest_exit_from_entrance_in_maze;

//https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int rowIndex, columnIndex;

    public Pair(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    @Override
    public String toString() {
        return rowIndex + " " + columnIndex;
    }
}

class Solution {
    public static int nearestExit(char[][] maze, int[] entrance) {
        int rowCount = maze.length, columnCount = maze[0].length;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(entrance[0], entrance[1]));
        maze[entrance[0]][entrance[1]] = '+';

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;

            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Pair pair = queue.poll();

                assert pair != null;
                int currentRowIndex = pair.rowIndex, currentColumnIndex = pair.columnIndex;

                for (int directionIndex = 0; directionIndex < 4; directionIndex++) {
                    int nextRow = currentRowIndex + directions[directionIndex][0];
                    int nextColumn = currentColumnIndex + directions[directionIndex][1];

                    if (nextRow >= 0 && nextRow < rowCount && nextColumn >= 0 && nextColumn < columnCount) {
                        if (maze[nextRow][nextColumn] == '.') {
                            if (nextRow == 0 || nextRow == rowCount - 1 || nextColumn == 0 || nextColumn == columnCount - 1) {
                                return steps;
                            }
                            queue.add(new Pair(nextRow, nextColumn));
                            maze[nextRow][nextColumn] = '+';
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char[][] maze = {{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}};
        int[] entrance = {1, 2};
        System.out.println(nearestExit(maze, entrance));
    }
}
