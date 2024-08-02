package leetcode.p_36_valid_sudoku;

//https://leetcode.com/problems/valid-sudoku/description/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static boolean isValidSudoku(char[][] board) {
        return isValidSudoku1(board);
        //return isValidSudoku2(board);
    }

    private static boolean isValidSudoku1(char[][] board) {
        boolean[][] rows = new boolean[board.length][board[0].length];
        boolean[][] columns = new boolean[board.length][board[0].length];
        boolean[][] subGrids = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int number = board[i][j] - '0' - 1;
                    int subGridIndex = (i / 3) * 3 + j / 3;

                    if (rows[i][number] || columns[j][number] || subGrids[subGridIndex][number]) {
                        return false;
                    }

                    rows[i][number] = true;
                    columns[j][number] = true;
                    subGrids[subGridIndex][number] = true;
                }
            }
        }

        return true;
    }

    private static boolean isValidSudoku2(char[][] board) {
        boolean isValidSudoku = true;
        for (int i = 0; i < board.length; i++) {
            isValidSudoku = validateRows(board, i);
            if (!isValidSudoku) {
                System.out.println(i);
                return isValidSudoku;
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            isValidSudoku = validateColumns(board, i);
            if (!isValidSudoku) {
                return isValidSudoku;
            }
        }

        for (int i = 0; i < board.length; i = i + 3) {
            for (int j = 0; j < board[0].length; j = j + 3) {
                isValidSudoku = validateSubGrid(board, i, j);
                if (!isValidSudoku) {
                    return isValidSudoku;
                }
            }
        }

        return isValidSudoku;
    }

    private static boolean validateRows(char[][] board, int row) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] != '.') {
                if (set.contains(board[row][i])) {
                    return false;
                }
                set.add(board[row][i]);
            }
        }
        return true;
    }

    private static boolean validateColumns(char[][] board, int column) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < board[column].length; i++) {
            if (board[i][column] != '.') {

                if (set.contains(board[i][column])) {
                    return false;
                }
                set.add(board[i][column]);
            }
        }
        return true;
    }

    private static boolean validateSubGrid(char[][] board, int row, int column) {
        Set<Character> set = new HashSet<>();

        for (int i = row; i < row + 3; i++) {
            for (int j = column; j < column + 3; j++) {
                if (board[i][j] != '.') {

                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        char[][] board =
//                {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
//                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
//                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
//                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
//                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
//                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
//                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
//                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
//                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(board));
    }
}
