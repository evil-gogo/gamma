package leetcode.easy.e_348_design_tic_tac_toe;

//https://leetcode.com/problems/design-tic-tac-toe/description/

class TicTacToe {
    private final int[] rows;
    private final int[] columns;
    private int diagonal;
    private int antiDiagonal;

    public TicTacToe(int n) {
        rows = new int[n];
        columns = new int[n];
    }

    public int move(int row, int col, int player) {
        int n = rows.length;
        int toAdd = (player == 1) ? 1 : -1;

        rows[row] += toAdd;
        columns[col] += toAdd;

        if (row == col) {
            diagonal += toAdd;
        }
        if (row + col == n - 1) {
            antiDiagonal += toAdd;
        }

        if (Math.abs(rows[row]) == n || Math.abs(columns[col]) == n || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n) {
            return player;
        }

        return 0;
    }

    public static void main(String[] args) {
        String[] sequence = {"TicTacToe", "move", "move", "move", "move", "move", "move", "move" };
        int[][] input = {{3}, {0, 0, 1}, {0, 2, 2}, {2, 2, 1}, {1, 1, 2}, {2, 0, 1}, {1, 0, 2}, {2, 1, 1}};

        TicTacToe ticTacToe = null;
        int inputIndex = 0;
        for (String s : sequence) {
            switch (s) {
                case "TicTacToe":
                    ticTacToe = new TicTacToe(input[inputIndex][0]);
                    inputIndex++;
                    break;
                case "move":
                    assert ticTacToe != null;
                    System.out.println(ticTacToe.move(input[inputIndex][0], input[inputIndex][1], input[inputIndex][2]));
                    inputIndex++;
                    break;
            }
        }
    }
}
