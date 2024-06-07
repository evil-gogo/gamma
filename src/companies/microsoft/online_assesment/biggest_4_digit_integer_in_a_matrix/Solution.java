package companies.microsoft.online_assesment.biggest_4_digit_integer_in_a_matrix;

//https://leetcode.com/discuss/interview-question/645247/toptal-oa-2020-biggest-integer-in-a-matrix

import java.util.Arrays;

class Answer {
    int answer;
}

class Solution {
    private final int MAX_INTEGER_LENGTH = 4;
    private final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private final int[] maxPos;
    private final Answer answer;

    public Solution() {
        this.maxPos = new int[MAX_INTEGER_LENGTH];
        this.answer = new Answer();
    }

    public int solution(int[][] board) {
        // Implement your solution here
        int rows = board.length, columns = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                dfs(board, r, c, 0, 0);
            }
        }

        return answer.answer;
    }

    public void dfs(int[][] board, int r, int c, int pos, int cur) {
        //System.out.println(r + " " + c + Arrays.toString(maxPos));
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == -1) {
            //System.out.println(r + " " + c + " return");
            return;
        }
        cur = cur * 10 + board[r][c];
        if (maxPos[pos] > cur) {
            return;
        }
        maxPos[pos] = cur;
        if (pos == MAX_INTEGER_LENGTH - 1) {
            if (cur > answer.answer) {
                answer.answer = cur;
            }
            return;
        }

        int number = board[r][c];
        board[r][c] = -1;
        for (int[] direction : directions) {
            int newR = direction[0] + r;
            int newC = direction[1] + c;
            dfs(board, newR, newC, pos + 1, cur);
        }
        board[r][c] = number;
    }

    public static void main(String[] args) {
        int[][] board = {{9, 1, 1, 0, 7}, {1, 0, 2, 1, 0}, {1, 9, 1, 1, 0}};
        System.out.println(new Solution().solution(board));
    }
}
