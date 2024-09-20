package leetcode.medium.m_2018_check_if_word_can_be_placed_in_crossword;

//https://leetcode.com/problems/check-if-word-can-be-placed-in-crossword/description/

class Solution {
    public static boolean placeWordInCrossword(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        int[] directions = {-1, 0, 1, 0, -1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == ' ' || board[i][j] == word.charAt(0)) {

                    for (int k = 0; k < 4; k++) {
                        int prevRow = i - directions[k], prevColumn = j - directions[k + 1];
                        if (!isValid(board, prevRow, prevColumn) || board[prevRow][prevColumn] == '#') {
                            int index = 0, row = i, column = j;
                            while (index < word.length() && isValid(board, row, column) && (board[row][column] == ' ' || board[row][column] == word.charAt(index))) {
                                row += directions[k];
                                column += directions[k + 1];
                                index++;
                            }

                            if (index == word.length() && (!isValid(board, row, column) || board[row][column] == '#')) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    private static boolean isValid(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

    public static void main(String[] args) {
        char[][] board = {{'#', ' ', '#'}, {' ', ' ', '#'}, {'#', 'c', ' '}};
        String word = "abc";
        System.out.println(placeWordInCrossword(board, word));
    }
}
