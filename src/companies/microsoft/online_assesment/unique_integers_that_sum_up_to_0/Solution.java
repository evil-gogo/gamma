package companies.microsoft.online_assesment.unique_integers_that_sum_up_to_0;

//https://algo.monster/problems/unique_integers_that_sum_up_to_0

import java.util.Arrays;

class Solution {
    public static int[] sumZero(int n) {
        int[] res = new int[n];
        int range = n;

        for (int i = 0; i < n/2; i++) {
            res[i] = range;
            res[n - 1 - i] = -range;
            range--;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(Arrays.toString(sumZero(n)));
    }
}
