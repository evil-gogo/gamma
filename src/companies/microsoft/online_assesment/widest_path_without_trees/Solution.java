package companies.microsoft.online_assesment.widest_path_without_trees;

//https://algo.monster/problems/widest_path_without_trees

import java.util.Arrays;
import java.util.List;

class Solution {
    public static int widestPath(List<Integer> x, List<Integer> y) {
        int maxWidth = 0;

        x.sort(Integer::compareTo);

        for (int i = 0; i < x.size() - 1; i++) {
            maxWidth = Math.max(maxWidth, (x.get(i + 1) - x.get(i)));
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        Integer[] x = {6, 10, 1, 4, 3}, y = {2, 5, 3, 1, 6};
        int res = widestPath(Arrays.asList(x), Arrays.asList(y));
        System.out.println(res);
    }
}
