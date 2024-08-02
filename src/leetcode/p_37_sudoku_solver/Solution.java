package leetcode.p_37_sudoku_solver;

//https://leetcode.com/problems/sudoku-solver/description/

import java.util.Arrays;

class Solution {
    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    private static boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char number = '1'; number <= '9'; number++) {
                        if (isValidSudoku(board, i, j, number)) {
                            board[i][j] = number;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidSudoku(char[][] board, int row, int col, char number) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == number) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == number) {
                return false;
            }

        }

        int subGridRowIndex = row / 3 * 3, subGridColumnIndex = col / 3 * 3;

        for (int i = subGridRowIndex; i < subGridRowIndex + 3; i++) {
            for (int j = subGridColumnIndex; j < subGridColumnIndex + 3; j++) {
                if (board[i][j] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }
}
