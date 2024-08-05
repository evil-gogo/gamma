package leetcode.p_200_number_of_islands;

//https://leetcode.com/problems/number-of-islands/description/

class Solution {
    static int[] directions = {-1, 0, 1, 0, -1};

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    solve(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void solve(char[][] grid, int row, int col) {
        if (grid[row][col] == '0') {
            return;
        }

        for (int i = 0; i < directions.length - 1; i++) {
            int newRow = row + directions[i];
            int newCol = col + directions[i + 1];

            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == '1') {
                grid[newRow][newCol] = '2';
                solve(grid, newRow, newCol);
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid =
                {
                        {
                                '1', '1', '1', '1', '0'
                        },
                        {
                                '1', '1', '0', '1', '0'
                        },
                        {
                                '1', '1', '0', '0', '0'
                        },
                        {
                                '0', '0', '0', '0', '0'
                        }
                };
        System.out.println(numIslands(grid));
    }
}
