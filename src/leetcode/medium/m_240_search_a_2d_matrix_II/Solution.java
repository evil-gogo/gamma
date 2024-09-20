package leetcode.medium.m_240_search_a_2d_matrix_II;

//https://leetcode.com/problems/search-a-2d-matrix-ii/description/

class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        int row = 0;
        int col = colCount - 1;

        while (row < rowCount && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        System.out.println(searchMatrix(matrix, target));
    }
}