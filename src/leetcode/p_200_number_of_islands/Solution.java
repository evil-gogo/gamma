package leetcode.p_200_number_of_islands;

class Solution {
    public static int numIslands(char[][] grid) {
        int rowsCount = grid.length;
        int columnCount = grid[0].length;

        int count = 0;

        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, rowsCount, columnCount, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int rowsCount, int columnCount, int i, int j) {
        if (i < 0 || i >= rowsCount || j < 0 || j >= columnCount || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '2';

        dfs(grid, rowsCount, columnCount, i, j - 1);
        dfs(grid, rowsCount, columnCount, i - 1, j);
        dfs(grid, rowsCount, columnCount, i, j + 1);
        dfs(grid, rowsCount, columnCount, i + 1, j);
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
