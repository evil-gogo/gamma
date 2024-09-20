package leetcode.medium.m_73_set_matrix_zeroes;

//https://leetcode.com/problems/set-matrix-zeroes/description/

import java.util.Arrays;

class Solution {
    public static void setZeroes(int[][] matrix) {
        int rowCount = matrix.length, colCount = matrix[0].length;
        boolean firstRowHasZero = false, firstColHasZero = false;

        for (int col = 0; col < colCount; ++col) {
            if (matrix[0][col] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for (int row = 0; row < rowCount; ++row) {
            if (matrix[row][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        for (int row = 1; row < rowCount; ++row) {
            for (int col = 1; col < colCount; ++col) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < rowCount; ++row) {
            for (int col = 1; col < colCount; ++col) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (firstRowHasZero) {
            for (int col = 0; col < colCount; ++col) {
                matrix[0][col] = 0;
            }
        }

        if (firstColHasZero) {
            for (int row = 0; row < rowCount; ++row) {
                matrix[row][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
