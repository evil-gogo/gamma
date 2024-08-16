package leetcode.e_118_pascal_s_triangle;

//https://leetcode.com/problems/pascals-triangle/description/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(1));

        for (int currentRowIndex = 1; currentRowIndex < numRows; currentRowIndex++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);

            for (int prevRowIndex = 0; prevRowIndex < triangle.get(currentRowIndex - 1).size() - 1; prevRowIndex++) {
                row.add(triangle.get(currentRowIndex - 1).get(prevRowIndex) + triangle.get(currentRowIndex - 1).get(prevRowIndex + 1));
            }

            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> result = generate(numRows);
        System.out.println(result);
    }
}
