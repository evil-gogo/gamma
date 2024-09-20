package leetcode.medium.m_994_rotting_oranges;

//https://leetcode.com/problems/rotting-oranges/description/

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
    public static int orangesRotting(int[][] grid) {
        int rowCount = grid.length, columnCount = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        int freshOrangesCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
                if (grid[i][j] == 1) {
                    freshOrangesCount++;
                }
            }
        }
        if (queue.isEmpty()) {
            if (freshOrangesCount > 0) {
                return -1;
            } else {
                return 0;
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int minNumberOfMinutes = 0;
        while (!queue.isEmpty()) {
            minNumberOfMinutes++;

            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Pair pair = queue.poll();
                assert pair != null;
                int currentRowIndex = pair.rowIndex, currentColumnIndex = pair.columnIndex;

                for (int directionIndex = 0; directionIndex < 4; directionIndex++) {
                    int nextRow = currentRowIndex + directions[directionIndex][0];
                    int nextColumn = currentColumnIndex + directions[directionIndex][1];
                    if (nextRow >= 0 && nextRow < rowCount && nextColumn >= 0 && nextColumn < columnCount) {
                        if (grid[nextRow][nextColumn] == 1) {
                            grid[nextRow][nextColumn] = 2;
                            queue.add(new Pair(nextRow, nextColumn));
                            freshOrangesCount--;
                        }
                    }
                }
            }
        }
        if (freshOrangesCount > 0) {
            return -1;
        } else {
            return minNumberOfMinutes - 1;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid));
    }
}
