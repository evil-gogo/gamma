package leetcode.h_51_n_queens;

//https://leetcode.com/problems/n-queens/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<List<String>> solveNQueens(int n) {
        int[] columns = new int[n];
        int[] diagonals = new int[2 * n];
        int[] antiDiagonals = new int[2 * n];

        String[][] board = new String[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(board[i], ".");
        }

        List<List<String>> resultPossibleSolutionsList = new ArrayList<>();
        depthFirstSearch(board, n, columns, diagonals, antiDiagonals, 0, resultPossibleSolutionsList);
        return resultPossibleSolutionsList;
    }

    private static void depthFirstSearch(String[][] board, int n, int[] columns, int[] diagonals, int[] antiDiagonals, int row, List<List<String>> resultPossibleSolutionsList) {
        if (row == n) {
            List<String> possibleSolution = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                possibleSolution.add(String.join("", board[i]));
            }

            resultPossibleSolutionsList.add(possibleSolution);
            return;
        }

        for (int col = 0; col < n; ++col) {
            if (columns[col] + diagonals[row + col] + antiDiagonals[n - row + col] == 0) {
                board[row][col] = "Q";
                columns[col] = diagonals[row + col] = antiDiagonals[n - row + col] = 1;
                depthFirstSearch(board, n, columns, diagonals, antiDiagonals, row + 1, resultPossibleSolutionsList);
                columns[col] = diagonals[row + col] = antiDiagonals[n - row + col] = 0;
                board[row][col] = ".";
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
}
