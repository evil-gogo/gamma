package leetcode.e_119_pascal_s_triangle_II;

//https://leetcode.com/problems/pascals-triangle-ii/description/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(1));

        for (int currentRowIndex = 1; currentRowIndex <= rowIndex; currentRowIndex++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int prevColIndex = 0; prevColIndex < triangle.get(currentRowIndex - 1).size() - 1; prevColIndex++) {
                row.add(triangle.get(currentRowIndex - 1).get(prevColIndex) + triangle.get(currentRowIndex - 1).get(prevColIndex + 1));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle.get(rowIndex);
    }

    public static void main(String[] args) {
        int rowIndex = 3;
        System.out.println(getRow(rowIndex));
    }
}
