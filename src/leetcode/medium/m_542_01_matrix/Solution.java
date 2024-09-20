package leetcode.medium.m_542_01_matrix;

//https://leetcode.com/problems/01-matrix/description/

import java.util.Arrays;
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
    public static int[][] updateMatrix(int[][] mat) {
        int rows = mat.length, columns = mat[0].length;
        int[][] distanceMatrix = new int[rows][columns];

        for (int[] row : distanceMatrix) {
            Arrays.fill(row, -1);
        }
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new Pair(i, j));
                    distanceMatrix[i][j] = 0;
                }
            }
        }

        int[] directions = {-1, 0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int currentRowIndex = pair.rowIndex, currentColumnIndex = pair.columnIndex;

            for (int k = 0; k < 4; k++) {
                int newRow = currentRowIndex + directions[k], newCol = currentColumnIndex + directions[k + 1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < columns) {
                    if (distanceMatrix[newRow][newCol] == -1) {
                        distanceMatrix[newRow][newCol] = distanceMatrix[currentRowIndex][currentColumnIndex] + 1;
                        queue.add(new Pair(newRow, newCol));
                    }
                }
            }
        }

        return distanceMatrix;
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
        int[][] distanceMatrix = updateMatrix(mat);
        System.out.println();
        for (int[] row : distanceMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
