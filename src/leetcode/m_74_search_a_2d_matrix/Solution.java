package leetcode.m_74_search_a_2d_matrix;

//https://leetcode.com/problems/search-a-2d-matrix/description/

class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowsCount = matrix.length, columnsCount = matrix[0].length;
        int startIndex = 0, endIndex = rowsCount * columnsCount - 1;
        int x, y;
        while (startIndex < endIndex) {
            int midIndex = (startIndex + endIndex) / 2;

            x = midIndex / columnsCount;
            y = midIndex % columnsCount;

            if (matrix[x][y] >= target) {
                endIndex = midIndex;
            } else {
                startIndex = midIndex + 1;
            }
        }
        x = startIndex / columnsCount;
        y = startIndex % columnsCount;

        return matrix[x][y] == target;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }
}
