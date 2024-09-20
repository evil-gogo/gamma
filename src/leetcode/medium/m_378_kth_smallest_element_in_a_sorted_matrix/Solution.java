package leetcode.medium.m_378_kth_smallest_element_in_a_sorted_matrix;

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/

class Solution {
    public static int kthSmallest(int[][] matrix, int k) {
        int dimension = matrix.length;
        int low = matrix[0][0], high = matrix[dimension - 1][dimension - 1];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countLessOrEqual(matrix, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int countLessOrEqual(int[][] matrix, int mid) {
        int count = 0, columnIndex;

        for (int[] matrix_row : matrix) {
            columnIndex = 0;
            while (columnIndex < matrix_row.length && matrix_row[columnIndex] <= mid) {
                columnIndex++;
            }
            count += columnIndex;
        }
        return count;
    }

    public static void main(String[] args) {
        //int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int[][] matrix = {{1, 2}, {1, 3}};
        int k = 4;
        System.out.println(kthSmallest(matrix, k));
    }
}
